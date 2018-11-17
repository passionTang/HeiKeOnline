package group.kexie.nodeuser;

import group.kexie.logconsumer.entity.LogMessage;
import group.kexie.logconsumer.messagechannel.LogSendChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = NodeUserApplication.class)
public class NodeUserApplicationTests {
    @Autowired
    private LogSendChannel logSendChannel;
    /*指定注入某个通道实例吧 */
//    @Autowired@Qualifier("mychannel")
//    MessageChannel channel;

    /*channel 一个应用中的通道对象 使用这个对象发布消息其他相同key的channel是收不到的,但是通过mySender
     * 发布消息到rabbitmq的话,其他应用的通道就能收到*/

    @Test
    public void contextLoads() {
//        mySender.output().send(MessageBuilder.withPayload("{\"id\":\"1\",\"name\":\"tangbo\"}").build());
//    mySender.output().send(new GenericMessage<>("{\"id\":1,\"name\":\"tangbo\"}"));

        LogMessage logMessage=new LogMessage();
        logMessage.setContent("this is log test content");
        logSendChannel.output().send(new GenericMessage<LogMessage>(logMessage));
    }

}
