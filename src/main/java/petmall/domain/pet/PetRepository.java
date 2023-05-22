package petmall.domain.pet;

import petmall.adapters.mysql.pet.PetEntity;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    void findByName (String name);
    Optional<PetEntity> findById(long id);
    List<PetEntity> findAll();
    PetEntity save(PetEntity petEntity);
    void deleteById(long id);
}
