package by.chyzh.beerpong.controller.game;

import by.chyzh.beerpong.dto.game.GameSingleDto;
import by.chyzh.beerpong.entity.game.GameSingle;
import by.chyzh.beerpong.service.game.GameSingleService;
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
@RequestMapping("/game-single")
@RequiredArgsConstructor
public class GameSingleRestController {

    private final GameSingleService gameSingleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GameSingleDto> getGameSingles() {
        return gameSingleService.findAllByTournament(3L).stream()
                .map(GameSingleDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameSingleDto getGameSingle (@PathVariable("id") Long id) {
        GameSingle gameSingle = gameSingleService.findById(id);
        return new GameSingleDto(gameSingle);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GameSingleDto saveGameSingle(@RequestBody GameSingleDto gameSingleDto) {
        return new GameSingleDto(gameSingleService.save(gameSingleDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGameSingle(@RequestBody GameSingleDto gameSingleDto) {
        gameSingleService.update(gameSingleDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGameSingle(@PathVariable("id") Long id) {
        gameSingleService.delete(id);
    }
}
