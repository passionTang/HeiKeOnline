package group.kexie.nodeuser.dao;

import group.kexie.nodeuser.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
	*@author :tb
	*@version 2018年3月22日 上午11:27:05
*/
@Repository
public interface UserMapper {


	User selectUserBaseData(@Param("userId") Integer userId);


	
}


