package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.User;
import com.example.railwaystation.repository.UserRepository;
import com.example.railwaystation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(long id) {
        if(userRepository.existsById(id))
            return userRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(User userOrig, long id) {
        if(userRepository.existsById(id)){
            Optional<User> found = userRepository.findById(id);
            if(found.isPresent()){
                User user = found.get();
                user.setId(id);
                if(userOrig.getFullName() == null){
                    user.setFullName(userOrig.getFullName());
                }
                if(userOrig.getEmail() == null){
                    user.setEmail(userOrig.getEmail());
                }
                if(userOrig.getPassword() == null){
                    user.setPassword(userOrig.getPassword());
                }
                if(userOrig.getRole() == null){
                    user.setRole(userOrig.getRole());
                }
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
