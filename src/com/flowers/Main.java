package com.flowers;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();
        System.out.println("In wallet is now: " + flowerStore.getCash() + "$");
        Flower[] flowersHeap = flowerStore.sell(5, 3, 1);
        Stream.of(flowersHeap).forEach(System.out::print);
        System.out.println();
        System.out.println("In wallet is now: " + flowerStore.getCash() + "$");
        Flower[] flowersBuckets = flowerStore.sellSequence(5, 3, 11);
        Stream.of(flowersBuckets).forEach(System.out::print);
        System.out.println();
        System.out.println("In wallet is now: " + flowerStore.getCash() + "$");

//        System.out.println(Arrays.toString(flowersHeap));
//        System.out.println(Arrays.toString(flowersBuckets));
//        Stream.of(flowersHeap).forEach(item-> {
//            System.out.print(item);
//            System.out.println(FlowerStore.wallet());
//        });
    }
}
