package group.kexie.nodeuser.controller;

import group.kexie.nodeuser.entity.User;
import group.kexie.nodeuser.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *@author :tb
 *@version 2018年4月1日 上午10:51:07
 */
@Controller
@RestController
public class UserController {
    @Autowired
    private IUserService userService=null;


    /**
     * 获取用户信息
     */
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody
    public User getUserBaseInfo(@PathVariable("id")Integer userId){

        User user =userService.getUserBaseData(userId);

        return  user;
    }






}


