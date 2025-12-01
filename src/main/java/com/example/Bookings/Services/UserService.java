package com.example.Bookings.Services;

import com.example.Bookings.Models.User;
import com.example.Bookings.Repositories.UserRepository;
import com.example.Bookings.Requests.AddUserRequest;
import com.example.Bookings.Responses.Userresponse;

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
        user.setPassword(userRequest.getPassword());

// Save the user to the repository
        user = userRepository.save(user);

        return "User have been saved to DB with userId"+user.getUserId();
    }

    public Userresponse getByEmailAndPassword(String emailId, String password) {
        User user = userRepository.findByEmailId(emailId);

        if (user != null && user.getPassword().equals(password)) {
            // ✅ Convert User → UserResponse
            Userresponse response = new Userresponse();
            response.setUserId(user.getUserId());
            response.setName(user.getName());
            response.setAge(user.getAge());
            response.setEmailId(user.getEmailId());
            response.setMobileNo(user.getMobileNo());
            return response;
        }
        return null; // invalid login
    }
}
