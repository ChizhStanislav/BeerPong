package by.chyzh.beerpong.entity.location;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Builder
@Setter
@Getter
@ToString(exclude = {"cities", "players"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country", schema = "public")
public class Country extends BaseEntity<Long> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @OneToMany(mappedBy = "country")
    private List<Region> regions;

    @OneToMany(mappedBy = "country")
    private List<Player> players;
}
