package com.oscar.todo_list.Controller;

import com.oscar.todo_list.DTO.UserDTO;
import com.oscar.todo_list.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(this.userService.create(userDTO), HttpStatus.CREATED);
    }
}
