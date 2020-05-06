package by.chyzh.beerpong.controller;

import by.chyzh.beerpong.dto.CountryDto;
import by.chyzh.beerpong.entity.Country;
import by.chyzh.beerpong.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryRestController {

    private final CountryService countryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryDto> getCountries() {
        return countryService.findAll().stream()
                .map(CountryDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryDto getCountry(@PathVariable("id") Long id) {
        Country country = countryService.findById(id);
        return new CountryDto(country);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CountryDto saveCountry(@RequestBody CountryDto countryDto) {
        return new CountryDto(countryService.save(countryDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCountry(@RequestBody CountryDto cityDto) { countryService.update(cityDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCountry(@PathVariable("id") Long id) {
        countryService.delete(id);
    }
}
