package by.chyzh.beerpong.entity.tournament;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Builder
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournament_team_player", schema = "public")
public class TournamentPlayer extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "point_tournament")
    private Byte pointForTournament;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
}
