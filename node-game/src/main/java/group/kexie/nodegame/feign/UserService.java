package group.kexie.nodegame.feign;

import group.kexie.nodeuser.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tangbo
 * @date 2018/10/11 20:11
 * @description: feign声明调用其他服务接口
 */
/*指定服务名  不区分大小写*/
@FeignClient(value = "node-user",fallback = UserServiceFallback.class)/*远程调用失败处理*/
public interface UserService {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User getUser(@PathVariable("id") Integer id);

}

