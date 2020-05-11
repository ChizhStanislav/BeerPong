package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentPlayerDto;
import by.chyzh.beerpong.entity.tournament.TournamentPlayer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentPlayerService {

    TournamentPlayer save(TournamentPlayerDto tournamentPlayerDto);

    void update(TournamentPlayerDto tournamentPlayerDto);

    void updatePoint(TournamentPlayerDto tournamentPlayerDto);

    void delete(Long id);

    TournamentPlayer findById(Long id);

    List<TournamentPlayer> findAllByTournament(Long tournamentId);
}
