package by.chyzh.beerpong.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_english", nullable = false, unique = true)
    private String nameEnglish;

    @Column(name = "name_russian", nullable = false, unique = true)
    private String nameRussian;

    @OneToMany(mappedBy = "country")
    private List<Player> players;
}
