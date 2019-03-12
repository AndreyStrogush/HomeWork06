package com.flowers;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    private static String fileName = "C://Users/Admin/IdeaProjects/HomeWork06/src/com/flowers//testFlower.txt";

    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();
        System.out.println("In wallet is now: " + flowerStore.getCash() + "$");
        Flower[] flowersHeap = flowerStore.sell(5, 3, 1);
        Stream.of(flowersHeap).forEach(System.out::print);
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");
        Flower[] flowersBuckets = flowerStore.sellSequence(5, 3, 11);
        Stream.of(flowersBuckets).forEach(System.out::print);
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");
        try {
            Flower[] flowersFromFile = FlowersLoader.load(fileName);
            Stream.of(flowersFromFile).forEach(System.out::print);
            System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
