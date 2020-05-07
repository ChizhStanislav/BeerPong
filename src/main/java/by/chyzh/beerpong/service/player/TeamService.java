package by.chyzh.beerpong.service.player;

import by.chyzh.beerpong.dto.player.TeamDto;
import by.chyzh.beerpong.entity.player.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {

    Team save(TeamDto teamDto);

    void update(TeamDto teamDto);

    void delete(Long id);

    Team findById(Long id);

    List<Team> findAll();
}
