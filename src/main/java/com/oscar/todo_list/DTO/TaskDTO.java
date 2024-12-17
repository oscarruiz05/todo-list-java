package com.oscar.todo_list.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private boolean done;
    @JsonProperty("user_id")
    private Long userId;
}
