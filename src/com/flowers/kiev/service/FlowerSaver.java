package com.flowers.kiev.service;

import com.flowers.kiev.entity.Flower;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class FlowerSaver {

    public static void save(String fileName, Flower[] flowers) {
        int rose = 0;
        int chamomile = 0;
        int tulip = 0;

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < flowers.length; ++i) {
                switch (flowers[i].toString()) {
                    case "Rose":
                        rose += 1;
                        break;
                    case "Chamomile":
                        chamomile += 1;
                        break;
                    case "Tulip":
                        tulip += 1;
                        break;
                }
            }
            writer.write(rose + "\n");
            System.out.println(rose + " Roses added ");
            writer.write(chamomile + "\n");
            System.out.println(chamomile + " Chamomiles added ");
            writer.write(tulip + "\n");
            writer.write(System.lineSeparator());
            System.out.println(tulip + " Tulips added ");
            System.out.println("The file: " + fileName + " has been written");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FlowerSaver() {
    }

}
