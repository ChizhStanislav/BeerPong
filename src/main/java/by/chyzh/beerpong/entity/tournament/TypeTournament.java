package by.chyzh.beerpong.entity.tournament;

import by.chyzh.beerpong.entity.BaseEntity;
import by.chyzh.beerpong.entity.dictionary.Type;
import by.chyzh.beerpong.entity.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Builder
@Setter
@Getter
@ToString(exclude = "")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_tournament", schema = "public")
public class TypeTournament extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player owner;

    @Enumerated(EnumType.STRING)
    private Type typeGame;
}
