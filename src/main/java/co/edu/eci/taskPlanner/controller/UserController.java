package co.edu.eci.taskPlanner.controller;

import co.edu.eci.taskPlanner.model.User;
import co.edu.eci.taskPlanner.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userServiceImpl.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        return new ResponseEntity<>(userServiceImpl.getById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userServiceImpl.create(user), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userServiceImpl.update(user),HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delteUser(@PathVariable String id){
        userServiceImpl.remove(id);
        return new  ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
