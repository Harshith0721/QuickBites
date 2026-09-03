package org.quickbite.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity,Integer> {
    Optional<UsersEntity> findByEmail(String email);
}
