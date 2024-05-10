package soullinker.com.soullinker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soullinker.com.soullinker.dtos.CreateRoleRequest;
import soullinker.com.soullinker.dtos.CreateUserRequest;
import soullinker.com.soullinker.models.UserRole;
import soullinker.com.soullinker.repositories.UserRepository;
import soullinker.com.soullinker.repositories.UserRoleRepository;

import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void createRole(CreateRoleRequest role){
        UserRole newRole = new UserRole(role.getRoleName());
        Optional<UserRole> existingRole = userRoleRepository.findByName(newRole.getName());
        if(existingRole.isPresent()) {
            throw new RuntimeException("Already exists this role!");
        }
        userRoleRepository.save(newRole);
    }
}
