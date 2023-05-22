package petmall.adapters.mysql.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petmall.domain.pet.PetRepository;

@Repository
public interface MysqlPetRepository extends PetRepository, JpaRepository<PetEntity, Long> {
}
