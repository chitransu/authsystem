package com.user.auth;

import com.user.auth.User;
import com.user.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

    	Iterable<User> it = userRepository.findAll();
    	List<User> users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return users;
    }
    
    public User save(User user) {
    	return userRepository.save(user);
    }

    public Long count() {

        return userRepository.count();
    }

    public void deleteById(Long userId) {

        userRepository.deleteById(userId);
    }
}
