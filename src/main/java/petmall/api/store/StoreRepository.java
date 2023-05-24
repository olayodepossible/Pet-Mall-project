package petmall.api.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import petmall.adapters.mysql.Store;

import java.util.Collection;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("SELECT u FROM Store u WHERE u.owner.id = ?1")
    Collection<Store> findByOwner(long id);
    Optional<Store> findByIdAndOwner(long storeId, long ownerId);
}
