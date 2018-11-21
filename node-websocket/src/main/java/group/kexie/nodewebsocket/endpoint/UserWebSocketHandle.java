package group.kexie.nodewebsocket.endpoint;

import group.kexie.logconsumer.entity.LogLevel;
import group.kexie.logconsumer.entity.LogMessage;
import group.kexie.logconsumer.messageprovide.LogProvider;
import group.kexie.nodewebsocket.utils.WebSocketNodeServerParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tangbo
 * @date 2018/11/20 9:49
 * @description: 用户websocket长连接的处理类
 */
public class UserWebSocketHandle implements WebSocketHandler {
    @Autowired
    WebSocketNodeServerParam  nodeServerParam;
    @Autowired
    /*日志工具类*/
    LogProvider logProvider;



    //concurrent包的线程安全Set，用来存放每个客户端对应的连接会话对象
    public static ConcurrentHashMap<String,WebSocketSession>  userSessions = new ConcurrentHashMap<String, WebSocketSession>();


    private Logger logger = Logger.getLogger(UserWebSocketHandle.class);
    /*判断是否是单例*/
    public UserWebSocketHandle() {
        super();
        logger.warn("new  Handle+++++++++");
    }

    /**
     * 连接建立成功调用的方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session)  {
        String connectInfo = "建立长连接成功";
        String userId = session.getAttributes().get("userId").toString();
        try {
            WebSocketMessage<?> message=new TextMessage("连接成功");
            session.sendMessage(message);
            //保存到用户会话集合中
            userSessions.put(userId, session);
        } catch (IOException e) {
            connectInfo = "建立长连接失败," + e.getMessage();
        }finally {
            //向消息中心发送建立信息
            logProvider.provide(new LogMessage("与用户userId:"+userId+ connectInfo, LogLevel.INFO,
                    new Date(), nodeServerParam.getNodeServerName() + "_" + nodeServerParam.
                    getNodeServerHost() + ":" + nodeServerParam.getNodeServerPort()));
        }
    }

    /**
     * 处理客户端发送来的消息,因为本项目没有这个需求,所以无意义
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage)  {

    }
    /**
     * 消息传输过程中出现的异常处理函数
     */
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable)  {
        String userId = webSocketSession.getAttributes().get("userId").toString();
//        向消息中心发送错误信息
        logProvider.provide(new LogMessage("与用户userId:" + userId + "长连接发生错误"+throwable.getMessage(), LogLevel.INFO,
                new Date(), nodeServerParam.getNodeServerName() + "_" + nodeServerParam.
                getNodeServerHost() + ":" + nodeServerParam.getNodeServerPort()));
    }

    /**
     * 连接关闭调用的方法
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)  {
        String userId = session.getAttributes().get("userId").toString();
        userSessions.remove(userId);  //从连接会话集合剔除
        //向消息中心发送关闭信息
        logProvider.provide(new LogMessage("与用户userId:" + userId + "长连接关闭", LogLevel.INFO,
                new Date(), nodeServerParam.getNodeServerName() + "_" + nodeServerParam.
                getNodeServerHost() + ":" + nodeServerParam.getNodeServerPort()));

    }
    /**
     * 是否支持处理拆分消息，返回true返回拆分消息
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }





}
