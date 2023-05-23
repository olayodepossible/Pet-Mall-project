package petmall.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.user.UserData;
import petmall.domain.user.UserService;

import javax.validation.Valid;
import java.util.List;

/*
 * Controller for Login Panel
 */

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserData> registerUser(@Valid @RequestBody UserRequestPayload payload){
        return new ResponseEntity<>(userService.createUser(payload), HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity<> loginUser(){
//
//    }

    @GetMapping("/")
    public ResponseEntity<List<UserData>> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getUser(@PathVariable long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }
}
