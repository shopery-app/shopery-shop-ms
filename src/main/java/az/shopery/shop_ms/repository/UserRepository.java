package az.shopery.shop_ms.repository;

import az.shopery.shop_ms.model.entity.UserEntity;
import az.shopery.shop_ms.utils.enums.UserRole;
import az.shopery.shop_ms.utils.enums.UserStatus;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus status);
    Optional<UserEntity> findByEmailAndUserRoleAndStatus(String email, UserRole userRole, UserStatus status);
    @Query(value = "SELECT * FROM users WHERE user_role = 'ADMIN' AND status = 'ACTIVE' ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<UserEntity> findRandomActiveAdmin();
}
