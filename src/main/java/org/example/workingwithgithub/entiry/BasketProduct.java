package org.example.workingwithgithub.entiry;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketProduct {

    private Integer id=gen++;
    private Integer productId;
    private Integer userId;
    private Integer amount;
    private Integer price;
    private static Integer gen=1;

    public BasketProduct(Integer productId,Integer userId, Integer amount, Integer price) {
        this.productId = productId;
        this.userId = userId;
        this.amount = amount;
        this.price = price;
    }
}
