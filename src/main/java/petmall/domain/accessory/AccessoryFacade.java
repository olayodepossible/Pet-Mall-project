package petmall.domain.accessory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.api.accessory.dto.AccessoryData;
import petmall.api.accessory.dto.CreateAccessoryRequest;
import petmall.api.store.StoreService;
import petmall.exception.AccessoryNotFoundException;
import petmall.exception.StoreNotFoundException;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccessoryFacade {

    private final AccessoryRepository accessoryRepository;
    private final AccessoryFactory accessoryFactory;
    @Autowired
    private StoreService storeService;

    // Methods for Controller from Repository
    public Accessory getAccessory(long id) {
        AccessoryEntity data = accessoryRepository.findById(id).orElseThrow(() -> new AccessoryNotFoundException(String.format("Accessory with %d not found", id)));
        return data.asAccessory();
    }

    public Collection<AccessoryData> accessoryByStore(long id) {
        return accessoryRepository.findAccessoryByStore(id).stream().map(AccessoryEntity::asAccessoryData).collect(Collectors.toList());
    }

    public List<AccessoryData> getAccessories() {
        return accessoryRepository.findAll().stream().map(AccessoryEntity::asAccessoryData).collect(Collectors.toList());
    }

    @Transactional
    public AccessoryData addAccessory(long id, CreateAccessoryRequest accessory) {
        Store store = storeService.getStoresByOwner(id).stream().findFirst().orElseThrow(() -> new StoreNotFoundException(String.format("Store with %d not found", id)));
        AccessoryEntity accessoryEntity = accessoryFactory.getAccessoryProcessor(accessory.getAccessoryType()).processAccessoryTypeReq(accessory);
        accessoryEntity.setName(accessory.getName());
        accessoryEntity.setPrice(accessory.getPrice());
        accessoryEntity.setImage(accessory.getImage());
        accessoryEntity.setPetType(accessory.getPetType());
        accessoryEntity.setDescription(accessory.getDescription());
        accessoryEntity.setStore(store);
        return accessoryRepository.save(accessoryEntity).asAccessoryData();
    }

    @Transactional
    public Accessory putAccessory(long id, CreateAccessoryRequest accessory) {
        return accessoryRepository.save(accessory.asAccessory(id)).asAccessory();
    }

    @Transactional
    public void deleteAccessory(long id) {
        accessoryRepository.deleteById(id);
    }
}
