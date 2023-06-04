package petmall.api.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.user.UserEntity;
import petmall.adapters.mysql.user.Vet;
import petmall.api.store.dto.ServiceReceipt;
import petmall.api.store.dto.StoreDto;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/{ownerId}")
    public ResponseEntity<StoreDto> createStore(@RequestParam long ownerId, @RequestBody StoreDto req){
        return new ResponseEntity<>(storeService.registerStore(req, ownerId), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<StoreDto>> getStores(){
        return new ResponseEntity<>(storeService.getAllStore(), HttpStatus.OK);
    }
    @GetMapping("/{ownerId}")
    public ResponseEntity<Collection<Store>> getStore(@RequestParam long ownerId){
        return new ResponseEntity<>(storeService.getStoresByOwner(ownerId), HttpStatus.OK);
    }
    @PutMapping("/owner/{ownerId}/store")
    public ResponseEntity<StoreDto> updateStore(@RequestParam long ownerId, @RequestParam long storeId, @RequestBody StoreDto req){
        return new ResponseEntity<>(storeService.updateStoresByOwner(ownerId, storeId, req), HttpStatus.OK);
    }
    @DeleteMapping("/store")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStore(@RequestParam long id){
        storeService.deleteStore(id);
    }


    @GetMapping("/{storeId}/vets")
    public ResponseEntity<List<UserEntity>> getAllVetsByStoreId(@PathVariable(value = "storeId") Long storeId) {
        return new ResponseEntity<>(storeService.getVetsByStoreId(storeId), HttpStatus.OK);
    }
    @PostMapping("/{storeId}/vet/{vetId}")
    public ResponseEntity<HttpStatus> addVetToStore(@PathVariable() Long storeId, @PathVariable() Long vetId ) {
        storeService.addVet(storeId, vetId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{storeId}/vet/{vetId}")
    public ResponseEntity<HttpStatus> deleteVetFromStore(@PathVariable(value = "storeId") Long storeId, @PathVariable(value = "vetId") Long vetId) {
        storeService.deleteVet(storeId, vetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/vet/{vetId}/consultation/{petId}")
    public ResponseEntity<ServiceReceipt> consultVet(@PathVariable Long petId, @PathVariable Long vetId) {
        return new ResponseEntity<>(storeService.vetConsultation(petId,vetId), HttpStatus.OK);
    }
}
