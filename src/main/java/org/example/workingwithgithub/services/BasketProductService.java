package org.example.workingwithgithub.services;


import org.example.workingwithgithub.entiry.DB;

public class BasketProductService {
    public static void deleteById(Integer id) {
        DB.BASKET_PRODUCTS.removeIf(product -> product.getId().equals(id));
    }
}
