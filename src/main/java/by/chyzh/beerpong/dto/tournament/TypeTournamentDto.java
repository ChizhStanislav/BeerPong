package by.chyzh.beerpong.dto.tournament;

import by.chyzh.beerpong.entity.tournament.TypeTournament;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TypeTournamentDto {

    private Long id;
    private String name;
    private Long ownerId;
    private String typeGame;

    public TypeTournamentDto() {

    }

    public TypeTournamentDto(TypeTournament typeTournament) {
        if (typeTournament == null) {
            return;
        }
        this.id = typeTournament.getId();
        this.name = typeTournament.getName();
        this.ownerId = typeTournament.getOwner().getId();
        this.typeGame = typeTournament.getTypeGame().name();
    }
}
