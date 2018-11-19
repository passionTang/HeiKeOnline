package group.kexie.logconsumer.messageprovide;

import group.kexie.logconsumer.entity.LogMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author tangbo
 * @date 2018/10/19 18:33
 * @description: 消息日志发送工具类
 */
public class LogProvider {
    /*指定日志消息通道*/
    @Autowired @Qualifier("channel-log")
    MessageChannel logChannel;

    private static Logger logger = Logger.getLogger(LogProvider.class);

    public void provide(LogMessage logMessage){
        logger.info("发送一个消息日志:"+logMessage);


        logChannel.send(MessageBuilder.withPayload(logMessage).build());
    }
}
