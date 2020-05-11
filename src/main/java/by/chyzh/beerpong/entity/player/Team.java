package by.chyzh.beerpong.entity.player;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.location.City;
import by.chyzh.beerpong.entity.location.Country;
import by.chyzh.beerpong.entity.location.Region;
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
    private LocalDateTime registrationDate;

//    @ManyToMany
//    @JoinTable(name = "tournament_team_player", schema = "public",
//            joinColumns = @JoinColumn(name = "team_id"),
//            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
//    private List<Tournament> tournaments;

}
