package petmall.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import petmall.domain.pet.PetProcessor;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserFactory {

    private final Map<String, UserProcessor> factoryMap = new HashMap<>();

    @Autowired
    public void setUserProcessor(@NotNull List<UserProcessor> userProcessorList){
        if (!userProcessorList.isEmpty()){
            userProcessorList.forEach(el -> factoryMap.put(el.getUserType(), el));
        }
    }

    public UserProcessor getUserTypeEntity(String petType){
        UserProcessor userProcessor = factoryMap.get(petType);
        if (userProcessor != null){
            return userProcessor;
        }
        return factoryMap.get("UNSUPPORTED");
    }
}
