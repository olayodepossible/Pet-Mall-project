package petmall.adapters.mysql.accessories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepository extends petmall.domain.accessory.AccessoryRepository, JpaRepository<AccessoryEntity, Long> {

}
