package by.chyzh.beerpong.entity.glass;

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
@Table(name = "glass", schema = "public")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Glass extends BaseEntity<Long> {

    @Column(name = "quantity_glass", nullable = false)
    private Byte quantityGlass;

    @Column(name ="add_date", nullable = false)
    private LocalDateTime addDate;

    @ManyToOne
    @JoinColumn(name = "type_tournament_id")
    private TypeTournament typeTournament;
}
