package petmall.api.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.user.UserEntity;
import petmall.adapters.mysql.user.Vet;
import petmall.api.store.dto.StoreDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("SELECT u FROM stores u WHERE u.owner.id = ?1")
    Collection<Store> findByOwner(long id);
    Optional<Store> findByIdAndOwner(long storeId, long ownerId);
    @Query("SELECT c.vetList FROM stores c JOIN c.vetList p WHERE c.id = :storeId")
    List<UserEntity> findVetsByStoreId(Long storeId);

}
