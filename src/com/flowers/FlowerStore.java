package com.flowers;

public class FlowerStore {
    static int wallet() {
        int cash = Rose.getPrice() * Rose.getNumOfInstances()
                + Chamomile.getPrice() * Chamomile.getNumOfInstances()
                + Tulip.getPrice() * Tulip.getNumOfInstances();
        return cash;
    }

    static Flower[] sell(int rose, int chamomile, int tulip) {
        Flower[] flowers = new Flower[rose + chamomile + tulip];
        for (int i = 0; i < rose + chamomile + tulip; i++) {
            if (i < rose) {
                flowers[i] = new Rose();
            } else if (i < (rose + chamomile)) {
                flowers[i] = new Chamomile();
            } else {
                flowers[i] = new Tulip();
            }
            //System.out.print(FlowerStore.wallet() + ", ");
        }
        return flowers;
    }

    static Flower[] sellSequence(int rose, int chamomile, int tulip) {
        int min = Math.min(rose, Math.min(chamomile, tulip));
        int max = Math.max(rose, Math.max(chamomile, tulip));
        int mid = rose + chamomile + tulip - (min + max);

        Flower[] flowers = new Flower[rose + chamomile + tulip];
        for (int i = 0; i < rose + chamomile + tulip; i++) {
            //if i< minimal number of flowers  - add all 3 of them in a row and increment i 2 times
            if (i < min * 3) {
                flowers[i] = new Rose();
                flowers[i + 1] = new Chamomile();
                flowers[i + 2] = new Tulip();
                i = i + 2;
            }
            //if i> min and less then mid  - we have 3 option how to add 2 flowers in to bucket
            //depending of which of them is minimum represented
            if (i >= min * 3 && i < (min * 3 + (mid - min) * 2)) {
                //then i < min  - every bucket add 3 flowers
                //bitween  min and mid values every bucket consist of 2 flowers
                if (min == rose) {
                    flowers[i] = new Chamomile();
                    flowers[i + 1] = new Tulip();
                    i = i + 1;
                }
                if (min == chamomile) {
                    flowers[i] = new Rose();
                    flowers[i + 1] = new Tulip();
                    i = i + 1;
                }
                if (min == tulip) {
                    flowers[i] = new Rose();
                    flowers[i + 1] = new Chamomile();
                    i = i + 1;
                }
            }
            //if i > mid  - we have only 1 flower left to add, depending which of them is max represented
            if (i >= (min * 3 + (mid - min) * 2)) {
                if (max == rose) {
                    flowers[i] = new Rose();
                }
                if (max == chamomile) {
                    flowers[i] = new Chamomile();
                }
                if (max == tulip) {
                    flowers[i] = new Tulip();
                }
            }
        }
        return flowers;
    }

}
