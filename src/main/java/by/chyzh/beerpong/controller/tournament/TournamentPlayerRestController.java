package by.chyzh.beerpong.controller.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentPlayerDto;
import by.chyzh.beerpong.entity.tournament.TournamentPlayer;
import by.chyzh.beerpong.service.tournament.TournamentPlayerService;
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
@RequestMapping("/tournament-player")
@RequiredArgsConstructor
public class TournamentPlayerRestController {

    private final TournamentPlayerService tournamentPlayerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentPlayerDto> getTournamentPlayers() {
        return tournamentPlayerService.findAllByTournament(3L).stream()
                .map(TournamentPlayerDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentPlayerDto getTournamentPlayer (@PathVariable("id") Long id) {
        TournamentPlayer tournamentPlayer = tournamentPlayerService.findById(id);
        return new TournamentPlayerDto(tournamentPlayer);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TournamentPlayerDto saveTournamentPlayer(@RequestBody TournamentPlayerDto tournamentPlayerDto) {
        return new TournamentPlayerDto(tournamentPlayerService.save(tournamentPlayerDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTournamentPlayer(@RequestBody TournamentPlayerDto tournamentPlayerDto) {
        tournamentPlayerService.update(tournamentPlayerDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTournamentPlayer(@PathVariable("id") Long id) {
        tournamentPlayerService.delete(id);
    }
}
