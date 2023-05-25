package petmall.domain.accessory;

import org.springframework.data.jpa.repository.Query;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.accessories.AccessoryEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AccessoryRepository {
    void findByName(String name);
    Optional<AccessoryEntity> findById(long id);
    List<AccessoryEntity> findAll();
    @Query("SELECT u FROM accessories u WHERE u.store.id = ?1")
    Collection<AccessoryEntity> findAccessoryByStore(long id);
    AccessoryEntity save(AccessoryEntity accessoryEntity);
    void deleteById(long id);
}
