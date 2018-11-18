package group.kexie.logconsumer.messageprovide;

import group.kexie.logconsumer.entity.LogMessage;
import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangbo
 * @date 2018/10/19 18:33
 * @description: 消息日志发送类
 */

public class LogProvider {

    private static Logger logger = Logger.getLogger(LogProvider.class);

    @SendTo(value = "channel-log")
    public LogMessage provide(LogMessage logMessage){
        logger.info("发送一个消息日志:"+logMessage);
        return logMessage;
    }
}
