package by.chyzh.beerpong.controller.player;

import by.chyzh.beerpong.dto.player.PlayerDto;
import by.chyzh.beerpong.entity.player.Player;
import by.chyzh.beerpong.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerRestController {

    private final PlayerService playerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlayerDto> getPlayers() {
        return playerService.findAll().stream()
                .map(PlayerDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayerDto getPlayer(@PathVariable("id") Long id) {
        Player player = playerService.findById(id);
        return new PlayerDto(player);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PlayerDto savePlayer(@RequestBody PlayerDto playerDto) {
        return new PlayerDto(playerService.save(playerDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePlayer(@RequestBody PlayerDto playerDto) {

        if (Objects.nonNull(playerDto.getPassword())) {
            playerService.updatePassword(playerDto);
        } else {
            playerService.update(playerDto);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.delete(id);
    }
}
