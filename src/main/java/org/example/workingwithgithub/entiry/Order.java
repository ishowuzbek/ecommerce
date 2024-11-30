package org.example.workingwithgithub.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private Integer id=idGen++;
    private String status="NEW";
    private LocalDateTime orderDate;
    private Integer userId;
    private static Integer idGen=10000;

    public Order(LocalDateTime orderDate, Integer userId) {
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public Order(String status, LocalDateTime orderDate, Integer userId) {
        this.status = status;
        this.orderDate = orderDate;
        this.userId = userId;
    }
}
