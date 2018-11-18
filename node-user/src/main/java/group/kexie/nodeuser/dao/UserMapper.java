package group.kexie.nodeuser.dao;

import group.kexie.nodeuser.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
	*@author :tb
	*@version 2018年3月22日 上午11:27:05
*/
@Repository
public interface UserMapper {

	//配置文件 xxxmapper.xml的方式 适用于复杂db操作
	User selectUserBaseData(@Param("userId") Integer userId);


	//注解方式 适用于简单操作
	@Select("select ***")
	User example();

	
}


