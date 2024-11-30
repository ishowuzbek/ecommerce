package org.example.workingwithgithub.services;


import org.example.workingwithgithub.entiry.DB;
import org.example.workingwithgithub.entiry.Product;

public class ProductService {

    public static Product getProductById(int id) {
        for (Product product : DB.PRODUCTS) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }



}