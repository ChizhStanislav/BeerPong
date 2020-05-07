package by.chyzh.beerpong.service.player;

import by.chyzh.beerpong.dto.player.TeamDto;
import by.chyzh.beerpong.entity.player.Team;
import by.chyzh.beerpong.exception.NotFound;
import by.chyzh.beerpong.repository.player.TeamRepository;
import by.chyzh.beerpong.service.location.CityService;
import by.chyzh.beerpong.service.location.CountryService;
import by.chyzh.beerpong.service.location.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamImplService implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerService playerService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;


    @Transactional
    @Override
    public Team save(TeamDto teamDto) {
        return teamRepository.save(Team.builder()
                .name(teamDto.getName())
                .ownerTeam(playerService.findById(teamDto.getOwnerTeamId()))
                .country(countryService.findById(teamDto.getCountryId()))
                .region(regionService.findById(teamDto.getRegionId()))
                .city(cityService.findById(teamDto.getCityId()))
                .registrationDate(teamDto.getRegistrationDate())
                .build());
    }

    @Transactional
    @Override
    public void update(TeamDto teamDto) {
        teamRepository.update(teamDto.getId(), teamDto.getName(), teamDto.getOwnerTeamId(), teamDto.getCountryId(),
                teamDto.getRegionId(), teamDto.getCityId(), teamDto.getRegistrationDate());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow(()-> new NotFound("Team with id=" + id + " not found")
        );
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
