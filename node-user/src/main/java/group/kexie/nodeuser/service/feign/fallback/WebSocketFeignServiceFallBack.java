package group.kexie.nodeuser.service.feign.fallback;

import group.kexie.logconsumer.entity.LogLevel;
import group.kexie.logconsumer.entity.LogMessage;
import group.kexie.logconsumer.messageprovide.LogProvider;
import group.kexie.nodeuser.service.feign.WebSocketFeignService;
import group.kexie.nodeuser.utils.UserNodeServerParam;
import group.kexie.nodewebsocket.entity.SystemMsg;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author tangbo
 * @date 2018/11/21 21:25
 * @description:
 */
public class WebSocketFeignServiceFallBack implements WebSocketFeignService {
    @Autowired
    LogProvider logProvider;
    @Autowired
    UserNodeServerParam nodeServerParam;
    @Override
    public void sendWebSocketSystemMsg(SystemMsg systemMsg) {
        String logInfo="远程调用node-websocket失败,"+systemMsg;
        //feign 远程调用失败
        logProvider.provide(new LogMessage(logInfo,LogLevel.ERROR,
                new Date(),nodeServerParam.getNodeServerName()+"_"+nodeServerParam.
                getNodeServerHost()+":"+nodeServerParam.getNodeServerPort()));
    }
}
