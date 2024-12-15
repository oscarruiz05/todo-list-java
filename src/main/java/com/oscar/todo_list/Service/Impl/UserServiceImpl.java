package com.oscar.todo_list.Service.Impl;

import com.oscar.todo_list.DTO.UserDTO;
import com.oscar.todo_list.Exception.FieldAlreadyExistsException;
import com.oscar.todo_list.Exception.NotFoundException;
import com.oscar.todo_list.Repository.UserRepository;
import com.oscar.todo_list.Service.UserService;
import com.oscar.todo_list.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO findById(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User", id));
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new FieldAlreadyExistsException("username", userDTO.getUsername());
        }
        return this.modelMapper.map(this.userRepository.save(this.modelMapper.map(userDTO, User.class)), UserDTO.class);
    }
}
