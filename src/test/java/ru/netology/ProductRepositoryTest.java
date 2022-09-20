package ru.netology;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product book1 = new Book(1, "Зеленая миля", 599, "Стивен Кинг");
    Product book2 = new Book(2, "Фантазеры", 250, "Николай Носов");
    Product book3 = new Book(3, "Колыбельная", 900, "Чак Паланик");

    Product phone1 = new Smartphone(4, "iPhone", 60_000, "Apple");
    Product phone2 = new Smartphone(5, "Nokia", 10_000, "Nokia crp.");
    Product phone3 = new Smartphone(6, "Samsung", 50_000, "Android");
    Product phone4 = new Smartphone(7, "iPhone", 50_000, "Apple");


    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
    }

    @Test
    public void showAllproducts() {                                                 //показать все товары
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(phone1);
        repo.save(phone2);
        repo.save(phone3);
        repo.save(phone4);


        Product[] expected = {book1, book2, book3, phone1, phone2, phone3, phone4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteAnExistingById() {                                                 //удалить по Id существующий товар
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        repo.removeById(book2.getId());

        Product[] expected = {book1, book3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);


    }

}
