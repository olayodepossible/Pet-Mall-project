package petmall.domain.accessory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import petmall.domain.pet.PetProcessor;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AccessoryFactory {

    private final Map<String, AccessoryProcessor> factoryMap = new HashMap<>();

    @Autowired
    public void setAccessoryProcessor(@NotNull List<AccessoryProcessor> accessoryProcessorList){
        if (!accessoryProcessorList.isEmpty()){
            accessoryProcessorList.forEach(el -> factoryMap.put(el.getAccessoryType(), el));
        }
    }

    public AccessoryProcessor getAccessoryProcessor(String petType){
        AccessoryProcessor petProcessor = factoryMap.get(petType);
        if (petProcessor != null){
            return petProcessor;
        }
        return factoryMap.get("UNSUPPORTED");
    }
}
