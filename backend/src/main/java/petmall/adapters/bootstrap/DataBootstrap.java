package petmall.adapters.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.api.store.StoreService;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.accessory.AccessoryFacade;
import petmall.domain.pet.Pet;
import petmall.domain.pet.PetFacade;
import petmall.domain.pet.PetFactory;
import petmall.domain.pet.PetRepository;
import petmall.domain.user.UserData;
import petmall.domain.user.UserFactory;
import petmall.domain.user.UserRepository;
import petmall.domain.user.UserService;
import petmall.exception.UserNotFoundException;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataBootstrap implements CommandLineRunner {

    private final StoreService storeService;
    private final PetFacade petService;
    private final AccessoryFacade accessoryService;
    private final PetRepository petRepository;
    private final PetFactory petFactory;
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Override
    public void run(String... args) throws Exception {

        //________________ Customer ______________//
        UserRequestPayload customer1 = new UserRequestPayload("Joe204", "Joe", "Mark", "client", "joe@gmail.com", "12345", null, "22, MacLaure Street", "LA", "USA");
        CreatePetRequest dog12 = new CreatePetRequest("Mou", "Female", "Nice look","https://images.dog.ceo/breeds/dachshund/dog-1018408_640.jpg", new BigDecimal(0), "dog", "BULLDOG");
        createUser(customer1, dog12);

        UserRequestPayload customer2 = new UserRequestPayload("Doe204", "Doe", "Park", "client", "doe@gmail.com", "12345", null, "25, MacLaure Street", "Atlanta", "USA");
        CreatePetRequest dog11 = new CreatePetRequest("Badoo", "Male", "Get acquaintance","https://images.dog.ceo/breeds/terrier-dandie/n02096437_1793.jpg", new BigDecimal(0), "dog", "GERMAN_SHEPHERD");
        createUser(customer2, dog11);

        UserRequestPayload customer3 = new UserRequestPayload("Toe204", "Toe", "Clark", "client", "toe@gmail.com", "12345", null, "32, MacLaure Street", "CA", "USA");
        CreatePetRequest dog10 = new CreatePetRequest("Luckk", "Male", "Nice to have","https://images.dog.ceo/breeds/hound-english/n02089973_4359.jpg", new BigDecimal(0), "dog", "PIT_BULL");
        createUser(customer3, dog10);

        UserRequestPayload customer4 = new UserRequestPayload("Zoe204", "Zoe", "Jark", "client", "zoe@gmail.com", "12345", null, "52, MacLaure Street", "LA", "USA");
        CreatePetRequest dog6 = new CreatePetRequest("Blace", "Male", "Nice look","https://images.dog.ceo/breeds/schnauzer-miniature/n02097047_4018.jpg", new BigDecimal(0), "dog", "COCKER_SPANIEL");
        createUser(customer4, dog6);

        //________________ Vet ______________//
        UserRequestPayload vet1 = new UserRequestPayload("Coe204", "Coe", "Blark", "vet", "coe@gmail.com", "12345", "doctor", "3, Plane Street", "CA", "USA");
        createUser(vet1);

        UserRequestPayload vet2 = new UserRequestPayload("Boe20", "Boe", "Park", "vet", "boe@gmail.com", "12345", "dentist", "5, Laure Street", "Texas", "USA");
        createUser(vet2);


        //________________ Store-Owner ______________//

        UserRequestPayload storeOwner1 = new UserRequestPayload("Paul204", "Paul", "Clark", "store_owner", "paul@gmail.com", "12345", null, "32, MacLaure Street", "CA", "USA");
        CreatePetRequest dog1 = new CreatePetRequest("Lace", "Male", "Nice look","https://images.dog.ceo/breeds/havanese/00100trPORTRAIT_00100_BURST20191112123933390_COVER.jpg", new BigDecimal(100), "dog", "HUSKY");
        createUser(storeOwner1, dog1);

        CreatePetRequest dog3 = new CreatePetRequest("Pace", "Male", "Nice Prety","https://images.dog.ceo/breeds/terrier-norwich/n02094258_257.jpg", new BigDecimal(200), "dog", "POODLE");
        createUser(storeOwner1, dog3);

        CreatePetRequest cat1 = new CreatePetRequest("Ace Parrot", "Male", "Nice look","https://www.cdc.gov/importation/images/cat.jpg?_=18560", new BigDecimal(0), "cat", "PERSIAN");
        createUser(storeOwner1, cat1);

        CreatePetRequest cat2 = new CreatePetRequest("Snowy", "Male", "Pretty look","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShzt3IYxgnU1D9hJ8OZMZy8KqJLcPZpOT9-6HEfM1ZiEbahAn0h3oCN9Pl8_TowMZZpiY&usqp=CAU", new BigDecimal(100), "cat", "SCOTTISH_FOLD");
        createUser(storeOwner1, cat2);

        CreatePetRequest dog7 = new CreatePetRequest("Jack", "Female", "Get acquaintance","https://images.dog.ceo/breeds/keeshond/n02112350_7038.jpg", new BigDecimal(250), "dog", "GERMAN_SHEPHERD");
        createUser(storeOwner1, dog7);

        CreatePetRequest dog4 = new CreatePetRequest("Kace", "Female", "Check it out","https://images.dog.ceo/breeds/saluki/n02091831_7665.jpg", new BigDecimal(100), "dog", "BULLDOG");
        createUser(storeOwner1, dog4);

        CreatePetRequest dog20 = new CreatePetRequest("Kace", "Female", "Check it out","https://images.dog.ceo/breeds/saluki/n02091831_7665.jpg", new BigDecimal(100), "dog", "BULLDOG");
        createUser(storeOwner1, dog20);

        CreatePetRequest bird4 = new CreatePetRequest("Omlet", "Male", "Nice look","https://t4.ftcdn.net/jpg/02/21/13/63/360_F_221136309_xOE9WXNjjQwFlY8xx9llZcq0ozo1Mtd9.jpg", new BigDecimal(100), "parrot", "GREY");
        createUser(storeOwner1, bird4);

        CreatePetRequest bird3 = new CreatePetRequest("Pexels", "Male", "Nice look","https://www.aejames.com/wp-content/uploads/2019/01/Parrot-Care.jpg", new BigDecimal(150), "parrot", "MOLUCCAN");
        createUser(storeOwner1, bird3);


        UserRequestPayload storeOwner2 = new UserRequestPayload("Peter204", "Peter", "Jark", "store_owner", "peter@gmail.com", "12345", null, "52, MacLaure Street", "LA", "USA");
        CreatePetRequest dog2 = new CreatePetRequest("Brace", "Female", "Robot look","https://images.dog.ceo/breeds/leonberg/n02111129_3675.jpg", new BigDecimal(150), "dog", "BORDER_COLLIE");
        createUser(storeOwner2, dog2);

        CreatePetRequest dog5 = new CreatePetRequest("Mace", "Male", "Get acquaintance","https://images.dog.ceo/breeds/cotondetulear/100_2397.jpg", new BigDecimal(200), "dog", "BEAGLE");
        createUser(storeOwner2, dog5);

        CreatePetRequest dog8 = new CreatePetRequest("Jagua", "Male", "Nice look","https://images.dog.ceo/breeds/pointer-germanlonghair/hans1.jpg", new BigDecimal(100), "dog", "PEKINGESE");
        createUser(storeOwner2, dog8);

        CreatePetRequest dog9 = new CreatePetRequest("Lance", "Female", "What a friend","https://images.dog.ceo/breeds/sheepdog-shetland/n02105855_7161.jpg", new BigDecimal(150), "dog", "PIT_BULL");
        createUser(storeOwner2, dog9);

        CreatePetRequest bird1 = new CreatePetRequest("Britannica", "Male", "Nice look","https://images.unsplash.com/photo-1552728089-57bdde30beb3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGFycm90fGVufDB8fDB8fHww&w=1000&q=80", new BigDecimal(100), "parrot", "BUDGIE");
        createUser(storeOwner2, bird1);

        CreatePetRequest bird2 = new CreatePetRequest("Vecteezy", "Male", "Nice look","https://www.shutterstock.com/image-photo/awesome-new-tia-beautiful-picture-260nw-2292031823.jpg", new BigDecimal(200), "parrot", "CAROLINA_PARAKEET");
        createUser(storeOwner2, bird2);

        CreatePetRequest cat3 = new CreatePetRequest("Blacey", "Male", "Get acquaintance","https://static.standard.co.uk/2021/06/07/12/erik-jan-leusink-IbPxGLgJiMI-unsplash.jpg?width=968&auto=webp&quality=50&crop=968%3A645%2Csmart", new BigDecimal(200), "cat", "SIBERIAN");
        createUser(storeOwner2, cat3);

        CreatePetRequest cat4 = new CreatePetRequest("Blurry", "Male", "Get acquaintance","https://static.toiimg.com/thumb/resizemode-4,width-1200,height-900,msid-72295960/72295960.jpg", new BigDecimal(150), "cat", "SPHYNX");
        createUser(storeOwner2, cat4);

        //________________ Admin ______________//

        UserRequestPayload admin = new UserRequestPayload("Pete204", "Pete", "Klark", "admin", "pete@gmail.com", "12345", null, "52, MacLaure Street", "LA", "USA");
        createUser(admin);


        //________________ Pet - Dog ______________//






        //________________ Pet - Parrot ______________//


        //________________ Pet - Cat ______________//



        //________________ Create - Dog ______________//






        //________________ Create - Cat ______________//



        //________________ Create - Parrot ______________//




        //________________ Store ______________//




        // ________________ Accessory - Cage ______________//


        // ________________ Accessory - Collar ______________//


        // ________________ Accessory - Fodder ______________//


    }


    private Pet addPet(CreatePetRequest req, UserEntity user) {
        PetEntity petEntity = petFactory.getPetType(req.getPetType()).processPetTypeReq(req);
        petEntity.setName(req.getName());
        petEntity.setImageUrl(req.getImageUrl());
        petEntity.setGender(req.getGender());
        petEntity.setOwner(user);
        petEntity.setPrice(req.getPrice());
        petEntity.setVet(null);
        petEntity.setDescription(req.getDescription());
        return petRepository.save(petEntity).asPet();
    }


    private UserData createUser(UserRequestPayload payload, CreatePetRequest req) {
        UserEntity  user = userFactory.getUserTypeEntity(payload.getUserType()).processUserTypeReq(payload);
        user.setUsername(payload.getUsername());
        user.setFirstName(payload.getFirstName());
        user.setLastName(payload.getLastName());
        user.setEmail(payload.getEmail());
        user.setPassword(payload.getPassword());
        UserData data = userRepository.save(user).asUser();
        addPet(req, user); // create Pet for User
        return data;
    }

    private UserData createUser(UserRequestPayload payload) {
        UserEntity  user = userFactory.getUserTypeEntity(payload.getUserType()).processUserTypeReq(payload);
        user.setUsername(payload.getUsername());
        user.setFirstName(payload.getFirstName());
        user.setLastName(payload.getLastName());
        user.setEmail(payload.getEmail());
        user.setPassword(payload.getPassword());
        return userRepository.save(user).asUser();
    }

}
