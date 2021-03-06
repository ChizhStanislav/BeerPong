package by.chyzh.beerpong.controller.location;

import by.chyzh.beerpong.dto.location.RegionDto;
import by.chyzh.beerpong.entity.location.Region;
import by.chyzh.beerpong.service.location.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
