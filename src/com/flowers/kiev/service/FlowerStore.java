package com.flowers.kiev.service;

import com.flowers.kiev.entity.Tulip;
import com.flowers.kiev.entity.Chamomile;
import com.flowers.kiev.entity.Flower;
import com.flowers.kiev.entity.Rose;

public class FlowerStore {
    private int cash;

    public int getCash() {
        return cash;
    }

    public void wallet(int rose, int chamomile, int tulip) {
        cash += new Rose().getPrice() * rose
                + new Chamomile().getPrice() * chamomile
                + new Tulip().getPrice() * tulip;
    }

    public Flower[] sell(int rose, int chamomile, int tulip) {
        Flower[] flowers = new Flower[rose + chamomile + tulip];
        for (int i = 0; i < rose; i++) {
            flowers[i] = new Rose();
        }
        for (int i = rose; i < rose + chamomile; i++) {
            flowers[i] = new Chamomile();
        }
        for (int i = rose + chamomile; i < rose + chamomile + tulip; i++) {
            flowers[i] = new Tulip();
        }
        wallet(rose, chamomile, tulip);
        return flowers;
    }

    public Flower[] sellSequence(int rose, int chamomile, int tulip) {
        int min = Math.min(rose, Math.min(chamomile, tulip));
        int max = Math.max(rose, Math.max(chamomile, tulip));
        int mid = rose + chamomile + tulip - (min + max);
        Flower[] flowers = new Flower[rose + chamomile + tulip];
        for (int i = 0; i < rose + chamomile + tulip; i++) {
            if (i < min * 3) {
                flowers[i] = new Rose();
                flowers[i + 1] = new Chamomile();
                flowers[i + 2] = new Tulip();
                i = i + 2;
            }
            if (i >= min * 3 && i < (min * 3 + (mid - min) * 2)) {
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
        wallet(rose, chamomile, tulip);
        return flowers;
    }

}
