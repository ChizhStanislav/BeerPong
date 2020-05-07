package by.chyzh.beerpong.service;

import by.chyzh.beerpong.dto.CountryDto;
import by.chyzh.beerpong.entity.Country;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CountryImplService implements CountryService {

    private final CountryRepository countryRepository;

    @Transactional
    @Override
    public Country save(CountryDto countryDto) {
        return countryRepository.save(Country.builder()
                .name(countryDto.getName())
                .build());
    }

    @Transactional
    @Override
    public void update(CountryDto countryDto) {
        countryRepository.update(countryDto.getId(), countryDto.getName());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new NotFound("Country with id=" + id + " not found"));
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
