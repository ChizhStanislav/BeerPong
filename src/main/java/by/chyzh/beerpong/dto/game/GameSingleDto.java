package by.chyzh.beerpong.dto.game;

import by.chyzh.beerpong.entity.game.GameSingle;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class GameSingleDto {

    private Long id;
    private String typeGame;
    private Long tournamentId;
    private Byte stage;
    private Byte glass;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private Byte point;
    private Long playerId;

    public GameSingleDto() {

    }

    public GameSingleDto(GameSingle gameSingle) {
        if (gameSingle == null) {
            return;
        }
        this.id = gameSingle.getId();
        this.typeGame = gameSingle.getTypeGame().name();
        this.tournamentId = gameSingle.getTournament().getId();
        this.stage = gameSingle.getStage();
        this.glass = gameSingle.getGlass();
        this.startDate = gameSingle.getStartDate();
        this.finishDate = gameSingle.getFinishDate();
        this.point = gameSingle.getPoint();
        this.playerId = gameSingle.getPlayer().getId();
    }
}
