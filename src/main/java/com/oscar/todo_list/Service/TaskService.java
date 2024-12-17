package com.oscar.todo_list.Service;

import com.oscar.todo_list.DTO.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAll();
    TaskDTO findById(Long id);
    TaskDTO create(TaskDTO task);
    TaskDTO update(Long id, TaskDTO task);
    String delete(Long id);
}
