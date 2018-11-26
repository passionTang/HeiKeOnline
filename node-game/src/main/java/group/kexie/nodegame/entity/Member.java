package group.kexie.nodegame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author tangbo
 * @date 2018/11/23 10:53
 * @description:参加赛事的成员
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private Integer id;

    private Integer teamId;

    private String name;

    private String brithday;

    private String position;//位置

    private String icon;

    private String signature;//个性签名

    private String alias;//绰号

    private Integer number;//球衣号码


    //绑定类
    private Team team;//效力的队伍

}
