package petmall.api.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.store.dto.StoreData;
import petmall.api.store.dto.StoreDto;
import petmall.domain.user.UserService;
import petmall.exception.StoreNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final UserService userService;

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
        Store store = storeRepository.findByIdAndOwner(storeId, id).orElseThrow(() -> new StoreNotFoundException(String.format("Store with %id not found", storeId)));
        store.setName(dto.getName());
        store.setCity(dto.getCity());
        store.setAddress(dto.getAddress());
        store.setCountry(dto.getCountry());
        return storeRepository.save(store).asStore();
    }

    public void deleteStore(long id) {
         storeRepository.deleteById(id);
    }
}
