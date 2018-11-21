package group.kexie.nodeuser.service.feign;

import group.kexie.nodeuser.service.feign.fallback.WebSocketFeignServiceFallBack;
import group.kexie.nodewebsocket.entity.SystemMsg;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author tangbo
 * @date 2018/11/21 21:22
 * @description:远程调用node-websocket服务
 */
@FeignClient(value = "node-websocket",fallback = WebSocketFeignServiceFallBack.class)
public interface WebSocketFeignService {

    /*异步远程调用*/
    @Async
    @PostMapping(value = "/servercall/send/systemmsg")
    void sendWebSocketSystemMsg(SystemMsg systemMsg);


}
