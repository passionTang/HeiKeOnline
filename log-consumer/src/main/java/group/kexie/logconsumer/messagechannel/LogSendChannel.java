package group.kexie.logconsumer.messagechannel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author tangbo
 * @date 2018/11/17 14:01
 * @description:消息日志通道
 */
public interface LogSendChannel {
    @Output("channel-log")
    MessageChannel output();
}
