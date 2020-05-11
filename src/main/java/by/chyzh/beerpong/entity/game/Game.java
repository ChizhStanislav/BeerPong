package by.chyzh.beerpong.entity.game;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.dictionary.Type;
import by.chyzh.beerpong.entity.dictionary.TypeGame;
import by.chyzh.beerpong.entity.tournament.Tournament;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tournament_team_player", schema = "public")
public abstract class Game extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeGame typeGame;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @Column(name ="stage", nullable = false)
    private Byte stage;

    @Column(name = "glass", nullable = false)
    private Byte glass;

    @Column(name = "point")
    private Byte point;

    @Column(name ="start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name ="finish_date", nullable = false)
    private LocalDateTime finishDate;


}
