package org.bloggingapp.blogapp.service;

import org.bloggingapp.blogapp.dto.CreateUserDTO;
import org.bloggingapp.blogapp.model.UserEntity;
import org.bloggingapp.blogapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(CreateUserDTO u){
        var newUser=UserEntity.builder()
                .username(u.getUsername())
                // .password(u.getPassword())  TODO : Encrypt then store
                .email(u.getEmail())
                .build();

        return userRepository.save(newUser);
    }

    public UserEntity getUser(String username){
        return  userRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId){
        return  userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
    }



    public UserEntity loginUser(String username,String password){
        var user=userRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        //todo password
        return user;
    }

   public  static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(String username){
            super("User "+username+" not found");
        }

        public UserNotFoundException(Long id){
            super("User Id : "+id+" not found");
        }


    }

}
