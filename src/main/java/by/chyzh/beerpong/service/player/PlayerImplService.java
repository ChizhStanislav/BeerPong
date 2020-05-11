package by.chyzh.beerpong.service.player;

import by.chyzh.beerpong.dto.player.PlayerDto;
import by.chyzh.beerpong.entity.dictionary.Role;
import by.chyzh.beerpong.entity.player.Player;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.player.PlayerRepository;
import by.chyzh.beerpong.service.location.CityService;
import by.chyzh.beerpong.service.location.CountryService;
import by.chyzh.beerpong.service.location.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayerImplService implements PlayerService {

    private final PlayerRepository playerRepository;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;

    @Transactional
    @Override
    public Player save(PlayerDto playerDto) {

        Role role = Role.USER;

        if (Objects.nonNull(playerDto.getRole())) {
            role = Role.valueOf(playerDto.getRole());
        }

        return playerRepository.save(Player.builder()
                .nickName(playerDto.getNickName())
                .password(playerDto.getPassword())
                .email(playerDto.getEmail())
                .role(role)
                .country(countryService.findById(playerDto.getCountryId()))
                .region(regionService.findById(playerDto.getRegionId()))
                .city(cityService.findById(playerDto.getCityId()))
                .build());
    }

    @Transactional
    @Override
    public void update(PlayerDto playerDto) {
        playerRepository.update(playerDto.getId(), playerDto.getNickName(), playerDto.getEmail(),
                Role.valueOf(playerDto.getRole()), playerDto.getCountryId(), playerDto.getRegionId(), playerDto.getCityId());
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
