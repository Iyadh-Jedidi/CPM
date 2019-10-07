package com.cll.cpm.Service;

import com.cll.cpm.Entity.User;
import com.cll.cpm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }
    public List<User> getAllUsers (){
        return userRepository.findAll();
    }
    public void deleteUser (Long id){
        User user = getUserById(id);
        if(user == null) {
            System.out.println("Not found");
        }
        userRepository.delete(user);
    }
}
