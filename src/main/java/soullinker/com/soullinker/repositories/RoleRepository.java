package soullinker.com.soullinker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soullinker.com.soullinker.models.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
