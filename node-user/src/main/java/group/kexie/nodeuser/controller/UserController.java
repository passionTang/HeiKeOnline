package group.kexie.nodeuser.controller;

import group.kexie.nodeuser.entity.RespCode;
import group.kexie.nodeuser.entity.RespEntity;
import group.kexie.nodeuser.entity.User;
import group.kexie.nodeuser.service.UserService;
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
    private UserService userService=null;


    /**
     * 获取用户信息
     */
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody
    public User getUserBaseInfo(@PathVariable("id")Integer userId){

        User user =userService.getUserBaseData(userId);

        //成功响应
//        return new RespEntity(RespCode.SUCCESS, user);
        return  user;
    }

//    /**
//     * 用户关注
//     * @param userConcern
//     * @return
//     */
//    @RequestMapping(value="/concern",method=RequestMethod.POST)
//    @ResponseBody
//    public int userConcern(@RequestBody UserConcern userConcern){
//        return userConcernMapper.insert(userConcern);
//    }
//    /**
//     * 用户取消关注
//     * @param userConcern
//     * @return
//     */
//    @RequestMapping(value="/concern",method=RequestMethod.DELETE)
//    @ResponseBody
//    public int userCancelConcern(@RequestBody UserConcern userConcern){
//        return userConcernMapper.delete(userConcern);
//    }
//
//    /**
//     * 用户注册
//     * @param code
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value="/app{appId}/register",method=RequestMethod.GET)
//    @ResponseBody
//    public User wexinLogin(@PathVariable("appId")int appId,String code) throws Exception{
//        User user=	userService.registerUser(appId,code);
//        user.setSessionkey(null);
//        user.setOpenid(null);
//        //异步 发送欢迎来到黑科Online
//        SystemMsg systemMsg=new SystemMsg(user.getId(), "恭喜你成为黑科Online的首批用户，在今后的相伴的日子里，希望能够得到您的信任和支持。加油吧 黑科大学子^_^", new Timestamp(System.currentTimeMillis()));
//        systemMsgWebsocket.saveAndSendSystemMsg(systemMsg);
//        return user;
//    }
//    /**
//     * 更新用户在数据库中的基本信息
//     * @param user
//     * @return
//     */
//    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
//    @ResponseBody
//    public int updateUserInfo(@RequestBody User user){
//        return userService.updateSelective(user);
//    }
//    /**
//     * 更新用户sessionkey
//     * @param id
//     * @param code
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value="/update",method=RequestMethod.GET)
//    @ResponseBody
//    public User weixinUpdateSession(@Param("appId")int appId,@Param(value="id")Integer id,@Param(value="code")String code) throws Exception{
//        User user=userService.updateSessionKey(appId,id,code);
//        user.setSessionkey(null);
//        user.setOpenid(null);
//        return user;
//    }
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="用户登录请求session_key错误")
//    public String HandleParseException(ParseException exception){
//        Logger.getLogger(getClass()).error("用户登录请求session_key错误"+exception.toString());
//        return "error";
//    }





}


