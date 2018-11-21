package group.kexie.nodewebsocket.web;

import group.kexie.nodewebsocket.entity.SystemMsg;
import group.kexie.nodewebsocket.service.SystemMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangbo
 * @date 2018/11/21 20:08
 * @description:供其他服务远程调用的接口
 */
@RestController
public class FeignController {

    @Autowired
    SystemMsgService systemMsgService;
    @PostMapping (value = "/servercall/send/systemmsg")
    public void sendSystemMsg(@RequestBody SystemMsg systemMsg) {
        systemMsgService.saveAndSendSystemMsg(systemMsg);
    }
//    @PostMapping(value = "/servercall/send/articlemsg")
//    public void sendArticleMsg(@RequestBody ) {
//
//    }

}
