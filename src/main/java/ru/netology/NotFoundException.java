package ru.netology;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        Product book1 = new Book(1, "Зеленая миля", 599, "Стивен Кинг");
        Product book2 = new Book(2, "Фантазеры", 250, "Николай Носов");
        Product book3 = new Book(3, "Колыбельная", 900, "Чак Паланик");
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        try {
            repo.removeById(4);
            System.out.println("Элемент удален");
        } catch (RuntimeException e) {
            System.out.println("ERROR: нет такого товара для удаления");
        }
        /*finally {
            System.out.println("text");
        } */

    }
}