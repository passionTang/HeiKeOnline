package group.kexie.logconsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author tangbo
 * @date 2018/11/17 13:41
 * @description:消息日志的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LogMessage {
    public enum LogLevel{
        DEBUG,
        INFO,
        WARN,
        ERROR
    }
    /*日志内容*/
    private String content;
    /*日志等级*/
    private LogLevel logLevel;
    /*发生时间*/
    private Date date;
    /*发生节点(服务)*/
    private String node;

}
