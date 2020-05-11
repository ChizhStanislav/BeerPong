package by.chyzh.beerpong.entity.game;

import by.chyzh.beerpong.entity.dictionary.Type;
import by.chyzh.beerpong.entity.dictionary.TypeGame;
import by.chyzh.beerpong.entity.player.Player;
import by.chyzh.beerpong.entity.tournament.Tournament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game", schema = "public")
public class GameSingle extends Game {

    @Builder
    public GameSingle(Type type, TypeGame typeGame, Tournament tournament, Byte stage, Byte glass, Byte point,
                      LocalDateTime startDate, LocalDateTime finishDate, Player player) {
        super(type, typeGame, tournament, stage, glass, point, startDate, finishDate);
        this.player = player;
    }

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
