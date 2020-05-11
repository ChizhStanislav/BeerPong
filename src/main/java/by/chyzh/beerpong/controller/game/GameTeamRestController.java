package by.chyzh.beerpong.controller.game;

import by.chyzh.beerpong.dto.game.GameTeamDto;
import by.chyzh.beerpong.entity.game.GameTeam;
import by.chyzh.beerpong.service.game.GameTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/game-team")
@RequiredArgsConstructor
public class GameTeamRestController {

    private final GameTeamService gameTeamService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GameTeamDto> getGameTeams() {
        return gameTeamService.findAllByTournament(3L).stream()
                .map(GameTeamDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameTeamDto getGameTeam(@PathVariable("id") Long id) {
        GameTeam gameTeam = gameTeamService.findById(id);
        return new GameTeamDto(gameTeam);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GameTeamDto saveGameTeam(@RequestBody GameTeamDto gameTeamDto) {
        return new GameTeamDto(gameTeamService.save(gameTeamDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGameTeam(@RequestBody GameTeamDto gameTeamDto) {
        gameTeamService.update(gameTeamDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGameTeam(@PathVariable("id") Long id) {
        gameTeamService.delete(id);
    }

}
