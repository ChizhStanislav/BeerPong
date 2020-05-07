package by.chyzh.beerpong.entity.glass;

import by.chyzh.beerpong.entity.game.Game;
import by.chyzh.beerpong.entity.player.Team;
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
@DiscriminatorValue("TEAM")
public class GlassTeam extends Glass {

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameTeam;
}
