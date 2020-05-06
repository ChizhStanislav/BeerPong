package by.chyzh.beerpong.repository;

import by.chyzh.beerpong.entity.Country;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    @Modifying
    @Query("update Country c set c.nameEnglish = :nameEnglish, c.nameRussian = :nameRussian where c.id = :id ")
    void update(@Param("id") Long id,
                @Param("nameEnglish") String nameEnglish,
                @Param("nameRussian") String nameRussian);

    List<Country> findAll();
}
