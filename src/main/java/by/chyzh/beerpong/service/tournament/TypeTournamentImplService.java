package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TypeTournamentDto;
import by.chyzh.beerpong.entity.dictionary.Type;
import by.chyzh.beerpong.entity.tournament.TypeTournament;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.tournament.TypeTournamentRepository;
import by.chyzh.beerpong.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TypeTournamentImplService implements TypeTournamentService {

    private final TypeTournamentRepository typeTournamentRepository;
    private final PlayerService playerService;

    @Transactional
    @Override
    public TypeTournament save(TypeTournamentDto typeTournamentDto) {
        return typeTournamentRepository.save(TypeTournament.builder()
                .name(typeTournamentDto.getName())
                .owner(playerService.findById(typeTournamentDto.getOwnerId()))
                .typeGame(Type.valueOf(typeTournamentDto.getTypeGame()))
                .build());
    }

    @Transactional
    @Override
    public void update(TypeTournamentDto typeTournamentDto) {
        typeTournamentRepository.update(typeTournamentDto.getId(), typeTournamentDto.getName(),
                typeTournamentDto.getOwnerId(), Type.valueOf(typeTournamentDto.getTypeGame()));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        typeTournamentRepository.deleteById(id);
    }

    @Override
    public TypeTournament findById(Long id) {
        return typeTournamentRepository.findById(id).orElseThrow(() -> new NotFound("TypeTournament with id=" + id + " not found"));
    }

    @Override
    public List<TypeTournament> findAllByOwner(Long ownerId) {
        return typeTournamentRepository.findAllByOwner(ownerId);
    }
}
