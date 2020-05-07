package by.chyzh.beerpong.entity.tournament;


import by.chyzh.beerpong.entity.player.Player;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournament_team", schema = "public")
public class TournamentTeam {

    @EmbeddedId
    private TournamentTeamId id;

    @ManyToOne
    @JoinColumn(name = "first_player_id")
    private Player firstPlayer;

    @ManyToOne
    @JoinColumn(name = "second_player_id")
    private Player secondPlayer;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Builder
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class TournamentTeamId implements Serializable {

        @Column(name = "tournament_id")
        private Long tournamentId;

        @Column(name = "team_id")
        private Long teamId;
    }
}
