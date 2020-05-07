package by.chyzh.beerpong.dto;

import by.chyzh.beerpong.entity.City;
import by.chyzh.beerpong.entity.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CityDto {

    private Long id;
    private String name;
    private Long countryId;
    private Long regionId;

    public CityDto() {

    }

    public CityDto(City city) {
        if (city == null) {
            return;
        }
        this.id = city.getId();
        this.name = city.getName();
        this.countryId = city.getCountry().getId();
        this.regionId = city.getRegion().getId();
    }
}
