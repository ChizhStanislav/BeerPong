package by.chyzh.beerpong.service.game;

import by.chyzh.beerpong.dto.game.GameSingleDto;
import by.chyzh.beerpong.entity.game.GameSingle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameSingleService {

    GameSingle save(GameSingleDto gameSingleDto);

    void update(GameSingleDto gameSingleDto);

    void updateFinish(GameSingleDto gameSingleDto);

    void delete(Long id);

    GameSingle findById(Long id);

    List<GameSingle> findAllByTournament(Long tournamentId);
}
