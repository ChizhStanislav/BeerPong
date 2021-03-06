package by.chyzh.beerpong.entity.tournament;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.player.Player;
import by.chyzh.beerpong.entity.player.Team;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter
@Getter
@ToString(exclude = "teams")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournament", schema = "public")
public class Tournament extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_tournament_id")
    private Player ownerTournament;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name ="start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name ="finish_date", nullable = false)
    private LocalDateTime finishDate;

    @ManyToOne
    @JoinColumn(name = "type_tournament_id")
    private TypeTournament typeTournament;

    @Column(name ="qualifier_game", nullable = false)
    private Byte qualifierGameQuantity;

    @ManyToMany
    @JoinTable(name = "tournament_team_player", schema = "public",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;
}
