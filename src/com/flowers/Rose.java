package com.flowers;

public class Rose extends Flower {
    private static int price = 100;
    private static int counter;

    public Rose() {
        counter++;
    }

    public static int getNumOfInstances() {
        return counter;
    }
    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Rose.price = price;
    }

    @Override
    public String toString() {
        return "Rose, ";
    }

}
