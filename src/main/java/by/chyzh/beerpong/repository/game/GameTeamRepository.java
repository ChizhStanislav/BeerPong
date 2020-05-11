package by.chyzh.beerpong.repository.game;

import by.chyzh.beerpong.entity.dictionary.TypeGame;
import by.chyzh.beerpong.entity.game.GameTeam;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GameTeamRepository extends CrudRepository<GameTeam, Long> {

    @Modifying
    @Query("update GameTeam gt set gt.typeGame = :typeGame, gt.tournament.id =:tournamentId," +
            "gt.stage =:stage, gt.glass =:glass, gt.point =:point, gt.startDate =:startDate, gt.finishDate =:finishDate, " +
            "gt.team.id =:teamId where gt.id = :id ")
    void update(@Param("id") Long id,
                @Param("typeGame") TypeGame typeGame,
                @Param("tournamentId") Long tournamentId,
                @Param("stage") Byte stage,
                @Param("glass") Byte glass,
                @Param("point") Byte point,
                @Param("startDate") LocalDateTime startDate,
                @Param("finishDate") LocalDateTime finishDate,
                @Param("teamId") Long teamId);

    @Modifying
    @Query("update GameTeam gt set gt.glass =:glass, gt.point =:point, gt.finishDate =:finishDate where gt.id = :id ")
    void updateFinish(@Param("id") Long id,
                @Param("glass") Byte glass,
                @Param("point") Byte point,
                @Param("finishDate") LocalDateTime finishDate);

    List<GameTeam> findAllByTournament(Long tournamentId);
}
