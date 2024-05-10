package soullinker.com.soullinker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soullinker.com.soullinker.models.User;
import soullinker.com.soullinker.models.UserRole;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    Optional<UserRole> findByName(String name);
}
