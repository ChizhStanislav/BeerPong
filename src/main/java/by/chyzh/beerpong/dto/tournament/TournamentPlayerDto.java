package by.chyzh.beerpong.dto.tournament;

import by.chyzh.beerpong.entity.tournament.TournamentPlayer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class TournamentPlayerDto {

    private Long id;
    private Long tournamentId;
    private Long playerId;
    private Byte pointForTournament;
    private LocalDateTime registrationDate;

    public TournamentPlayerDto() {

    }

    public TournamentPlayerDto(TournamentPlayer tournamentPlayer) {
        if (tournamentPlayer == null) {
            return;
        }
        this.id = tournamentPlayer.getId();
        this.tournamentId = tournamentPlayer.getTournament().getId();
        this.playerId = tournamentPlayer.getPlayer().getId();
        this.pointForTournament = tournamentPlayer.getPointForTournament();
        this.registrationDate = tournamentPlayer.getRegistrationDate();
    }
}
