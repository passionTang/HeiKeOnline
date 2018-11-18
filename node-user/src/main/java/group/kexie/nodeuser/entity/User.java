package group.kexie.nodeuser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *  用户
	*@author :tb
	*@version 2018年3月22日 上午11:11:00
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Integer id;

	private String name;
	
	private String icon;

	private String sessionkey;
	
	private String openid;
	/*密码值不序列化 返回到前段*/
	@JsonIgnore
	private String password;
	
	private Integer vipLevel;
	
	private String gender;
	
	private String city;
	
	private String province;
	
	private String country;
	
	private Timestamp registerTime;
	
	private Integer appId;
	

	

	
}


