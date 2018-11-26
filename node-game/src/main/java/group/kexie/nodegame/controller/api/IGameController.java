package group.kexie.nodegame.controller.api;

import group.kexie.nodegame.entity.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tangbo
 * @date 2018/11/23 10:48
 * @description:
 */
public interface IGameController {

    /**
     * 查询赛事详情,绑定类根据具体业务
     * @param id
     * @return 返回的时候要将赛事时间格式要转换为 HH:mm
     */
    @GetMapping(value = "/{id}")
    Game selectOneGameDetail(@PathVariable("id") int id);

}
