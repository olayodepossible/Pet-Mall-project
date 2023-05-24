package petmall.domain.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PetFactory {

    private final Map<String, PetProcessor> factoryMap = new HashMap<>();

    @Autowired
    public void setPetProcessor(@NotNull List<PetProcessor> petProcessorList){
        if (!petProcessorList.isEmpty()){
            petProcessorList.forEach(el -> factoryMap.put(el.getPetType(), el));
        }
    }

    public PetProcessor getPetType(String petType){
        PetProcessor petProcessor = factoryMap.get(petType);
        if (petProcessor != null){
            return petProcessor;
        }
        return factoryMap.get("UNSUPPORTED");
    }
}
