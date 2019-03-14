package com.flowers.kiev;

import com.flowers.kiev.entity.Flower;
import com.flowers.kiev.service.FlowerSaver;
import com.flowers.kiev.service.FlowerStore;
import com.flowers.kiev.service.FlowersLoader;

import java.util.stream.Stream;

public class ConsoleApplication {
    private static final String FILE_NAME = "file/testFlower.txt";
    private static final String WRITE_TEST = "src/resources/file/testWriteFlower.txt";
    private static final String SECOND_WRITE_TEST = "src/resources/file/secondWriteTest.txt";

    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();

        System.out.println("In wallet is now: " + flowerStore.getCash() + "$");
        Flower[] flowersHeap = flowerStore.sell(5, 3, 2);
        Stream.of(flowersHeap)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");

        Flower[] flowersBuckets = flowerStore.sellSequence(5, 3, 11);
        Stream.of(flowersBuckets).
                forEach(x -> System.out.print(x + ", "));
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");

        Flower[] flowersFromFile = FlowersLoader.load(FILE_NAME);
        Stream.of(flowersFromFile)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println("\nIn wallet is now: " + flowerStore.getCash() + "$");

        FlowerSaver.save(WRITE_TEST, flowersBuckets);
        FlowerSaver.save(SECOND_WRITE_TEST, flowersHeap);
    }

}
