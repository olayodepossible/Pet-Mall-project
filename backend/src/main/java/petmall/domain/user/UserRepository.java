package petmall.domain.user;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import petmall.adapters.mysql.user.UserEntity;
import petmall.adapters.mysql.user.Vet;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername (String username);
    Optional<UserEntity> findById(long id);
    List<UserEntity> findAll();
    UserEntity save(UserEntity userEntity);

    void deleteById(long id);

    @Query("SELECT c FROM users c JOIN c.stores p WHERE p.id = :storeId")
    List<Vet> findVetsByStoreId(Long storeId);


}
