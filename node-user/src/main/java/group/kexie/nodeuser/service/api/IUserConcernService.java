package group.kexie.nodeuser.service.api;

import group.kexie.nodeuser.entity.GameConcern;

/**
 * @author tangbo
 * @date 2018/11/23 10:12
 * @description:用户关注service 接口
 */
public interface IUserConcernService {
    /**
     * 用户关注某赛事 判断是否已关注
     * @param gameConcern (userId,gameId)
     * @return
     */
    int concernGame(GameConcern gameConcern);

    /**
     * 取消关注某赛事
     * @param gameConcern (userId,gameId)
     * @return
     */
    int unconcernGame(GameConcern gameConcern);




}
