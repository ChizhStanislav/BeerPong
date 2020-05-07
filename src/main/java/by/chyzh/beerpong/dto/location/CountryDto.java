package by.chyzh.beerpong.dto.location;

import by.chyzh.beerpong.entity.location.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
public class CountryDto {

    private Long id;
    private String name;
    private List<RegionDto> regionDtoList;
    private List<CityDto> cityDtoList;

    public CountryDto() {
    }

    public CountryDto(Country country) {
        if (country == null) {
            return;
        }
        this.id = country.getId();
        this.name = country.getName();
        this.cityDtoList = country.getCities().stream()
                .map(CityDto::new)
                .collect(Collectors.toList());
        this.regionDtoList = country.getRegions().stream()
                .map(RegionDto::new)
                .collect(Collectors.toList());
    }
}
