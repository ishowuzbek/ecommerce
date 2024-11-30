package org.example.workingwithgithub.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private Integer id=idGen++;
    private String name;
    private Integer price;
    private Integer categoryId;
    private String photoUrl;
    private static Integer idGen=1;

    public Product(String name, Integer price, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Product(String name, Integer price, Integer categoryId, String photoUrl) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.photoUrl = photoUrl;
    }
    public String getCategoryName() {
        return DB.CATEGORIES.stream()
                .filter(category -> category.getId().equals(this.categoryId))
                .map(Category::getName)
                .findFirst()
                .orElse("Unknown");
    }
}
