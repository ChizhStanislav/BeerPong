package by.chyzh.beerpong.service.location;

import by.chyzh.beerpong.dto.location.RegionDto;
import by.chyzh.beerpong.entity.location.Region;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.location.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionImplService implements RegionService {

    private final CountryService countryService;
    private final RegionRepository regionRepository;

    @Transactional
    @Override
    public Region save(RegionDto regionDto) {
        return regionRepository.save(Region.builder()
                .name(regionDto.getName())
                .country(countryService.findById(regionDto.getCountryId()))
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
