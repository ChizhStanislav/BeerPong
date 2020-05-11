package by.chyzh.beerpong.service.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentTeamDto;
import by.chyzh.beerpong.entity.tournament.TournamentTeam;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.tournament.TournamentTeamRepository;
import by.chyzh.beerpong.service.player.PlayerService;
import by.chyzh.beerpong.service.player.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TournamentTeamImplService implements TournamentTeamService {

    private final TournamentTeamRepository tournamentTeamRepository;
    private final PlayerService playerService;
    private final TeamService teamService;
    private final TournamentService tournamentService;

    @Transactional
    @Override
    public TournamentTeam save(TournamentTeamDto tournamentTeamDto) {

        return tournamentTeamRepository.save(TournamentTeam.tournamentTeamBuilder()
                .tournament(tournamentService.findById(tournamentTeamDto.getTournamentId()))
                .team(teamService.findById(tournamentTeamDto.getTeamId()))
                .player(playerService.findById(tournamentTeamDto.getPlayerId()))
                .secondPlayer(playerService.findById(tournamentTeamDto.getSecondPlayerId()))
                .registrationDate(LocalDateTime.now())
                .build());
    }

    @Transactional
    @Override
    public void update(TournamentTeamDto tournamentTeamDto) {
        tournamentTeamRepository.update(tournamentTeamDto.getId(), tournamentTeamDto.getTeamId(),
                tournamentTeamDto.getTournamentId(), tournamentTeamDto.getPlayerId(),
                tournamentTeamDto.getSecondPlayerId(), tournamentTeamDto.getPointForTournament(),
                tournamentTeamDto.getRegistrationDate());
    }

    @Transactional
    @Override
    public void updatePoint(TournamentTeamDto tournamentTeamDto) {
        tournamentTeamRepository.updatePoint(tournamentTeamDto.getId(), tournamentTeamDto.getPointForTournament());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        tournamentTeamRepository.deleteById(id);
    }

    @Override
    public TournamentTeam findById(Long id) {
        return tournamentTeamRepository.findByTeamAndTournament(id).orElseThrow(() -> new NotFound("TournamentTeam with id=" + id + " not found"));
    }

    @Override
    public List<TournamentTeam> findAllByTournament(Long tournamentId) {
        return tournamentTeamRepository.findAllByTournament(tournamentId);
    }
}
