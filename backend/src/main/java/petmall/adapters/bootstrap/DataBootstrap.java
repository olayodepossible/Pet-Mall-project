package petmall.adapters.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petmall.api.pet.dto.CreatePetRequest;
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
        CreatePetRequest dog1 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "HUSKY");
        CreatePetRequest dog2 = new CreatePetRequest("Brace", "Female", "Robbot look",null, 0, "dog", "BORDER_COLLIE");
        CreatePetRequest dog3 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "POODLE");
        CreatePetRequest dog4 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "BULLDOG");
        CreatePetRequest dog5 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "BEAGLE");
        CreatePetRequest dog6 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "COCKER_SPANIEL");
        CreatePetRequest dog7 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "GERMAN_SHEPHERD");
        CreatePetRequest dog8 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "PEKINGESE");
        CreatePetRequest dog9 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "PIT_BULL");
        CreatePetRequest dog10 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "PIT_BULL");
        CreatePetRequest dog11 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "GERMAN_SHEPHERD");
        CreatePetRequest dog12 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "BULLDOG");



            //________________ Pet - Cat ______________//
        CreatePetRequest cat1 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "PERSIAN");

            //________________ Pet - Parrot ______________//
        CreatePetRequest bird1 = new CreatePetRequest("Lace", "Male", "Nice look",null, 0, "dog", "PERSIAN");



            //________________ Store ______________//




            // ________________ Accessory - Cage ______________//


            // ________________ Accessory - Collar ______________//


            // ________________ Accessory - Fodder ______________//


    }

}
