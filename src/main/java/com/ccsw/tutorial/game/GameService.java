package com.ccsw.tutorial.game;

import java.util.List;

import com.ccsw.tutorial.game.model.Game;
import com.ccsw.tutorial.game.model.GameDto;

public interface GameService {

    List<Game> find(String title, Long idCategory);

    Game get(Long id);

    void save(Long id, GameDto dto);

}
