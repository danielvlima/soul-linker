package soullinker.com.soullinker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soullinker.com.soullinker.dtos.UserRequest;
import soullinker.com.soullinker.models.User;
import soullinker.com.soullinker.repositories.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void createUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setBirthDate(userRequest.getBirthDate());

        User createdUser = userRepository.save(user);
        System.out.println(createdUser.getName());
    }
}
