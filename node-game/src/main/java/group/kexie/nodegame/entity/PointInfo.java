package group.kexie.nodegame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author tangbo
 * @date 2018/11/23 10:57
 * @description:赛点 比赛期间的看点
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PointInfo {
    enum EventKind {
        SCORE,//得分
        YELLOCARD,//黄牌
        READCARD,//红牌
        ChANGE//换人,这里的大小写错误不能改,数据库这个值是固定好了的
    }
    private Integer id;

    private Integer gameId;

    private Integer memberId;

    private String event;

    private String currentscore;//当前比分 "3 : 1"

    private Integer happentime;//发生时间 110'

    private String teamName;

    private EventKind eventKind;


    //绑定类
    private Member member;




}
