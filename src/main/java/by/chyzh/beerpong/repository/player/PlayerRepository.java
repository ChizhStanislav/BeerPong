package by.chyzh.beerpong.repository.player;

import by.chyzh.beerpong.entity.dictionary.Role;
import by.chyzh.beerpong.entity.player.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Modifying
    @Query("update Player p set p.nickName = :nickName, p.email = :email, p.role =:role, p.country.id =:countryId, " +
            "p.region.id =:regionId, p.city.id =:cityId where p.id = :id ")
    void update(@Param("id") Long id,
                @Param("nickName") String nickName,
                @Param("email") String email,
                @Param("role") Role role,
                @Param("countryId") Long countryId,
                @Param("regionId") Long regionId,
                @Param("cityId") Long cityId);

    @Modifying
    @Query("update Player p set p.password = :password where p.id = :id ")
    void updatePassword(@Param("id") Long id,
                        @Param("password") String password);

    Player findByNickName(String nickName);

    List<Player> findAll();
}
