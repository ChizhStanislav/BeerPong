package by.chyzh.beerpong.repository.tournament;

import by.chyzh.beerpong.entity.dictionary.Type;
import by.chyzh.beerpong.entity.tournament.TypeTournament;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeTournamentRepository extends CrudRepository<TypeTournament, Long> {

    @Modifying
    @Query("update TypeTournament t set t.name = :name, t.owner.id = :ownerId, t.typeGame =:typeGame where t.id = :id")
    void update(@Param("id") Long id,
                @Param("name") String name,
                @Param("ownerId") Long ownerId,
                @Param("typeGame") Type typeGame);

    List<TypeTournament> findAllByOwner(Long OwnerId);
}
