package by.chyzh.beerpong.controller;

import by.chyzh.beerpong.dto.RegionDto;
import by.chyzh.beerpong.entity.Region;
import by.chyzh.beerpong.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionRestController {

    private final RegionService regionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RegionDto> getRegions() {
        return regionService.findAll().stream()
                .map(RegionDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegionDto getRegion(@PathVariable("id") Long id) {
        Region region = regionService.findById(id);
        return new RegionDto(region);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RegionDto saveRegion(@RequestBody RegionDto regionDto) {
        return new RegionDto(regionService.save(regionDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateRegion(@RequestBody RegionDto regionDto) {
            regionService.update(regionDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRegion(@PathVariable("id") Long id) {
        regionService.delete(id);
    }
}
