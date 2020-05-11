package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentPlayerDto;
import by.chyzh.beerpong.entity.tournament.TournamentPlayer;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.tournament.TournamentPlayerRepository;
import by.chyzh.beerpong.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TournamentPlayerImplService implements TournamentPlayerService {

    private final TournamentPlayerRepository tournamentPlayerRepository;
    private final PlayerService playerService;
    private final TournamentService tournamentService;

    @Transactional
    @Override
    public TournamentPlayer save(TournamentPlayerDto tournamentPlayerDto) {
        return tournamentPlayerRepository.save(TournamentPlayer.builder()
                .tournament(tournamentService.findById(tournamentPlayerDto.getTournamentId()))
                .player(playerService.findById(tournamentPlayerDto.getPlayerId()))
                .registrationDate(LocalDateTime.now())
                .build());
    }

    @Transactional
    @Override
    public void update(TournamentPlayerDto tournamentPlayerDto) {
        tournamentPlayerRepository.update(tournamentPlayerDto.getId(), tournamentPlayerDto.getTournamentId(),
                tournamentPlayerDto.getPlayerId(), tournamentPlayerDto.getPointForTournament(),
                tournamentPlayerDto.getRegistrationDate());
    }

    @Transactional
    @Override
    public void updatePoint(TournamentPlayerDto tournamentPlayerDto) {
        tournamentPlayerRepository.updatePoint(tournamentPlayerDto.getId(), tournamentPlayerDto.getPointForTournament());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        tournamentPlayerRepository.deleteById(id);
    }

    @Override
    public TournamentPlayer findById(Long id) {
        return tournamentPlayerRepository.findByTeamAndTournament(id).orElseThrow(() -> new NotFound("TournamentTeam with id=" + id + " not found"));
    }

    @Override
    public List<TournamentPlayer> findAllByTournament(Long tournamentId) {
        return tournamentPlayerRepository.findAllByTournament(tournamentId);
    }
}
