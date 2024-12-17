package com.oscar.todo_list.Repository;

import com.oscar.todo_list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
