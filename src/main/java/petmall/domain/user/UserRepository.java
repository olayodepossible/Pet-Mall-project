package petmall.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.adapters.mysql.user.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {



}
