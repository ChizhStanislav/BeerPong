package by.chyzh.beerpong.repository.tournament;

import by.chyzh.beerpong.entity.tournament.TournamentPlayer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentPlayerRepository extends CrudRepository<TournamentPlayer, Long> {

    @Modifying
    @Query("update TournamentPlayer t set t.player.id = :playerId, t.pointForTournament =:pointForTournament, " +
            "t.registrationDate =:registrationDate, t.tournament.id =:tournamentId where t.id =:id")
    void update(@Param("id") Long id,
                @Param("tournamentId") Long tournamentId,
                @Param("playerId") Long playerId,
                @Param("pointForTournament") Byte pointForTournament,
                @Param("registrationDate") LocalDateTime registrationDate);

    @Modifying
    @Query("update TournamentPlayer t set t.pointForTournament =:pointForTournament where t.id =:id")
    void updatePoint(@Param("id") Long id, @Param("pointForTournament") Byte pointForTournament);

    @Query("select t from TournamentPlayer t where t.id = :id")
    Optional<TournamentPlayer> findByTeamAndTournament(@Param("id") Long id);

    @Query("select t from TournamentPlayer t where t.tournament.id =:tournamentId")
    List<TournamentPlayer> findAllByTournament(@Param("tournamentId") Long tournamentId);
}
