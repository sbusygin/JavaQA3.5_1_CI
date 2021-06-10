package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
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
    void searchByEng() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expected = new Product[]{smartphone1, smartphone2};
        Product[] result = productManager.searchBy("iPhone");
        assertArrayEquals(result, expected);
    }

    @Test
    void searchByRus() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expected = new Product[]{book1, book2};
        Product[] result = productManager.searchBy("Роулинг");
        assertArrayEquals(result, expected);
    }

    @Test
    void notFoundSearchBy() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expected = new Product[0];
        Product[] result = productManager.searchBy("Хоккинг}");
        assertArrayEquals(result, expected);
    }

    @Test
    void searchByNumb() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expected = new Product[]{smartphone2};
        Product[] result = productManager.searchBy("8");
        assertArrayEquals(result, expected);
    }
}