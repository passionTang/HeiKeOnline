package group.kexie.nodewebsocket.service;

import com.alibaba.fastjson.JSONObject;
import group.kexie.logconsumer.entity.LogLevel;
import group.kexie.logconsumer.entity.LogMessage;
import group.kexie.logconsumer.messageprovide.LogProvider;
import group.kexie.nodewebsocket.endpoint.UserWebSocketHandle;
import group.kexie.nodewebsocket.entity.RespWebsocketMsg;
import group.kexie.nodewebsocket.entity.RespWebsocketMsg.RespWebsocketMsgKindOf;
import group.kexie.nodewebsocket.entity.SystemMsg;
import group.kexie.nodewebsocket.utils.WebSocketNodeServerParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tangbo
 * @date 2018/11/20 22:30
 * @description:向websocket客户端发送未读的系统消息
 */
@Service
public class SystemMsgService {


    @Autowired@Qualifier("objRedisTemplate")
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    LogProvider logProvider;
    @Autowired
    WebSocketNodeServerParam nodeServerParam;

    /**
     * 给某个用户尝试发送 系统消息 ,失败继续存入cache
     * 考虑并发问题
     * @param systemMsg (userId,text,time)
     *
     */
    public void saveAndSendSystemMsg(SystemMsg systemMsg){
        //接收推送人
        Integer acceptUserId=systemMsg.getUserId();
        String cacheKey="notRead_systemmsg_userId"+acceptUserId;
        //存入缓存 先弹出后选择存入
        List<SystemMsg> systemMsg_cache=(List<SystemMsg>) redisTemplate.opsForList().leftPop(cacheKey);
        if (systemMsg_cache==null) {
            systemMsg_cache=new ArrayList<SystemMsg>();
        }
        systemMsg_cache.add(systemMsg);

        //判断用户是否在线  使用websocket发送
        if (UserWebSocketHandle.userSessions.containsKey(acceptUserId.toString())) {
            WebSocketSession userSession=UserWebSocketHandle.userSessions.get(acceptUserId.toString());
            /*判断用户会话是否畅通*/
            if (userSession.isOpen()) {
                RespWebsocketMsg NotReadMsg=new RespWebsocketMsg(RespWebsocketMsgKindOf.systemMsgs,systemMsg_cache);
                String value=JSONObject.toJSONString(NotReadMsg);
                try {
                    userSession.sendMessage(new TextMessage(value));
                    return;
                } catch (IOException e) {
                    String logInfo="向用户userId"+acceptUserId+"发送未读的"+RespWebsocketMsgKindOf.systemMsgs+"失败,内容:"
                            +value+";errorinfo:"+e.getMessage();
                    logProvider.provide(new LogMessage(logInfo,LogLevel.ERROR,
                            new Date(),nodeServerParam.getNodeServerName()+"_"+nodeServerParam.
                            getNodeServerHost()+":"+nodeServerParam.getNodeServerPort()));
                }
            }
        }
        //发送失败,将最新内容存入redis
        redisTemplate.opsForList().leftPush(cacheKey, systemMsg_cache);//左边存
    }
}
