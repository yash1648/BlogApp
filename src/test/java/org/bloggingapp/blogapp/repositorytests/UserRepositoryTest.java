package org.bloggingapp.blogapp.repositorytests;

import org.bloggingapp.blogapp.model.UserEntity;
import org.bloggingapp.blogapp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired  // Injects the real UserRepository instance
    private UserRepository userRepository;

    @Test
    @Order(1)
    void can_create_users() {
        var user = UserEntity.builder()
                .username("john_doe")
                .email("john@example.com")
                .build();

        UserEntity savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
    }

    @Test
    @Order(2)
    void can_find_user(){
        can_create_users();
        var user=userRepository.findAll();
        Assertions.assertEquals(1,user.size());
    }

}
