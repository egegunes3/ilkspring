package com.huseyinAbi.springDBDeneme.controller;


import com.huseyinAbi.springDBDeneme.entity.UserEntity;
import com.huseyinAbi.springDBDeneme.entity.enums.Role;
import com.huseyinAbi.springDBDeneme.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    ResponseEntity<Page<UserEntity>> getUsers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(userService.getAll(PageRequest.of(page, pageSize, Sort.by("id"))));
    }

    @GetMapping("/by-role")
    ResponseEntity<List<UserEntity>> getUsersByRole(@RequestParam Role role) {
        return ResponseEntity.ok(userService.getUsersByRole(role));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserEntity> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


}
