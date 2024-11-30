package org.example.workingwithgithub.entiry;

import java.util.ArrayList;
import java.util.List;

public interface DB {
    List<User> USERS = new ArrayList<User>(
            List.of(new User("Muhammadamin", "123", "admin"),
                    new User("Samandar", "123", "user"),
                    new User("Elshod", "123", "user"))
    );
    List<Category> CATEGORIES = new ArrayList<>(List.of(
            new Category("Food"),
            new Category("Drinks")
    ));
    List<Product> PRODUCTS = new ArrayList<>(List.of(
            new Product("Osh", 40000, 1, "D:/javanew/Ecom/files/osh.jpg"),
            new Product("Sho'rva", 35000, 1, "D:/javanew/Ecom/files/sho'rva.jpg"),
            new Product("Xonim 5", 40000, 1, "D:/javanew/Ecom/files/xonim.jpg"),
            new Product("Suv", 5000, 2, "D:/javanew/Ecom/files/suv.jpg")
    ));
    List<BasketProduct> BASKET_PRODUCTS = new ArrayList<>();
    List<OrderItem> ORDER_ITEMS = new ArrayList<>();
    List<Order> ORDERS = new ArrayList<>();
}
