package petmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Main runner application for OnlinePetStore
 * Connection to MySQL Database
 * CRUD Pet object, Accessory object
 * Created: 01.10.2020
 */
@SpringBootApplication
public class PetMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetMallApplication.class, args);
    }

}
