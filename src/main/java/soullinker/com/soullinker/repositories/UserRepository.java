package soullinker.com.soullinker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soullinker.com.soullinker.models.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
