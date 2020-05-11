package by.chyzh.beerpong.repository.tournament;

import by.chyzh.beerpong.entity.tournament.Tournament;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    @Modifying
    @Query("update Tournament t set t.name = :name, t.ownerTournament.id = :ownerTournamentId, " +
            "t.registrationDate =:registrationDate, t.startDate =:startDate, t.finishDate =:finishDate, " +
            "t.typeTournament.id =:typeTournamentId, t.qualifierGameQuantity =:qualifierGameQuantity  where t.id = :id ")
    void update(@Param("id") Long id,
                @Param("name") String name,
                @Param("ownerTournamentId") Long ownerTournamentId,
                @Param("registrationDate") LocalDateTime registrationDate,
                @Param("startDate") LocalDateTime startDate,
                @Param("finishDate") LocalDateTime finishDate,
                @Param("typeTournamentId") Long typeTournamentId,
                @Param("qualifierGameQuantity") Byte qualifierGameQuantity);

    @Modifying
    @Query("update Tournament t set t.startDate =:startDate where t.id = :id ")
    void updateStartDate(@Param("id") Long id,
                @Param("startDate") LocalDateTime startDate);

    @Modifying
    @Query("update Tournament t set t.finishDate =:finishDate where t.id = :id ")
    void updateFinishDate(@Param("id") Long id,
                @Param("finishDate") LocalDateTime finishDate);

    List<Tournament> findAllByOwnerTournament(Long ownerTournamentId);
}
