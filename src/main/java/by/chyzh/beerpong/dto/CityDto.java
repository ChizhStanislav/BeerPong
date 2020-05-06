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
    private String nameEnglish;
    private String nameRussian;
    private Long countryId;

    public CityDto() {

    }

    public CityDto(City city) {
        if (city == null) {
            return;
        }
        this.id = city.getId();
        this.nameEnglish = city.getNameEnglish();
        this.nameRussian = city.getNameRussian();
        this.countryId = city.getCountry().getId();
    }
}
