package com.flowers;

import java.io.FileWriter;

public final class FlowerSaver {

    public static void save(String pathFile, Flower[] flowers) {
        try {
            FileWriter writer = new FileWriter(pathFile);
            int rose = 0, chamomile = 0, tulip = 0;

            for (int i = 0; i < flowers.length; ++i) {
                switch (flowers[i].toString()) {
                    case "Rose, ":
                        rose += 1;
                        break;
                    case "Chamomile, ":
                        chamomile += 1;
                        break;
                    case "Tulip, ":
                        tulip += 1;
                        break;
                }
            }
            writer.write(rose + "\n");
            System.out.println(rose);
            writer.write(chamomile + "\n");
            System.out.println(chamomile);
            writer.write(tulip + "\n");
            writer.write(System.lineSeparator());
            System.out.println(tulip);
            System.out.println("The file: " + pathFile + " has been written");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private FlowerSaver() {
    }

}
