package com.example.perfume_ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.perfume_ecommerce.models.User;
import com.example.perfume_ecommerce.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> searchAll(){
        return userRepository.findAll();
    }

    public User searchById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public void update(Long id, User user){
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isPresent()){
            userRepository.save(user);
        }
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User insert(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("This email already exists!");
        }
        return this.userRepository.save(user);
    }
}
