package main;

import quickunion.QuickUnionImpl;
import weightedunion.WeightedUnionImpl;

public class Main {
    public static void main(String[] args) {
        int arraySize = 10;
        System.out.println("*****************Quick Union*************************");
        QuickUnionImpl quickUnion = new QuickUnionImpl(arraySize);
        quickUnion.union(0,1);
        quickUnion.union(5,0);
        quickUnion.union(6,5);
        quickUnion.union(2,1);
        quickUnion.union(7,1);
        quickUnion.union(3,8);
        quickUnion.union(9,8);
        quickUnion.union(4,3);
        quickUnion.union(1,8);
        //quickUnion.union(9,7); //Bruges til at tjekke - da 9 og 7 allerede er forbundet gennem træerne
        System.out.println("1 and 5 connected: " + quickUnion.connected(1,5));
        System.out.println("*****************Quick Union*************************");

        System.out.println("*****************Weighted Quick Union****************");
        WeightedUnionImpl weightedUnion = new WeightedUnionImpl(arraySize);
        weightedUnion.union(0,1);
        weightedUnion.union(5,0);
        weightedUnion.union(6,5);
        weightedUnion.union(2,1);
        weightedUnion.union(7,1);
        weightedUnion.union(3,8);
        weightedUnion.union(9,8);
        weightedUnion.union(4,3);
        weightedUnion.union(1,8);
        //quickUnion.union(9,7); //Bruges til at tjekke - da 9 og 7 allerede er forbundet gennem træerne
        System.out.println("1 and 5 connected: " + weightedUnion.connected(1,5));
        System.out.println("*****************Weighted Quick Union****************");
    }
}
