package by.chyzh.beerpong.service.location;

import by.chyzh.beerpong.dto.location.CityDto;
import by.chyzh.beerpong.entity.location.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    City save(CityDto cityDto);

    void update(CityDto cityDto);

    void delete(Long id);

    City findById(Long id);

    List<City> findAll();
}
