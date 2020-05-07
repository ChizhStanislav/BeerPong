package by.chyzh.beerpong.dto.player;

import by.chyzh.beerpong.dto.tournament.TournamentDto;
import by.chyzh.beerpong.entity.player.Team;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
public class TeamDto {

    private Long id;
    private String name;
    private Long ownerTeamId;
    private Long countryId;
    private Long regionId;
    private Long cityId;
    private LocalDate registrationDate;
    private List<TournamentDto> tournamentDtoList;

    public TeamDto() {

    }

    public TeamDto(Team team) {
        if (team == null) {
            return;
        }
        this.id = team.getId();
        this.name = team.getName();
        this.ownerTeamId = team.getOwnerTeam().getId();
        this.countryId = team.getCountry().getId();
        this.regionId = team.getRegion().getId();
        this.cityId = team.getCity().getId();
        this.registrationDate = team.getRegistrationDate();
        this.tournamentDtoList = team.getTournaments().stream()
                .map(TournamentDto::new)
                .collect(Collectors.toList());
    }
}
