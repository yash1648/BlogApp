package org.bloggingapp.blogapp.controller;

import org.bloggingapp.blogapp.commons.dtos.ErrorResponse;
import org.bloggingapp.blogapp.dto.CreateUserDTO;
import org.bloggingapp.blogapp.dto.LoginUserRequest;
import org.bloggingapp.blogapp.dto.UserResponse;
import org.bloggingapp.blogapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    ModelMapper modelMapper;
    UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }



    @PostMapping("")
    ResponseEntity<UserResponse> signUp(@RequestBody CreateUserDTO newUser){
        var savedUser=userService.createUser(newUser);
        var savedUserURI= URI.create("/users/"+savedUser.getId());
        return  ResponseEntity.created(savedUserURI)
                .body(modelMapper.map(savedUser, UserResponse.class));
    }

    @PostMapping("/login")
    ResponseEntity<UserResponse> login(LoginUserRequest req){
            var savedUser=userService.loginUser(req.getUsername(),req.getPassword());
            return ResponseEntity.ok(modelMapper.map(savedUser, UserResponse.class));
    }

    @ExceptionHandler({
            UserService.UserNotFoundException.class
    })
    ResponseEntity<ErrorResponse> handleUserExceptionForLogin(Exception e){

      String message;
      HttpStatus status;
      if(e instanceof UserService.UserNotFoundException ){
          message=e.getMessage();
          status=HttpStatus.NOT_FOUND;
      }
      else
      {
          message="Something went wrong";
          status=HttpStatus.INTERNAL_SERVER_ERROR;
      }

        ErrorResponse errorResponse=ErrorResponse.builder()
                .message(message)
                .build();

      return ResponseEntity.status(status).body(errorResponse);

    }




}
