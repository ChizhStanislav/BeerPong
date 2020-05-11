package by.chyzh.beerpong.service.game;

import by.chyzh.beerpong.dto.game.GameTeamDto;
import by.chyzh.beerpong.entity.dictionary.TypeGame;
import by.chyzh.beerpong.entity.game.GameTeam;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.game.GameTeamRepository;
import by.chyzh.beerpong.service.player.TeamService;
import by.chyzh.beerpong.service.tournament.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameTeamImplService implements GameTeamService {

    private final GameTeamRepository gameTeamRepository;
    private final TournamentService tournamentService;
    private final TeamService teamService;

    @Transactional
    @Override
    public GameTeam save(GameTeamDto gameTeamDto) {
        return gameTeamRepository.save(GameTeam.builder()
                .typeGame(TypeGame.valueOf(gameTeamDto.getTypeGame()))
                .tournament(tournamentService.findById(gameTeamDto.getTournamentId()))
                .stage(gameTeamDto.getStage())
                .startDate(gameTeamDto.getStartDate())
                .team(teamService.findById(gameTeamDto.getTeamId()))
                .build());
    }

    @Transactional
    @Override
    public void update(GameTeamDto gameTeamDto) {
        gameTeamRepository.update(gameTeamDto.getId(), TypeGame.valueOf(gameTeamDto.getTypeGame()),
                gameTeamDto.getTournamentId(), gameTeamDto.getStage(), gameTeamDto.getGlass(), gameTeamDto.getPoint(),
                gameTeamDto.getStartDate(), gameTeamDto.getFinishDate(), gameTeamDto.getTeamId());
    }

    @Transactional
    @Override
    public void updateFinish(GameTeamDto gameTeamDto) {
        gameTeamRepository.updateFinish(gameTeamDto.getId(), gameTeamDto.getGlass(), gameTeamDto.getPoint(), gameTeamDto.getFinishDate());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        gameTeamRepository.deleteById(id);
    }

    @Override
    public GameTeam findById(Long id) {
        return gameTeamRepository.findById(id).orElseThrow(() -> new NotFound("GameTeam with id=" + id + " not found"));
    }

    @Override
    public List<GameTeam> findAllByTournament(Long tournamentId) {
        return gameTeamRepository.findAllByTournament(tournamentId);
    }
}
