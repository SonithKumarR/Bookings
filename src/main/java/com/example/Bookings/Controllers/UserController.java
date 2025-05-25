package com.example.Bookings.Controllers;

import com.example.Bookings.Models.User;
import com.example.Bookings.Requests.AddUserRequest;
import com.example.Bookings.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User getByEmail(@RequestParam("emailId") String emailId){
        return userService.getByEmail(emailId);
    }
}
