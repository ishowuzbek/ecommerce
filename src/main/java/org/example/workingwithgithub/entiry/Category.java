package org.example.workingwithgithub.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    private Integer id=idGen++;
    private String name;
    private static Integer idGen=1;

    public Category(String name) {
        this.name = name;
    }
}
