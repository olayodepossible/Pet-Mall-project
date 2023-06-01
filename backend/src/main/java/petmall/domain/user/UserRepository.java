package petmall.domain.user;



import petmall.adapters.mysql.user.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findByUsername (String username);
    Optional<UserEntity> findById(long id);
    List<UserEntity> findAll();
    UserEntity save(UserEntity userEntity);
    void deleteById(long id);


}
