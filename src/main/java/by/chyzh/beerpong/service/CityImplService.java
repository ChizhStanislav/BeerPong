package by.chyzh.beerpong.service;

import by.chyzh.beerpong.dto.CityDto;
import by.chyzh.beerpong.entity.City;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.CityRepository;
import by.chyzh.beerpong.repository.CountryRepository;
import by.chyzh.beerpong.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CityImplService implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;

    @Transactional
    @Override
    public City save(CityDto cityDto) {
        return cityRepository.save(City.builder()
                .name(cityDto.getName())
                .country(countryRepository.findById(cityDto.getCountryId()).orElseThrow(
                        () -> new NotFound("Country with id=" + cityDto.getCountryId() + " not found")))
                .region(regionRepository.findById(cityDto.getRegionId()).orElseThrow(
                        () -> new NotFound("Region with id=" + cityDto.getRegionId() + " not found")))
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
