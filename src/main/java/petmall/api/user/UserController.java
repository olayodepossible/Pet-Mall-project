package petmall.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Controller for Login Panel
 */

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {


    @PostMapping("/register")
    public ResponseEntity<> registerUser(){

    }

    @PostMapping("/login")
    public ResponseEntity<> loginUser(){

    }

    @GetMapping("/")
    public ResponseEntity<> getUsers(){

    }

    @GetMapping("/{id}")
    public ResponseEntity<> getUsers(@RequestParam long id){

    }
}
