package group.kexie.nodeuser.service;

import group.kexie.nodeuser.dao.UserMapper;
import group.kexie.nodeuser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
	*@author :tb
	*@version 2018年4月1日 上午11:05:59
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper=null;
	

	@Cacheable(value="user_baseData",key="'userId' +#userId")
	@Override
	public User getUserBaseData(Integer userId) {
		return userMapper.selectUserBaseData(userId);
	}


}


