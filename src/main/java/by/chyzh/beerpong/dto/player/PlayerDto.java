package by.chyzh.beerpong.dto.player;

import by.chyzh.beerpong.entity.player.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PlayerDto {

    private Long id;
    private String nickName;
    private String password;
    private Long countryId;
    private Long regionId;
    private Long cityId;
    private String email;

    public PlayerDto() {
    }

    public PlayerDto(Player player) {
        if (player == null) {
            return;
        }
        this.id = player.getId();
        this.nickName = player.getNickName();
        this.password = player.getPassword();
        this.countryId = player.getCountry().getId();
        this.regionId = player.getRegion().getId();
        this.cityId = player.getCity().getId();
        this.email = player.getEmail();
    }
}
