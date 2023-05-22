package petmall.domain.accessory;

import petmall.adapters.mysql.accessories.AccessoryEntity;

import java.util.List;
import java.util.Optional;

public interface AccessoryRepository {
    void findByName(String name);
    Optional<AccessoryEntity> findById(long id);
    List<AccessoryEntity> findAll();
    AccessoryEntity save(AccessoryEntity accessoryEntity);
    void deleteById(long id);
}
