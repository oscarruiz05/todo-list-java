package com.oscar.todo_list.Service.Impl;

import com.oscar.todo_list.DTO.TaskDTO;
import com.oscar.todo_list.Exception.NotFoundException;
import com.oscar.todo_list.Repository.TaskRepository;
import com.oscar.todo_list.Service.TaskService;
import com.oscar.todo_list.model.Task;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<TaskDTO> findAll() {
        return List.of();
    }

    @Override
    public TaskDTO findById(Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task", id));
        return this.modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public TaskDTO create(TaskDTO task) {
        return null;
    }

    @Override
    public TaskDTO update(Long id, TaskDTO task) {
        return null;
    }

    @Override
    public String delete(Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task", id));
        this.taskRepository.delete(task);
        return "Task deleted successfully";
    }
}
