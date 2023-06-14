package com.example.demojparelationship;

import com.example.demojparelationship.entity.IdentityCard;
import com.example.demojparelationship.entity.Post;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.IdentityCardRepository;
import com.example.demojparelationship.repository.PostRepository;
import com.example.demojparelationship.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoJpaRelationshipApplicationTests {

    @Autowired
    private Faker faker;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IdentityCardRepository identityCardRepository;
    @Autowired
    private PostRepository postRepository;


//    @Test
//    void save_user_1() {
//        IdentityCard identityCard = new IdentityCard(null, "111");
//        identityCardRepository.save(identityCard);
//
//        User user = new User(null, "Nguyen Van A", "a@gmail.com", "111", identityCard);
//        userRepository.save(user);
//    }

    @Test
    void save_user_2() {
        User user = User.builder()
                .name("Tran van B")
                .email("b@gmail.com")
                .password("2222")
                .identityCard(new IdentityCard(null, "222"))
                .build();
        userRepository.save(user);
    }

    @Test
    void find_user() {
        User user = userRepository.findById(2).orElse(null);
        System.out.println(user);
    }

    @Test
    void delete_user() {
        userRepository.deleteById(2);
    }

    @Test
    void save_user_post() {
        User user = User.builder()
                .name("Ngo thi C")
                .email("c@gmail.com")
                .password("1111")
                .build();
        userRepository.save(user);
        for (int i = 0; i < 5; i++) {
            Post post = new Post(null, "post" + i, user);
            postRepository.save(post);
        }
    }

    @Test
    void orphan_removal() {
        User user = userRepository.findById(5).orElse(null);
        user.getPosts().remove(1);
    }
}
