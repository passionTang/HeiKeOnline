package group.kexie.nodegame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author tangbo
 * @date 2018/11/18 14:30
 * @description: 赛事
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Game {
    enum GameStatus{
        未开赛,
        已结束,
        进行中,
    }

    private Integer id;

    private String name;

    private Integer seasonId;

    private Integer team1Id;

    private Short score1;

    private Integer team2Id;

    private Short score2;

    private String location;//比赛地点

    private Timestamp time;

    private String time_str;

    private GameStatus status;//ex: 未开赛

    private int team1likecount;//队伍1支持数

    private int team2likecount;

    private String mainjudge;//主裁判

    private String otherjudger1;//副裁判1

    private String otherjudger2;//副裁判2

    //绑定类

    private Team team1;
    private Team team2;
    private Season season;
    private List<PointInfo> pointInfos;//赛点
    private List<GameComment> comments;

}

