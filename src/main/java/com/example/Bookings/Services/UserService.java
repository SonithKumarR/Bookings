package com.example.Bookings.Services;

import com.example.Bookings.Models.User;
import com.example.Bookings.Repositories.UserRepository;
import com.example.Bookings.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest userRequest){
        // Create a new User object
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());
        user.setEmailId(userRequest.getEmailId());
        user.setMobileNo(userRequest.getMobileNo());

// Save the user to the repository
        user = userRepository.save(user);

        return "User have been saved to DB with userId"+user.getUserId();
    }

    public User getByEmail(String emailId){
        return userRepository.findByEmailId(emailId);
    }
}
