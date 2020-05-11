package by.chyzh.beerpong.entity.tournament;


import by.chyzh.beerpong.entity.player.Player;
import by.chyzh.beerpong.entity.player.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "tournament_team_player", schema = "public")
@DiscriminatorValue("TEAM")
public class TournamentTeam extends TournamentPlayer {

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "second_player_id")
    private Player secondPlayer;

    @Builder(builderMethodName = "tournamentTeamBuilder")
    public TournamentTeam(Tournament tournament, Player player, Byte pointForTournament,
                          LocalDateTime registrationDate, Team team, Player secondPlayer) {
        super(tournament, player, pointForTournament, registrationDate);
        this.team = team;
        this.secondPlayer = secondPlayer;
    }

}
