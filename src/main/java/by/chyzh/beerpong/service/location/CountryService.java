package by.chyzh.beerpong.service.location;

import by.chyzh.beerpong.dto.location.CountryDto;
import by.chyzh.beerpong.entity.location.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    Country save(CountryDto countryDto);

    void update(CountryDto countryDto);

    void delete(Long id);

    Country findById(Long id);

    List<Country> findAll();
}
