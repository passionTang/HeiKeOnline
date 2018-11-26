package group.kexie.nodegame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author tangbo
 * @date 2018/11/23 10:51
 * @description:参赛队伍
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Team {

    private Integer id;

    private String name;

    private String log;

    private String belongs;

    private String info;

    private String picturesString;

    private String honorString;

    private int captainId;

    private Integer kindOf;//队伍种类,因为不同赛事共用一个队伍类(男篮比赛队伍,男足球比赛队伍,女篮比赛队伍)

    //绑定类
    private Member captain;//队长
    private List<Member> members;//球员

}
