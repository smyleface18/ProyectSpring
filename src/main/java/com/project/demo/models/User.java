package com.project.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String lastname;
    private String email;

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

}
