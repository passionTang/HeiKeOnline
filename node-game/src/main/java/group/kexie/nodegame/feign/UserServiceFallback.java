package group.kexie.nodegame.feign;

import group.kexie.logconsumer.entity.LogMessage;
import group.kexie.logconsumer.messageprovide.LogProvider;
import group.kexie.nodeuser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tangbo
 * @date 2018/10/12 12:09
 * @description: UserService 降级逻辑实现 能处理hystrix超时异常,运行时异常
 */
@Component
public class UserServiceFallback implements  UserService {
    @Autowired
    LogProvider logProvider;

    @Override
    public User getUser(Integer id) {
        //对远程调用失败异常进行处理
        logProvider.provide(new LogMessage());

        return null;
    }

}
