package top.aiteyou.controller;

import group.kexie.nodeuser.entity.User;
import group.kexie.nodeuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@author :tb
 *@version 2018年4月1日 上午10:51:07
 */
@Controller
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserService userService=null;


    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody
    public User getUserBaseInfo(@PathVariable("id")Integer userId){
        return userService.getUserBaseData(userId);
    }




}


