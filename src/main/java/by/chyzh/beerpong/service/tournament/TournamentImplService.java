package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentDto;
import by.chyzh.beerpong.entity.tournament.Tournament;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.tournament.TournamentRepository;
import by.chyzh.beerpong.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TournamentImplService implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final PlayerService playerService;
    private final TypeTournamentService typeTournamentService;

    @Transactional
    @Override
    public Tournament save(TournamentDto tournamentDto) {
        return tournamentRepository.save(Tournament.builder()
                .name(tournamentDto.getName())
                .ownerTournament(playerService.findById(tournamentDto.getOwnerTournamentId()))
                .typeTournament(typeTournamentService.findById(tournamentDto.getTypeTournamentId()))
                .registrationDate(LocalDateTime.now())
                .qualifierGameQuantity(tournamentDto.getQualifierGameQuantity())
                .build());
    }

    @Transactional
    @Override
    public void update(TournamentDto tournamentDto) {
        tournamentRepository.update(tournamentDto.getId(), tournamentDto.getName(), tournamentDto.getOwnerTournamentId(),
                tournamentDto.getRegistrationDate(), tournamentDto.getStartDate(), tournamentDto.getFinishDate(),
                tournamentDto.getTypeTournamentId(), tournamentDto.getQualifierGameQuantity());
    }

    @Transactional
    @Override
    public void updateStartDate(Long tournamentId) {
        tournamentRepository.updateStartDate(tournamentId, LocalDateTime.now());
    }

    @Transactional
    @Override
    public void updateFinishDate(Long tournamentId) {
        tournamentRepository.updateFinishDate(tournamentId, LocalDateTime.now());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        tournamentRepository.deleteById(id);
    }

    @Override
    public Tournament findById(Long id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new NotFound("Tournament with id=" + id + " not found"));
    }

    @Override
    public List<Tournament> findAllByOwner(Long ownerTournamentId) {
        return tournamentRepository.findAllByOwnerTournament(ownerTournamentId);
    }
}
