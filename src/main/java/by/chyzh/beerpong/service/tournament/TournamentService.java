package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentDto;
import by.chyzh.beerpong.entity.tournament.Tournament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentService {

    Tournament save(TournamentDto tournamentDto);

    void update(TournamentDto tournamentDto);

    void updateStartDate(Long tournamentId);

    void updateFinishDate(Long tournamentId);

    void delete(Long id);

    Tournament findById(Long id);

    List<Tournament> findAllByOwner(Long ownerTournamentId);
}
