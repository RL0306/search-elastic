package com.example.search.controller;

import com.example.search.entity.FrogUserDocument;
import com.example.search.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<Iterable<FrogUserDocument>> getAll(){
        Iterable<FrogUserDocument> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(path = "/load")
    public ResponseEntity<Map<String, String>> loadUsers(){
        userService.loadAllUsers();
        return ResponseEntity.ok(Map.of("upload", "success"));
    }


}
