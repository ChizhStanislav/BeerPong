package by.chyzh.beerpong.service.location;

import by.chyzh.beerpong.dto.location.RegionDto;
import by.chyzh.beerpong.entity.location.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService {

    Region save(RegionDto regionDto);

    void update(RegionDto regionDto);

    void delete(Long id);

    Region findById(Long id);

    List<Region> findAll();
}
