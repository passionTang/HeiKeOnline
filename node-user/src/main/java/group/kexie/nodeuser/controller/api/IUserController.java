package group.kexie.nodeuser.controller.api;

import group.kexie.nodeuser.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author tangbo
 * @date 2018/11/19 20:08
 * @description:用户接口
 * @version 1.0.2
 *
 */
public interface IUserController {

    /**
     * 用户注册 根据code获取sessionKey和OpenId并保存; 向客户端推送注册欢迎的webscoket消息
     * @return user对象 (id) 注意不含sessionKey和OpenId等保密信息
     */
    @RequestMapping(value="/app{appId}/register",method=RequestMethod.GET)
    User wexinLogin(@PathVariable("appId")int appId,String code);

    /**
     * 根据用户id获取用户基本信息
     * 字段有:id,name,icon,viplevel,gender,city,province,country,registertime
     * @return 用户对象
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    User getUserBaseInfo(@PathVariable("id") Integer userId) ;

    /**
     * 根据传入的用户信息进行db更新
     *传入的User的基本属性不确定,要进行判空,将'有效'的属性值进行update
     * @param user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    int updateUserInfo(@RequestBody User user);

    /**
     * 更新用户sessionkey
     * @param appId 小程序的标识 0-HeiKeOnline 1-HeiKeMarkets
     * @param id 用户id
     * @param code 每个微信用户的用户标识码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    User weixinUpdateSession(@RequestParam("appId") int appId,
                             @RequestParam(value = "id") Integer id, @RequestParam(value = "code") String code) ;
}
