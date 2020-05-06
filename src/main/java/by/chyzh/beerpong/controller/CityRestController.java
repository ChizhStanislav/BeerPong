package by.chyzh.beerpong.controller;

import by.chyzh.beerpong.dto.CityDto;
import by.chyzh.beerpong.entity.City;
import by.chyzh.beerpong.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityRestController {

    private final CityService cityService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityDto> getCities() {
        return cityService.findAll().stream()
                .map(CityDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CityDto getCity(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        return new CityDto(city);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CityDto saveCity(@RequestBody CityDto cityDto) {
        return new CityDto(cityService.save(cityDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCity(@RequestBody CityDto cityDto) {
        cityService.update(cityDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.delete(id);
    }
}
