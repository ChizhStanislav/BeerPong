package by.chyzh.beerpong.service.player;

import by.chyzh.beerpong.entity.player.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PlayerService playerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Player player = playerService.findByNickName(s);

        return User.builder()
                .username(player.getNickName())
                .password(player.getPassword())
                .authorities(player.getRole().name())
                .build();
    }
}
