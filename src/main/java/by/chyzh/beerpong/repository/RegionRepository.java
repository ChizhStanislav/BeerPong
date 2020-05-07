package by.chyzh.beerpong.repository;

import by.chyzh.beerpong.entity.City;
import by.chyzh.beerpong.entity.Region;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

    @Modifying
    @Query("update Region r set r.name = :name, r.country.id = :countryId where r.id = :id ")
    void update(@Param("id") Long id,
                @Param("name") String name,
                @Param("countryId") Long countryId);

    List<Region> findAll();
}
