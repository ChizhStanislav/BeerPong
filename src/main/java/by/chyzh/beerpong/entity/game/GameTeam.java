package by.chyzh.beerpong.entity.game;

import by.chyzh.beerpong.entity.dictionary.TypeGame;
import by.chyzh.beerpong.entity.player.Team;
import by.chyzh.beerpong.entity.tournament.Tournament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "game", schema = "public")
@DiscriminatorValue("TEAM")
public class GameTeam extends Game {

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public GameTeam(TypeGame typeGame, Tournament tournament, Byte stage, Byte glass, Byte point,
                    LocalDateTime startDate, LocalDateTime finishDate, Team team) {
        super(typeGame, tournament, stage, glass, point, startDate, finishDate);
        this.team = team;
    }


}
