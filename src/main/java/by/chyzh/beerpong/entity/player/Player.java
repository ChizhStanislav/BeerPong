package by.chyzh.beerpong.entity.player;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.dictionary.Role;
import by.chyzh.beerpong.entity.location.City;
import by.chyzh.beerpong.entity.location.Country;
import by.chyzh.beerpong.entity.location.Region;
import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@ToString(exclude = "")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player", schema = "public")
public class Player extends BaseEntity<Long> {

    @Column(name = "nick_name", nullable = false, unique = true)
    private String nickName;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
}