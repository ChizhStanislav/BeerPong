package by.chyzh.beerpong.service.game;

import by.chyzh.beerpong.dto.game.GameTeamDto;
import by.chyzh.beerpong.entity.game.GameTeam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameTeamService {

    GameTeam save(GameTeamDto gameTeamDto);

    void update(GameTeamDto gameTeamDto);

    void updateFinish(GameTeamDto gameTeamDto);

    void delete(Long id);

    GameTeam findById(Long id);

    List<GameTeam> findAllByTournament(Long tournamentId);
}
