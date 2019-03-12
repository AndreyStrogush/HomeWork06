package com.flowers;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Flower[] flowersHeap = FlowerStore.sell(5,3,1);
        Flower[] flowersBuckets = FlowerStore.sellSequence(5,3,11);

        Stream.of(flowersHeap).forEach(System.out:: print);
        System.out.println();
        Stream.of(flowersBuckets).forEach(System.out:: print);
//
//        System.out.println(Arrays.toString(flowersHeap));
//        System.out.println(Arrays.toString(flowersBuckets));

    }
}
