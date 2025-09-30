package chronodb.chrono.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import chronodb.chrono.services.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String,String> request)
    {
       String message=userService.registerUser(
        request.get("name"),
        request.get("email"),
        request.get("userName"),
        request.get("password"),
        request.get("role")
       );

       return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message",message));
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> request)
    {
        String message=userService.loginUser(request.get("userName"),request.get("password"));

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message",message));



    }



}
