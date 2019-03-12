package com.flowers;

import java.io.*;

public final class FlowersLoader {

    public static Flower[] load(String fileName) throws IOException, NumberFormatException {

        Flower[] flowers = new Flower[0];
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            int rose = Integer.parseInt(in.readLine());
            int chamomile = Integer.parseInt(in.readLine());
            int tulip = Integer.parseInt(in.readLine());
            System.out.println("Created from file \n " +
                     fileName + ": \n " +
                    "rose " + rose + "; chamomile " + chamomile + "; tulip " + tulip);
            flowers = new Flower[rose + chamomile + tulip];
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
        } catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        return flowers;
    }

    private FlowersLoader() { //private constructor
    }

}
