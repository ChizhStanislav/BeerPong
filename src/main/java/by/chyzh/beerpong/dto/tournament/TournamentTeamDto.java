package by.chyzh.beerpong.dto.tournament;

import by.chyzh.beerpong.entity.tournament.TournamentTeam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class TournamentTeamDto {

    private Long id;
    private Long tournamentId;
    private Long teamId;
    private Long playerId;
    private Long secondPlayerId;
    private Byte pointForTournament;
    private LocalDateTime registrationDate;

    public TournamentTeamDto() {

    }

    public TournamentTeamDto(TournamentTeam tournamentTeam) {
        if (tournamentTeam == null) {
            return;
        }
        this.id = tournamentTeam.getId();
        this.tournamentId = tournamentTeam.getTournament().getId();
        this.teamId = tournamentTeam.getTeam().getId();
        this.playerId = tournamentTeam.getPlayer().getId();
        this.secondPlayerId = tournamentTeam.getSecondPlayer().getId();
        this.pointForTournament = tournamentTeam.getPointForTournament();
        this.registrationDate = tournamentTeam.getRegistrationDate();
    }
}
