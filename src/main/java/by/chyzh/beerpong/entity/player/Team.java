package by.chyzh.beerpong.entity.player;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.tournament.Tournament;
import by.chyzh.beerpong.entity.location.City;
import by.chyzh.beerpong.entity.location.Country;
import by.chyzh.beerpong.entity.location.Region;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
@ToString(exclude = "tournaments")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team", schema = "public")
public class Team extends BaseEntity<Long> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player ownerTeam;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name ="registration_date", nullable = false)
    private LocalDate registrationDate;

    @ManyToMany
    @JoinTable(name = "tournament_team", schema = "public",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    private List<Tournament> tournaments;

}
