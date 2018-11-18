package group.kexie.nodegame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
	*@author :tb
	*@version 2018年3月20日 下午2:14:11
*/

@Controller
@RequestMapping(value="/games")
public class GameController {

	@GetMapping
	public void selectOneGameDetail(int gameId){
		
	}


}


