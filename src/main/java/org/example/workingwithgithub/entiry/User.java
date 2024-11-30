package org.example.workingwithgithub.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id=idGen++;
    private String name;
    private String password;
    private String role="user";
    private static Integer idGen=1;

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Integer id) {
        this.id = id;
    }
}
