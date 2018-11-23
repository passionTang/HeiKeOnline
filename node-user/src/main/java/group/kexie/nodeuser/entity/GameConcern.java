package group.kexie.nodeuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tangbo
 * @date 2018/11/23 9:31
 * @description: 用户的赛事关注
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameConcern {

    private Integer id;

    private Integer userId;

    private Integer gameId;//关注的种类


}
