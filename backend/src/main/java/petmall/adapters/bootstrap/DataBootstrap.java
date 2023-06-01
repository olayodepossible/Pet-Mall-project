package petmall.adapters.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petmall.api.store.StoreService;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.accessory.AccessoryFacade;
import petmall.domain.pet.PetFacade;
import petmall.domain.user.UserService;

@Component
@RequiredArgsConstructor
public class DataBootstrap implements CommandLineRunner {

    private final UserService userService;
    private final StoreService storeService;
    private final PetFacade petService;
    private final AccessoryFacade accessoryService;

    @Override
    public void run(String... args) throws Exception {

        //________________ Customer ______________//
        UserRequestPayload customer1 = new UserRequestPayload("Joe204", "Joe", "Mark", "client", "joe@gmail.com", "12345", null, "22, MacLaure Street", "LA", "USA");
        UserRequestPayload customer2 = new UserRequestPayload("Doe204", "Doe", "Park", "client", "doe@gmail.com", "12345", null, "25, MacLaure Street", "Atlanta", "USA");
        UserRequestPayload customer3 = new UserRequestPayload("Toe204", "Toe", "Clark", "client", "toe@gmail.com", "12345", null, "32, MacLaure Street", "CA", "USA");
        UserRequestPayload customer4 = new UserRequestPayload("Zoe204", "Zoe", "Jark", "client", "zoe@gmail.com", "12345", null, "52, MacLaure Street", "LA", "USA");


        //________________ Vet ______________//

        UserRequestPayload vet1 = new UserRequestPayload("Coe204", "Coe", "Blark", "vet", "coe@gmail.com", "12345", "doctor", "3, Plane Street", "CA", "USA");
        UserRequestPayload vet2 = new UserRequestPayload("Boe20", "Boe", "Park", "vet", "boe@gmail.com", "12345", "dentist", "5, Laure Street", "Texas", "USA");

        //________________ Store-Owner ______________//

        UserRequestPayload storeOwner1 = new UserRequestPayload("Paul204", "Paul", "Clark", "store_owner", "paul@gmail.com", "12345", null, "32, MacLaure Street", "CA", "USA");
        UserRequestPayload storeOwner2 = new UserRequestPayload("Peter204", "Peter", "Jark", "store_owner", "peter@gmail.com", "12345", null, "52, MacLaure Street", "LA", "USA");


            //________________ Admin ______________//


        UserRequestPayload admin = new UserRequestPayload("Pete204", "Pete", "Klark", "admin", "pete@gmail.com", "12345", null, "52, MacLaure Street", "LA", "USA");

            //________________ Pet - Dog ______________//

            //________________ Pet - Cat ______________//

            //________________ Pet - Parrot ______________//



            //________________ Store ______________//




            // ________________ Accessory - Cage ______________//


            // ________________ Accessory - Collar ______________//


            // ________________ Accessory - Fodder ______________//


    }

}
