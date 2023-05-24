package petmall.api.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petmall.adapters.mysql.Store;
import petmall.api.store.dto.StoreDto;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/owner_id")
    public ResponseEntity<StoreDto> createStore(@RequestParam long id, @RequestBody StoreDto req){
        return new ResponseEntity<>(storeService.registerStore(req, id), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<StoreDto>> getStores(){
        return new ResponseEntity<>(storeService.getAllStore(), HttpStatus.OK);
    }
    @GetMapping("/owner_id")
    public ResponseEntity<Collection<Store>> getStore(@RequestParam long id){
        return new ResponseEntity<>(storeService.getStoresByOwner(id), HttpStatus.OK);
    }
    @PutMapping("/owner_id/store")
    public ResponseEntity<StoreDto> updateStore(@RequestParam long id, @RequestParam long storeId, @RequestBody StoreDto req){
        return new ResponseEntity<>(storeService.updateStoresByOwner(id, storeId, req), HttpStatus.OK);
    }
    @DeleteMapping("/store")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStore(@RequestParam long id){
        storeService.deleteStore(id);
    }
}
