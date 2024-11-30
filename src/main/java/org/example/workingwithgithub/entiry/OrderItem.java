package org.example.workingwithgithub.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItem {
    private Integer id=idGenerator++;
    private Integer orderId;
    private Integer productId;
    private Integer amount;

    private static Integer idGenerator =1;
    public OrderItem(Integer orderId, Integer productId, Integer amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }

}
