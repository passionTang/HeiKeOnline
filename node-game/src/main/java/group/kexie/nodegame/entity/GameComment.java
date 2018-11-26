package group.kexie.nodegame.entity;

import group.kexie.nodeuser.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author tangbo
 * @date 2018/11/23 11:00
 * @description:赛事评论
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameComment {
    private Integer id;

    private Integer gameId;

    private Integer userId;

    private String content;

    private Integer likecount;//点赞数

    private Timestamp time;

    private Integer status;

    //绑定类
    private User user;

}
