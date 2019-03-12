package com.flowers;

public class Tulip extends Flower {
    private static int price = 45;
    private static int counter;

    public Tulip() {
        counter++;
    }

    public static int getNumOfInstances() {
        return counter;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Tulip.price = price;
    }

    @Override
    public String toString() {
        return "Tulip, ";
    }
}
