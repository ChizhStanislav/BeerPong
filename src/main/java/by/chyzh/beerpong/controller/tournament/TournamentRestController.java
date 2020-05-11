package by.chyzh.beerpong.controller.tournament;


import by.chyzh.beerpong.dto.tournament.TournamentDto;
import by.chyzh.beerpong.entity.tournament.Tournament;
import by.chyzh.beerpong.service.tournament.TournamentService;
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
@RequestMapping("/tournament")
@RequiredArgsConstructor
public class TournamentRestController {

    private final TournamentService tournamentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDto> getTournaments() {
        return tournamentService.findAllByOwner(3L).stream()
                .map(TournamentDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentDto getTournament(@PathVariable("id") Long id) {
        Tournament tournament = tournamentService.findById(id);
        return new TournamentDto(tournament);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TournamentDto saveTournament(@RequestBody TournamentDto tournamentDto) {
        return new TournamentDto(tournamentService.save(tournamentDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTournament(@RequestBody TournamentDto tournamentDto) {
        tournamentService.update(tournamentDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTournament(@PathVariable("id") Long id) {
        tournamentService.delete(id);
    }
}
