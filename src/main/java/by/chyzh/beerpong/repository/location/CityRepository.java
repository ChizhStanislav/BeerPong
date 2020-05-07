package by.chyzh.beerpong.repository.location;

import by.chyzh.beerpong.entity.location.City;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    @Modifying
    @Query("update City c set c.name = :name, c.country.id = :countryId, c.region.id =:regionId where c.id = :id")
    void update(@Param("id") Long id,
                @Param("name") String name,
                @Param("countryId") Long countryId,
                @Param("regionId") Long regionId);

    List<City> findAll();
}
