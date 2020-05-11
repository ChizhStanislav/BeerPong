package by.chyzh.beerpong.controller.player;

import by.chyzh.beerpong.dto.player.TeamDto;
import by.chyzh.beerpong.entity.player.Team;
import by.chyzh.beerpong.service.player.TeamService;
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
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamRestController {

    private final TeamService teamService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamDto> getTeams() {
        return teamService.findAll().stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamDto getTeam (@PathVariable("id") Long id) {
        Team team = teamService.findById(id);
        return new TeamDto(team);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeamDto saveTeam(@RequestBody TeamDto teamDto) {
        return new TeamDto(teamService.save(teamDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTeam(@RequestBody TeamDto teamDto) {
        teamService.update(teamDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTeam(@PathVariable("id") Long id) {
        teamService.delete(id);
    }
}
