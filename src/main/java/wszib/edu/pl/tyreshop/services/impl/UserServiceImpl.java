package wszib.edu.pl.tyreshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.model.dto.UserDto;
import wszib.edu.pl.tyreshop.repository.IUserRepository;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void updateEmail(UserDto userDto) {
        User user = this.userRepository.findByUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = this.userRepository.findAll();

       return users.stream()
               .map(user -> modelMapper.map(user, UserDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void saveUser() {

    }
}
