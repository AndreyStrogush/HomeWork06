package com.flowers.kiev.service;

import com.flowers.kiev.entity.Tulip;
import com.flowers.kiev.entity.Chamomile;
import com.flowers.kiev.entity.Flower;
import com.flowers.kiev.entity.Rose;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class FlowersLoader {

    public static Flower[] load(String fileName) {
        Flower[] flowers = new Flower[0];
        int rose;
        int chamomile;
        int tulip;
        ClassLoader classLoader = FlowersLoader.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            rose = Integer.parseInt(scanner.nextLine());
            chamomile = scanner.nextInt();
            tulip = scanner.nextInt();
            flowers = new Flower[rose + chamomile + tulip];
            System.out.println("Created from file: \n " + fileName + ": \n " +
                    "roses added: " + rose + ";\n chamomiles added: " + chamomile + ";\n tulips added: " + tulip);
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
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return flowers;
    }

    private FlowersLoader() {
    }

}
