package petmall.adapters.mysql.accessories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petmall.domain.accessory.AccessoryRepository;

@Repository
public interface MysqlAccessoryRepository extends AccessoryRepository, JpaRepository<AccessoryEntity, Long> {

}
