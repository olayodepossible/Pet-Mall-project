package petmall.domain.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.pet.PetEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
    void findByName (String name);
    PetEntity save(PetEntity petEntity);
    Optional<PetEntity> findById(long id);
    @Query("SELECT u FROM pets u WHERE u.price > 0")
    Collection<PetEntity> findPetOwnByStore();
    List<PetEntity> findAll();
    void deleteById(long id);
}
