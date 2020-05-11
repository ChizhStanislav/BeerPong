package by.chyzh.beerpong.entity.tournament;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

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

//    @ManyToMany
//    @JoinTable(name = "tournament_team_player", schema = "public",
//            joinColumns = @JoinColumn(name = "tournament_id"),
//            inverseJoinColumns = @JoinColumn(name = "team_id"))
//    private List<Team> teams;
}
