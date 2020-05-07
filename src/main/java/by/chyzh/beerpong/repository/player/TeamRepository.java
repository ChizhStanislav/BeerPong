package by.chyzh.beerpong.repository.player;

import by.chyzh.beerpong.entity.location.City;
import by.chyzh.beerpong.entity.location.Country;
import by.chyzh.beerpong.entity.location.Region;
import by.chyzh.beerpong.entity.player.Player;
import by.chyzh.beerpong.entity.player.Team;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    @Modifying
    @Query("update Team p set p.name = :name, p.ownerTeam.id = :ownerTeamId, p.country.id =:countryId, " +
            "p.region.id =:regionId, p.city.id =:cityId, p.registrationDate =:registrationDate  where p.id = :id ")
    void update(@Param("id") Long id,
                @Param("name") String name,
                @Param("ownerTeamId") Long ownerTeamId,
                @Param("countryId") Long countryId,
                @Param("regionId") Long regionId,
                @Param("cityId") Long cityId,
                @Param("registrationDate") LocalDate registrationDate);

    List<Team> findAllByOwnerTeam(Player ownerTeam);

    List<Team> findAllByCountry(Country country);

    List<Team> findAllByRegion(Region region);

    List<Team> findAllByCity(City city);

    List<Team> findAll();

}
