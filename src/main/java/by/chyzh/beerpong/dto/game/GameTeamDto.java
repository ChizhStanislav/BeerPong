package by.chyzh.beerpong.dto.game;

import by.chyzh.beerpong.entity.game.GameTeam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class GameTeamDto {


    private Long id;
    private String typeGame;
    private Long tournamentId;
    private Byte stage;
    private Byte glass;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private Byte point;
    private Long teamId;

    public GameTeamDto() {

    }

    public GameTeamDto(GameTeam gameTeam) {
        if (gameTeam == null) {
            return;
        }
        this.id = gameTeam.getId();
        this.typeGame = gameTeam.getTypeGame().name();
        this.tournamentId = gameTeam.getTournament().getId();
        this.stage = gameTeam.getStage();
        this.glass = gameTeam.getGlass();
        this.startDate = gameTeam.getStartDate();
        this.finishDate = gameTeam.getFinishDate();
        this.point = gameTeam.getPoint();
        this.teamId = gameTeam.getTeam().getId();
    }
}
