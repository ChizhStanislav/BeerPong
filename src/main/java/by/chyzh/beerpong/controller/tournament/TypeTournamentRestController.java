package by.chyzh.beerpong.controller.tournament;

import by.chyzh.beerpong.dto.tournament.TypeTournamentDto;
import by.chyzh.beerpong.entity.tournament.TypeTournament;
import by.chyzh.beerpong.service.tournament.TypeTournamentService;
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
@RequestMapping("/type-tournament")
@RequiredArgsConstructor
public class TypeTournamentRestController {

    private final TypeTournamentService typeTournamentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TypeTournamentDto> getTypeTournaments() {
        return typeTournamentService.findAllByOwner(3L).stream()
                .map(TypeTournamentDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeTournamentDto getTypeTournament(@PathVariable("id") Long id) {
        TypeTournament typeTournament = typeTournamentService.findById(id);
        return new TypeTournamentDto(typeTournament);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TypeTournamentDto saveTypeTournament(@RequestBody TypeTournamentDto typeTournamentDto) {
        return new TypeTournamentDto(typeTournamentService.save(typeTournamentDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTypeTournament(@RequestBody TypeTournamentDto typeTournamentDto) {
        typeTournamentService.update(typeTournamentDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTypeTournament(@PathVariable("id") Long id) {
        typeTournamentService.delete(id);
    }
}
