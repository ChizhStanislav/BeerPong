package by.chyzh.beerpong.service;

import by.chyzh.beerpong.dto.CityDto;
import by.chyzh.beerpong.entity.City;
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
