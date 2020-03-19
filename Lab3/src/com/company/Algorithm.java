package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class
Algorithm {


    public Algorithm() {
    }

    public double greedy(Knapsack backpack, List<Item> items){
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return Double.compare(i2.profitFactor(), i1.profitFactor());
            }
        });

        for (Item i: items) {
            if (backpack.getCapacity() < backpack.getLoad() + i.getWeight())
                break;
            backpack.addItem(i);
        }

        double result = 0;
        for (Item i: backpack.items) {
            result += i.getValue();
        }
        return result;
    }

    public double dynamic(Knapsack backpack, List<Item> items){
        int noOfItems = items.size();
        double [][]values = new double[noOfItems+1][(int) backpack.getCapacity()+1];

        for (int i = 0; i < backpack.getCapacity(); i++) {
            values[0][i] = 0;
        }
        for (int i = 1; i <= noOfItems; i++) {
            for (int w = 0; w <= backpack.getCapacity(); w++) {
                if (w == 0)
                    values[i][w] = 0;
                else if (items.get(i - 1).getWeight() <= w && items.get(i - 1).getValue() + values[i - 1][w - items.get(i - 1).getWeight()] > values[i - 1][w]) {
                    values[i][w] = items.get(i - 1).getValue() + values[i - 1][w - items.get(i - 1).getWeight()];
                } else {
                    values[i][w] = values[i - 1][w];
                }
            }
        }


        int weight = (int) backpack.getCapacity();
        int index2 = items.size();
        double value = values[noOfItems][(int) backpack.getCapacity()];
        while (value > 0.000001   && index2 > -1) {
            if (values[index2][weight] == values[index2 - 1][weight])
                index2 --;
            else {
                backpack.addItem(items.get(index2-1));
                weight = weight - items.get(index2-1).getWeight();
                value = value - items.get(index2-1).getValue();
                index2 --;
            }

        }

        return values[noOfItems][(int) backpack.getCapacity()];
    }
}
