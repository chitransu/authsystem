package com.user.auth;

import com.user.auth.User;
import com.user.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> allUsers() {

        return userService.findAll();
    }
    
    @PostMapping(path="/users")
	public ResponseEntity<Void> createUser(@RequestBody User user){
		
		User createdUser = userService.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUser.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
    
    @PutMapping(path="/users")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updatedTodo = userService.save(user);
		return new ResponseEntity<User>(updatedTodo,HttpStatus.OK);
	}

    @GetMapping("/users/count")
    public Long count() {

        return userService.count();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        userService.deleteById(userId);
    }
}
