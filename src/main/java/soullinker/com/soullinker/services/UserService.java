package soullinker.com.soullinker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import soullinker.com.soullinker.dtos.CreateUserRequest;
import soullinker.com.soullinker.dtos.UserResponse;
import soullinker.com.soullinker.models.User;
import soullinker.com.soullinker.repositories.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserResponse createUser(CreateUserRequest userRequest){
        User user = User.builder()
                .name(userRequest.getName())
                .birthDate(userRequest.getBirthDate())
                .password(userRequest.getPassword())
                .cpf(userRequest.getCpf())
                .email(userRequest.getEmail())
                .build();
        Optional<User> existingUser = userRepository.findByEmail(userRequest.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("A user with the provided email already exists.");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        User createdUser = userRepository.save(user);

        return UserResponse.builder()
                .id(createdUser.getId())
                .name(createdUser.getName())
                .birthDate(createdUser.getBirthDate())
                .cpf(createdUser.getCpf())
                .email(createdUser.getEmail())
                .build();
    }
}
