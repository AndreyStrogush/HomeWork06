package com.flowers;

import java.util.stream.Stream;

public class Main {
    private static String fileName = "C://Users/Admin/IdeaProjects/HomeWork06/src/com/flowers//testFlower.txt";
    private static String newFile = "C://Users/Admin/IdeaProjects/HomeWork06/src/com/flowers//testWriteFlower.txt";
    private static String secondTest = "secondTest.txt";

    public static void main(String[] args) throws Exception {
        FlowerStore flowerStore = new FlowerStore();
        //test1
        System.out.println("In wallet is now: " + flowerStore.getCash() + "$");
        Flower[] flowersHeap = flowerStore.sell(5, 3, 1);
        Stream.of(flowersHeap).forEach(System.out::print);
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");
        //test2
        Flower[] flowersBuckets = flowerStore.sellSequence(5, 3, 11);
        Stream.of(flowersBuckets).forEach(System.out::print);
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");
        //test3
        Flower[] flowersFromFile = FlowersLoader.load(fileName);
        Stream.of(flowersFromFile).forEach(System.out::print);
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");
        //test4
        FlowerSaver.save(newFile, flowersBuckets);
        FlowerSaver.save(secondTest, flowersHeap);
    }

}
