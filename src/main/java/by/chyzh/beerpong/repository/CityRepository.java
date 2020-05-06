package by.chyzh.beerpong.repository;

import by.chyzh.beerpong.entity.City;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    @Modifying
    @Query("update City c set c.nameEnglish = :nameEnglish, c.nameRussian = :nameRussian, c.country.id = :countryId where c.id = :id ")
    void update(@Param("id") Long id,
                @Param("nameEnglish") String nameEnglish,
                @Param("nameRussian") String nameRussian,
                @Param("countryId") Long countryId);

    List<City> findAll();
}
