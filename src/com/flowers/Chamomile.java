package com.flowers;

public class Chamomile extends Flower {
    private static int price = 70;
    private static int counter;

    public Chamomile() {
        counter++;
    }

    public static int getNumOfInstances() {
        return counter;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Chamomile.price = price;
    }

    @Override
    public String toString() {
        return "Chamomile, ";
    }

}
