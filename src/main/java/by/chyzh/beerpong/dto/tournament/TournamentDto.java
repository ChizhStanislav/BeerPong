package by.chyzh.beerpong.dto.tournament;

import by.chyzh.beerpong.dto.player.TeamDto;
import by.chyzh.beerpong.entity.tournament.Tournament;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
public class TournamentDto {

    private Long id;
    private String name;
    private Long ownerTournamentId;
    private LocalDateTime registrationDate;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private Long typeTournamentId;
    private Byte qualifierGameQuantity;
    private List<TeamDto> teamDtoList;

    public TournamentDto() {

    }

    public TournamentDto(Tournament tournament) {
        if (tournament == null) {
            return;
        }
        this.id = tournament.getId();
        this.name = tournament.getName();
        this.ownerTournamentId = tournament.getOwnerTournament().getId();
        this.registrationDate = tournament.getRegistrationDate();
        this.startDate = tournament.getStartDate();
        this.finishDate = tournament.getFinishDate();
        this.typeTournamentId = tournament.getTypeTournament().getId();
        this.qualifierGameQuantity = tournament.getQualifierGameQuantity();
//        this.teamDtoList = tournament.getTeams().stream()
//                .map(TeamDto::new)
//                .collect(Collectors.toList());
    }
}
