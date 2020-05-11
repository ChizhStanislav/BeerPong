package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TypeTournamentDto;
import by.chyzh.beerpong.entity.tournament.TypeTournament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeTournamentService {

    TypeTournament save(TypeTournamentDto typeTournamentDto);

    void update(TypeTournamentDto typeTournamentDto);

    void delete(Long id);

    TypeTournament findById(Long id);

    List<TypeTournament> findAllByOwner(Long ownerId);
}
