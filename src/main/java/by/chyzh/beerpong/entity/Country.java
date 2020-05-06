package by.chyzh.beerpong.entity;

import lombok.*;

import javax.persistence.*;
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

    @Column(name = "name_english", nullable = false, unique = true)
    private String nameEnglish;

    @Column(name = "name_russian", nullable = false, unique = true)
    private String nameRussian;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @OneToMany(mappedBy = "country")
    private List<Player> players;
}
