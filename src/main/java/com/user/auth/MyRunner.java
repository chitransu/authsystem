package com.user.auth;

import com.user.auth.User;
import com.user.auth.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MyRunner implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing users");

        User u1 = new User("Paul", "Smith", "paul.smith@gmail.com");
        userRepository.save(u1);

        User u2 = new User("Robert", "Black", "rb34@gmail.com");
        userRepository.save(u2);

        User u3 = new User("John", "Doe", "jdoe@gmail.com");
        userRepository.save(u3);
    }
}
