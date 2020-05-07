package by.chyzh.beerpong.entity.point;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.tournament.TypeTournament;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "point", schema = "public")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Point extends BaseEntity<Long> {

    @Column(name = "quantity_point", nullable = false)
    private Byte quantityPoint;

    @Column(name ="add_date", nullable = false)
    private LocalDateTime addDate;

    @ManyToOne
    @JoinColumn(name = "type_tournament_id")
    private TypeTournament typeTournament;
}
