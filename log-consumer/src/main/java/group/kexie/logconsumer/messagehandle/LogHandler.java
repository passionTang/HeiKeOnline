package group.kexie.logconsumer.messagehandle;

import group.kexie.logconsumer.entity.LogMessage;
import org.apache.log4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author tangbo
 * @date 2018/10/19 18:43
 * @description:对消息日志进行处理
 */
@Component
public class LogHandler {

    private static Logger logger = Logger.getLogger(LogHandler.class);

    @StreamListener(value = "channel-log")
    public void listener( Message<LogMessage> message){

        logger.info("接受到一个消息日志:"+message.getPayload().toString());
    }


}
