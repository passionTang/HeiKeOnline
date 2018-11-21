package group.kexie.nodewebsocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author tangbo
 * @date 2018/11/20 22:33
 * @description:系统消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemMsg implements Serializable {
    private Integer userId;

    private String text;

    private Timestamp time;

    private Integer importantLevel;
}
