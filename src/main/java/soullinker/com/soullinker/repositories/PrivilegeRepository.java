package soullinker.com.soullinker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soullinker.com.soullinker.models.Privilege;


public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String name);
}
