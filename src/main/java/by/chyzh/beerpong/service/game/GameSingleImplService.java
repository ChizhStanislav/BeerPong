package by.chyzh.beerpong.service.game;

import by.chyzh.beerpong.dto.game.GameSingleDto;
import by.chyzh.beerpong.entity.dictionary.TypeGame;
import by.chyzh.beerpong.entity.game.GameSingle;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.game.GameSingleRepository;
import by.chyzh.beerpong.service.player.PlayerService;
import by.chyzh.beerpong.service.tournament.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameSingleImplService implements GameSingleService {

    private final GameSingleRepository gameTeamRepository;
    private final TournamentService tournamentService;
    private final PlayerService playerService;

    @Transactional
    @Override
    public GameSingle save(GameSingleDto gameSingleDto) {
        return gameTeamRepository.save(GameSingle.builder()
                .typeGame(TypeGame.valueOf(gameSingleDto.getTypeGame()))
                .tournament(tournamentService.findById(gameSingleDto.getTournamentId()))
                .stage(gameSingleDto.getStage())
                .startDate(LocalDateTime.now())
                .player(playerService.findById(gameSingleDto.getPlayerId()))
                .build());
    }

    @Transactional
    @Override
    public void update(GameSingleDto gameSingleDto) {
        gameTeamRepository.update(gameSingleDto.getId(), TypeGame.valueOf(gameSingleDto.getTypeGame()),
                gameSingleDto.getTournamentId(), gameSingleDto.getStage(), gameSingleDto.getGlass(), gameSingleDto.getPoint(),
                gameSingleDto.getStartDate(), gameSingleDto.getFinishDate(), gameSingleDto.getPlayerId());
    }

    @Transactional
    @Override
    public void updateFinish(GameSingleDto gameSingleDto) {
        gameTeamRepository.updateFinish(gameSingleDto.getId(), gameSingleDto.getGlass(), gameSingleDto.getPoint(), gameSingleDto.getFinishDate());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        gameTeamRepository.deleteById(id);
    }

    @Override
    public GameSingle findById(Long id) {
        return gameTeamRepository.findById(id).orElseThrow(() -> new NotFound("GameTeam with id=" + id + " not found"));
    }

    @Override
    public List<GameSingle> findAllByTournament(Long tournamentId) {
        return gameTeamRepository.findAllByTournament(tournamentId);
    }
}
