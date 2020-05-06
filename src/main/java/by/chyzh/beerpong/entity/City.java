package by.chyzh.beerpong.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Setter
@Getter
@ToString(exclude = "players")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city", schema = "public")
public class City extends BaseEntity<Long> {

    @Column(name = "name_english", nullable = false)
    private String nameEnglish;

    @Column(name = "name_russian", nullable = false)
    private String nameRussian;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "country")
    private List<Player> players;
}
