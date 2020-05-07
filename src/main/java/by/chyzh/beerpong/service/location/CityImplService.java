package by.chyzh.beerpong.service.location;

import by.chyzh.beerpong.dto.location.CityDto;
import by.chyzh.beerpong.entity.location.City;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.location.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CityImplService implements CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;
    private final RegionService regionService;

    @Transactional
    @Override
    public City save(CityDto cityDto) {
        return cityRepository.save(City.builder()
                .name(cityDto.getName())
                .country(countryService.findById(cityDto.getCountryId()))
                .region(regionService.findById(cityDto.getRegionId()))
                .build());
    }

    @Transactional
    @Override
    public void update(CityDto cityDto) {
        cityRepository.update(cityDto.getId(),cityDto.getName(),cityDto.getCountryId(), cityDto.getRegionId());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new NotFound("City with id=" + id + " not found"));
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
