package petmall.adapters.mysql.user;

import org.springframework.data.jpa.repository.JpaRepository;
import petmall.domain.user.UserRepository;

public interface UserRepo extends UserRepository, JpaRepository<UserEntity, Long> {
}
