package com.example.Bookings.Controllers;

import com.example.Bookings.Models.User;
import com.example.Bookings.Requests.AddUserRequest;
import com.example.Bookings.Responses.Userresponse;
import com.example.Bookings.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String addUser(@RequestBody AddUserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @GetMapping
    public ResponseEntity<?> getByEmailAndPassword(
            @RequestParam("emailId") String emailId,
            @RequestParam("password") String password) {

        Userresponse user = userService.getByEmailAndPassword(emailId, password);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
        return ResponseEntity.ok(user);
    }
}
