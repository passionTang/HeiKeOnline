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
 * @description:
 */
@Component
public class Provider {

    private static Logger logger = Logger.getLogger(Provider.class);

    @SendTo(value = "channel-log")
    public LogMessage provide(){
        logger.info("provide message :"+"this is log content");

        Map<String, Object> headers = new HashMap<>();
        LogMessage logMessage=new LogMessage();
        logMessage.setContent("this is log content");
        return logMessage;
    }
}
