package com.flowers.kiev.entity;

public abstract class Flower {
    private int price;

    public Flower(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public abstract String toString();
}
