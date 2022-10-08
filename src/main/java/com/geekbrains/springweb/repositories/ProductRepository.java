package com.geekbrains.springweb.repositories;

import com.geekbrains.springweb.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> groceryList;

    @PostConstruct
    public void init() {
        groceryList = new ArrayList<>(List.of(
                new Product(1, "milk", 80),
                new Product(2, "meat", 480),
                new Product(3, "olives", 350)
        ));
    }

    public List<Product> getAllProduct() {
        return Collections.unmodifiableList(groceryList);
    }

    public Product findIdProduct(Long id) {
        return groceryList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}

