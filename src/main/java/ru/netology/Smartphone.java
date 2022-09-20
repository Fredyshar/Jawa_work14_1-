package ru.netology;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Smartphone extends Product {
    private String produced;

    public Smartphone(int id, String name, int price, String produced) {
        super(id, name, price);
        this.produced = produced;
    }

}

