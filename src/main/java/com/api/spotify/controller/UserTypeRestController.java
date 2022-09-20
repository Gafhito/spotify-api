package com.api.spotify.controller;

import com.api.spotify.entity.UserType;
import com.api.spotify.repository.UserTypeRepository;
import com.api.spotify.service.UserTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user_type")
public class UserTypeRestController {

    private UserTypeService userTypeService;
    private UserTypeRepository userTypeRepository;

    public UserTypeRestController(UserTypeService userTypeService, UserTypeRepository userTypeRepository) {
        this.userTypeService = userTypeService;
        this.userTypeRepository = userTypeRepository;
    }

    @GetMapping
    public List<UserType> getList() {
        return userTypeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserType> getUserType(@PathVariable Long id) {
        return userTypeService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<UserType> createUserType(@RequestBody UserType newUserType) {
        return new ResponseEntity<>(userTypeService.save(newUserType), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserType> replaceUserType(@RequestBody UserType newUserType, @PathVariable Long id) {
        return new ResponseEntity<>(userTypeService.update(newUserType, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable Long id) {
        userTypeService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
