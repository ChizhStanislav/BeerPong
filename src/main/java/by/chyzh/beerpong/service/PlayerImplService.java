package by.chyzh.beerpong.service;

import by.chyzh.beerpong.dto.PlayerDto;
import by.chyzh.beerpong.entity.Player;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.CityRepository;
import by.chyzh.beerpong.repository.CountryRepository;
import by.chyzh.beerpong.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayerImplService implements PlayerService {

    private final PlayerRepository playerRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    @Transactional
    @Override
    public Player save(PlayerDto playerDto) {
        return playerRepository.save(Player.builder()
                .nickName(playerDto.getNickName())
                .password(playerDto.getPassword())
                .email(playerDto.getEmail())
                .country(countryRepository.findById(playerDto.getCountryId()).orElseThrow(
                        () -> new NotFound("Country with id=" + playerDto.getCountryId() + " not found")))
                .city(cityRepository.findById(playerDto.getCityId()).orElseThrow(
                        () -> new NotFound("City with id=" + playerDto.getCityId() + " not found")))
                .build());
    }

    @Transactional
    @Override
    public void update(PlayerDto playerDto) {
        playerRepository.update(playerDto.getId(), playerDto.getNickName(), playerDto.getEmail(),
                playerDto.getCountryId(), playerDto.getCityId());
    }

    @Transactional
    @Override
    public void updatePassword(PlayerDto playerDto) {
        playerRepository.updatePassword(playerDto.getId(), playerDto.getPassword());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new NotFound("Player with id=" + id + " not found"));
    }

    @Override
    public Player findByNickName(String nickName) {
        return playerRepository.findByNickName(nickName);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
