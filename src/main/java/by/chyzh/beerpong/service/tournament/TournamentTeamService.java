package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentTeamDto;
import by.chyzh.beerpong.entity.tournament.TournamentTeam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentTeamService {

    TournamentTeam save(TournamentTeamDto tournamentTeamDto);

    void update(TournamentTeamDto tournamentTeamDto);

    void updatePoint(TournamentTeamDto tournamentTeamDto);

    void delete(Long id);

    TournamentTeam findById(Long id);

    List<TournamentTeam> findAllByTournament(Long tournamentId);
}
