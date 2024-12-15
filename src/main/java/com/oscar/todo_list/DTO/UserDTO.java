package com.oscar.todo_list.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {

    @JsonProperty("id_user")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
