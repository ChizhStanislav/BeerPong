package by.chyzh.beerpong.dto;

import by.chyzh.beerpong.entity.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CountryDto {

    private Long id;
    private String nameEnglish;
    private String nameRussian;

    public CountryDto() {
    }

    public CountryDto(Country country) {
        if (country == null) {
            return;
        }
        this.id = country.getId();
        this.nameEnglish = country.getNameEnglish();
        this.nameRussian = country.getNameRussian();
    }
}
