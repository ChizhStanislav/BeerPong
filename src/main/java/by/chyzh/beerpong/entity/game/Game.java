package by.chyzh.beerpong.entity.game;

import by.chyzh.beerpong.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game", schema = "public")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Game extends BaseEntity<Long> {

    @Column(name ="start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name ="finish_date", nullable = false)
    private LocalDateTime finishDate;
}
