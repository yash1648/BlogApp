package org.bloggingapp.blogapp.service;


import org.bloggingapp.blogapp.dto.CreateUserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void create_user(){
        var user = userService.createUser(new CreateUserDTO(
                "john","johndoe123","hoe@1234"
        ));
        Assertions.assertNotNull(user);
        Assertions.assertEquals("john",user.getUsername());

    }
}
