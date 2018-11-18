package group.kexie.nodeuser.service;

import group.kexie.logconsumer.entity.LogMessage;
import group.kexie.logconsumer.messageprovide.LogProvider;
import group.kexie.nodeuser.dao.UserMapper;
import group.kexie.nodeuser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
	*@author :tb
	*@version 2018年4月1日 上午11:05:59
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	LogProvider logProvider;

	@Autowired
	private UserMapper userMapper=null;
	

	@Cacheable(value="user_baseData",key="'userId' +#userId")
	@Override
	public User getUserBaseData(Integer userId) {
		//对异常进行处理
		LogMessage logMessage = new LogMessage("这是异常的信息", LogMessage.LogLevel.INFO
				, new Date(), "node-user");
		logProvider.provide(logMessage);


		return userMapper.selectUserBaseData(userId);
	}


}


