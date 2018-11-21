package group.kexie.nodewebsocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tangbo
 * @date 2018/11/20 22:32
 * @description:发送到客户端的websocket消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespWebsocketMsg<T>{
   public enum RespWebsocketMsgKindOf{
        systemMsgs
    }

    /*websocket消息种类 有系统消息,动态消息...*/
    private RespWebsocketMsgKindOf kindof;

    /*消息集合*/
    private List<T> value;
}
