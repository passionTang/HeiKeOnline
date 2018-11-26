package group.kexie.nodegame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author tangbo
 * @date 2018/11/23 10:55
 * @description:赛季 包含多场赛事
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Season {
    private Integer id;

    private String name;

    private String introduce;//赛季介绍

    private String log;//图标

    //绑定类
    private List<Game> joingames;

}
