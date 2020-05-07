package by.chyzh.beerpong.dto.location;

import by.chyzh.beerpong.dto.player.PlayerDto;
import by.chyzh.beerpong.entity.location.Region;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
public class RegionDto {

    private Long id;
    private String name;
    private Long countryId;
    private List<CityDto> cityDtoList;
    private List<PlayerDto> playerDtoList;

    public RegionDto() {

    }

    public RegionDto(Region region) {
        if (region == null) {
            return;
        }
        this.id = region.getId();
        this.name = region.getName();
        this.countryId = region.getCountry().getId();
        this.cityDtoList = region.getCities().stream()
                .map(CityDto::new)
                .collect(Collectors.toList());
        this.playerDtoList = region.getPlayers().stream()
                .map(PlayerDto::new)
                .collect(Collectors.toList());
    }
}
