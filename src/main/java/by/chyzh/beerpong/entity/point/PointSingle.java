package by.chyzh.beerpong.entity.point;

import by.chyzh.beerpong.entity.game.Game;
import by.chyzh.beerpong.entity.player.Player;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Setter
@Getter
@ToString(exclude = "")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("SINGLE")
public class PointSingle extends Point {

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameSingle;
}
