package by.chyzh.beerpong.service;

import by.chyzh.beerpong.dto.RegionDto;
import by.chyzh.beerpong.entity.Region;
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
