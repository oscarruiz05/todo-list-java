package com.oscar.todo_list.Service;

import com.oscar.todo_list.DTO.UserDTO;

public interface UserService {
    UserDTO findById(Long id);
    UserDTO create(UserDTO user);
}
