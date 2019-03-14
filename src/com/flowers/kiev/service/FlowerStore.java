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
        wallet(rose, chamomile, tulip);
        int count = rose + chamomile + tulip;
        Flower[] flowers = new Flower[count];
        for (int i = 0; i < count;) {
            if (rose > 0){
                flowers[i++] = new Rose();
                rose--;
            }
            if (chamomile > 0){
                flowers[i++] = new Chamomile();
                chamomile--;
            }
            if (tulip > 0){
                flowers[i++] = new Tulip();
                tulip--;
            }
        }
        return flowers;
    }

}
