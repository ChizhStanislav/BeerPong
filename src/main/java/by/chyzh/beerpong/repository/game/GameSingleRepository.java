package by.chyzh.beerpong.repository.game;

import by.chyzh.beerpong.entity.dictionary.Type;
import by.chyzh.beerpong.entity.dictionary.TypeGame;
import by.chyzh.beerpong.entity.game.GameSingle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GameSingleRepository extends CrudRepository<GameSingle, Long> {

    @Modifying
    @Query("update GameSingle gs set gs.type = :type, gs.typeGame = :typeGame, gs.tournament.id =:tournamentId," +
            "gs.stage =:stage, gs.glass =:glass, gs.point =:point, gs.startDate =:startDate, gs.finishDate =:finishDate, " +
            "gs.player.id =:playerId where gs.id = :id ")
    void update(@Param("id") Long id,
                @Param("type") Type type,
                @Param("typeGame") TypeGame typeGame,
                @Param("tournamentId") Long tournamentId,
                @Param("stage") Byte stage,
                @Param("glass") Byte glass,
                @Param("point") Byte point,
                @Param("startDate") LocalDateTime startDate,
                @Param("finishDate") LocalDateTime finishDate,
                @Param("playerId") Long playerId);

    @Modifying
    @Query("update GameSingle gs set gs.glass =:glass, gs.point =:point, gs.finishDate =:finishDate where gs.id = :id ")
    void updateFinish(@Param("id") Long id,
                      @Param("glass") Byte glass,
                      @Param("point") Byte point,
                      @Param("finishDate") LocalDateTime finishDate);

    List<GameSingle> findAllByTournament(Long tournamentId);
}
