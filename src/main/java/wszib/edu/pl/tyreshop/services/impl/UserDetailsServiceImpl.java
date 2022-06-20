package wszib.edu.pl.tyreshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.repository.IUserRepository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
private final IUserRepository userRepository;

    public UserDetailsServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            if (Objects.equals(username, "admin")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            } else {
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        } else throw new UsernameNotFoundException("User " + username + " not found!");
    }
}
