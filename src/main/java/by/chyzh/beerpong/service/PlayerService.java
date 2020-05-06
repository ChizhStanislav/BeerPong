package by.chyzh.beerpong.service;

import by.chyzh.beerpong.dto.PlayerDto;
import by.chyzh.beerpong.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    Player save(PlayerDto playerDto);

    void update(PlayerDto playerDto);

    void updatePassword(PlayerDto playerDto);

    void delete(Long id);

    Player findById(Long id);

    Player findByNickName(String nickName);

    List<Player> findAll();
}
