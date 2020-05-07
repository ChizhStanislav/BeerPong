package by.chyzh.beerpong.service;

import by.chyzh.beerpong.dto.RegionDto;
import by.chyzh.beerpong.entity.Region;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.CountryRepository;
import by.chyzh.beerpong.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionImplService implements RegionService {

    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;

    @Transactional
    @Override
    public Region save(RegionDto regionDto) {
        return regionRepository.save(Region.builder()
                .name(regionDto.getName())
                .country(countryRepository.findById(regionDto.getCountryId()).orElseThrow(
                        () -> new NotFound("Country with id=" + regionDto.getCountryId() + " not found")))
                .build());
    }

    @Transactional
    @Override
    public void update(RegionDto regionDto) {
        regionRepository.update(regionDto.getId(), regionDto.getName(), regionDto.getCountryId());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).orElseThrow(() -> new NotFound("Region with id=" + id + " not found"));
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }
}
