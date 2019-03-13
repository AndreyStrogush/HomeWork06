package com.flowers.kiev.service;

import com.flowers.kiev.entity.Tulip;
import com.flowers.kiev.entity.Chamomile;
import com.flowers.kiev.entity.Flower;
import com.flowers.kiev.entity.Rose;

import java.io.*;
import java.util.Scanner;

public final class FlowersLoader {

    public static Flower[] load(String fileName) {
        int rose = 0;
        int chamomile = 0;
        int tulip = 0;

        ClassLoader classLoader = FlowersLoader.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            rose = Integer.parseInt(scanner.nextLine());
            chamomile = scanner.nextInt();
            tulip = scanner.nextInt();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println("Created from file: \n " + fileName + ": \n " +
                "roses - " + rose + ";\n chamomiles - " + chamomile + ";\n tulips - " + tulip);
        Flower[] flowers = new Flower[rose + chamomile + tulip];

        for (int i = 0; i < rose + chamomile + tulip; i++) {
            if (i < rose) {
                flowers[i] = new Rose();
            } else if (i < (rose + chamomile)) {
                flowers[i] = new Chamomile();
            } else {
                flowers[i] = new Tulip();
            }
        }
        return flowers;
    }

    private FlowersLoader() {

    }

}
