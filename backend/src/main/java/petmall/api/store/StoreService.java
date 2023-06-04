package petmall.api.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.user.UserEntity;
import petmall.adapters.mysql.user.Vet;
import petmall.api.store.dto.ServiceReceipt;
import petmall.api.store.dto.StoreDto;
import petmall.domain.pet.Pet;
import petmall.domain.pet.PetFacade;
import petmall.domain.user.UserService;
import petmall.exception.DataNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final UserService userService;
    private PetFacade petService;

    private static final String STORE_NOT_FOUND = "Not found Store with id = ";

    public StoreDto registerStore(StoreDto req, long id) {
        UserEntity user = userService.getUser(id);
        Store store = req.asStoreEntity();
        store.setOwner(user);
        return storeRepository.save(store).asStore();
    }

    public List<StoreDto> getAllStore() {
        return storeRepository.findAll().stream().map(Store::asStore).collect(Collectors.toList());
    }

    public Collection<Store> getStoresByOwner(long id) {
        return storeRepository.findByOwner(id);
    }

    public StoreDto updateStoresByOwner(long id, long storeId, StoreDto dto) {
        Store store = storeRepository.findByIdAndOwner(storeId, id).orElseThrow(() -> new DataNotFoundException(STORE_NOT_FOUND+ storeId));
        store.setName(dto.getName());
        store.setCity(dto.getCity());
        store.setAddress(dto.getAddress());
        store.setCountry(dto.getCountry());
        return storeRepository.save(store).asStore();
    }

    public void deleteStore(long id) {
         storeRepository.deleteById(id);
    }

    public List<UserEntity> getVetsByStoreId(Long storeId) {
        if (!storeRepository.existsById(storeId)) {
            throw new DataNotFoundException(STORE_NOT_FOUND + storeId);
        }
        return storeRepository.findVetsByStoreId(storeId);
//        return userService.getVetByStoreId(storeId);
    }

    public Store addVet(long storeId, long vetId) {
        return storeRepository.findById(storeId).map(store -> {

            // UserEntity is existed
            if (vetId != 0L) {
                UserEntity vet = userService.getUser(vetId);
                store.addVet(vet);
                storeRepository.save(store);
            }
            return store;
        }).orElseThrow(() -> new DataNotFoundException(STORE_NOT_FOUND + storeId));
    }

    public void deleteVet(Long storeId, Long vetId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new DataNotFoundException(STORE_NOT_FOUND + storeId));

        store.removeVet(vetId);
        storeRepository.save(store);
    }

    public ServiceReceipt vetConsultation( Long petId, Long vetId) {
        UserEntity vet = userService.getUser(vetId);
        Pet pet = petService.updatePetWithVet(vet, petId);
        return ServiceReceipt.builder()
                .ownerFirstName(pet.getOwnerFirstName())
                .ownerLastName(pet.getOwnerLastName())
                .ownerEmail(pet.getOwnerEmail())
                .ownerAddress(pet.getOwnerAddress())
                .serviceName(pet.getName())
                .petGender(pet.getGender())
                .petAge(pet.getAge())
                .description(pet.getDescription())
                .price(pet.getPrice())
                .breed(pet.getBreed())
                .vetName(vet.getFirstName() + " "+vet.getLastName())
                .vetAddress(vet.getAddress())
                .build();
    }
}
