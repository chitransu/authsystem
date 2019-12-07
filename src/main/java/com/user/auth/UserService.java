package com.user.auth;

import com.user.auth.User;
import com.user.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.user.auth.ProcessFile;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProcessFile processFile;

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
    
    public String readFile() {
    	try {
			processFile.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return "File Uploded and Saved !!!";
    }
}
