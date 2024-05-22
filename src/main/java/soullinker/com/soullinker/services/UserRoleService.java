package soullinker.com.soullinker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soullinker.com.soullinker.dtos.CreateRoleRequest;
import soullinker.com.soullinker.models.Role;
import soullinker.com.soullinker.repositories.RoleRepository;

import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private final RoleRepository userRoleRepository;

    public UserRoleService(RoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void createRole(CreateRoleRequest role){
        Role newRole = new Role(role.getRoleName());
        Role existingRole = userRoleRepository.findByName(newRole.getName());
        if(existingRole == null) {
            throw new RuntimeException("Already exists this role!");
        }
        userRoleRepository.save(newRole);
    }
}
