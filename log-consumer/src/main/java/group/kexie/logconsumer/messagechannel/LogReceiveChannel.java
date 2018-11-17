package group.kexie.logconsumer.messagechannel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author tangbo
 * @date 2018/11/17 14:01
 * @description:消息日志通道
 */
public interface LogReceiveChannel {
    @Input("channel-log")
    SubscribableChannel receive();
}
