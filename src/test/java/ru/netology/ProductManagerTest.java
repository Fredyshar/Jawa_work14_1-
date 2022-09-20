package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductManagerTest {
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

    public void searchByExistingProductName() {                     //поиск по названию существующего  продукта

        Product[] expected = {phone1, phone4};
        Product[] actual = manager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));

    }

    @Test

    public void searchByNonExistingProductName() {                     //поиск по названию не существующего  продукта

        Product[] expected = {};
        Product[] actual = manager.searchBy("motorolla");

        Assertions.assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));

    }


}
