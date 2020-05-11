package by.chyzh.beerpong.controller.tournament;

import by.chyzh.beerpong.dto.tournament.TournamentTeamDto;
import by.chyzh.beerpong.entity.tournament.TournamentTeam;
import by.chyzh.beerpong.service.tournament.TournamentTeamService;
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
@RequestMapping("/tournament-team")
@RequiredArgsConstructor
public class TournamentTeamResController {

    private final TournamentTeamService tournamentTeamService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentTeamDto> getTournamentTeams() {
        return tournamentTeamService.findAllByTournament(3L).stream()
                .map(TournamentTeamDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentTeamDto getTournamentTeam (@PathVariable("id") Long id) {
        TournamentTeam tournamentTeam = tournamentTeamService.findById(id);
        return new TournamentTeamDto(tournamentTeam);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TournamentTeamDto saveTournamentTeam(@RequestBody TournamentTeamDto tournamentTeamDto) {
        return new TournamentTeamDto(tournamentTeamService.save(tournamentTeamDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTournamentTeam(@RequestBody TournamentTeamDto tournamentTeamDto) {
        tournamentTeamService.update(tournamentTeamDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTournamentTeam(@PathVariable("id") Long id) {
        tournamentTeamService.delete(id);
    }
}
