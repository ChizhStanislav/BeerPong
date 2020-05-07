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
    @Query("update Country c set c.name = :name where c.id = :id ")
    void update(@Param("id") Long id,
                @Param("name") String name);

    List<Country> findAll();
}
