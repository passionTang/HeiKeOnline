package group.kexie.nodegame.service.api;

import group.kexie.nodegame.entity.Game;

/**
 * @author tangbo
 * @date 2018/11/23 11:04
 * @description:
 */
public interface IGameService {

    /**
     * 查询赛事详情 缓存方法
     *  级联:team1
     *           members
     *       team2
     *           members
     *       pointInfos
     *           member
     *       comments
     *           user
     * @param gameId
     * @return
     */
    Game selectOneDetail(int gameId);
}
