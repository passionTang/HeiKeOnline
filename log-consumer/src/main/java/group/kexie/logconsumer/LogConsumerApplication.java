package group.kexie.logconsumer;

import group.kexie.logconsumer.messagechannel.LogReceiveChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/*绑定消息通道*/
@EnableBinding(value = LogReceiveChannel.class)
@SpringBootApplication
public class LogConsumerApplication {



    public static void main(String[] args) {
        SpringApplication.run(LogConsumerApplication.class, args);

    }
}
