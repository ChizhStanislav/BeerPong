package by.chyzh.beerpong.repository.tournament;

import by.chyzh.beerpong.entity.tournament.TournamentTeam;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentTeamRepository extends CrudRepository<TournamentTeam, Long> {

    @Modifying
    @Query("update TournamentTeam t set t.player.id = :playerId, t.secondPlayer.id = :secondPlayerId, " +
            "t.pointForTournament =:pointForTournament, t.registrationDate =:registrationDate, " +
            "t.team.id = :teamId,t.tournament.id =:tournamentId where t.id =:id")
    void update(@Param("id") Long id,
                @Param("teamId") Long teamId,
                @Param("tournamentId") Long tournamentId,
                @Param("playerId") Long playerId,
                @Param("secondPlayerId") Long secondPlayerId,
                @Param("pointForTournament") Byte pointForTournament,
                @Param("registrationDate") LocalDateTime registrationDate);

    @Modifying
    @Query("update TournamentTeam t set t.pointForTournament =:pointForTournament where t.id =:id")
    void updatePoint(@Param("id") Long id, @Param("pointForTournament") Byte pointForTournament);

    @Query("select t from TournamentTeam t where t.id = :id")
    Optional<TournamentTeam> findByTeamAndTournament(@Param("id") Long id);

    @Query("select t from TournamentTeam t where t.tournament.id =:tournamentId")
    List<TournamentTeam> findAllByTournament(@Param("tournamentId") Long tournamentId);
}
