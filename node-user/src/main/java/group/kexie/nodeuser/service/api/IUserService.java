package group.kexie.nodeuser.service.api;

import group.kexie.nodeuser.entity.User;

import java.util.List;

/**
	*@author :tb
	*@version 2018年11月19日 上午20:25:51
*/

public interface IUserService {


	/**
	 * 注册用户 用户第一次认证小程序 获取用户的sessionKey 和 openId保存到db
	 */
	User registerUser(int appId,String code) ;

	/**
	 * 获取用户基本信息 获取缓存方法
	 */
	User getUserBaseData(Integer userId);

	/**
	 * 到微信公众平台那获取用户的SessionKey,OpenId
	 */
	User getUserOpenIdSessionKey(int appId, String code);

	/**
	 *更新传入的User对象在db的值 清除缓存方法
	 */
	int updateSelective(User user);


	/**
	 * 从微信公众Api那获取用户的SessionKey 并更新该用户在db中的值
	 * 注意不要返回SessionKey和OpenId (这两个值前端不会用到,而且属于私密信息)
	 */
	User updateSessionKey(int appId,Integer id, String code) ;



}


