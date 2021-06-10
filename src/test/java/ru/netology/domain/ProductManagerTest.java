package ru.netology.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);
    Book book1 = new Book(1, "Гарри поттер", 250, "Джоан Роулинг");
    Book book2 = new Book(2, "Гарри поттер 2", 340, "Джоан Роулинг");
    Smartphone smartphone1 = new Smartphone(2, "iPhone SE", 5400, "China45");
    Smartphone smartphone2 = new Smartphone(2, "iPhone 8", 4900, "China43");



    @Test
    void searchBy() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expected = new Product[]{smartphone1, smartphone2};
        Product[] result = productManager.searchBy("iPhone");
        assertArrayEquals(result, expected);
    }
}