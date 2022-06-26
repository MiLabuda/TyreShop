package wszib.edu.pl.tyreshop.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.repository.IUserRepository;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final IUserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(IUserRepository userRepository, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        userRepository.save(user);
    }


    @Override
    public void login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            if(logger.isDebugEnabled()) logger.debug(String.format("User %s logged in successfully!", username));
        } else {
            if(logger.isErrorEnabled()) logger.error(String.format("Error with %s authentication!", username));
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
