package com.oscar.todo_list.Controller;

import com.oscar.todo_list.DTO.TaskDTO;
import com.oscar.todo_list.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<TaskDTO>> findAll() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO task) {
        return new ResponseEntity<>(taskService.create(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO task) {
        return new ResponseEntity<>(taskService.update(id, task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.delete(id), HttpStatus.OK);
    }
}
