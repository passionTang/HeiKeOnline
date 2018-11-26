package group.kexie.nodegame.service;

import group.kexie.nodegame.entity.Game;
import group.kexie.nodegame.feign.UserService;
import group.kexie.nodeuser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tangbo
 * @date 2018/11/18 14:30
 * @description:
 */
public class GameServiceImpl {

    @Autowired
    UserService userService;

    public Game selectOneDetail(int gameId){
        //调用 game 的dao 查找
        Game game=null;


        //但是还需要user的信息,这个时候就需要调用用户服务的接口获取
        User user =userService.getUser(1);


        //最后进行融合
        return game;
    }
}
