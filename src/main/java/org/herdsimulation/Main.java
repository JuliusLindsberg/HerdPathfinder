package org.herdsimulation;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Herd simulation!");

        Map2D gameMap = new Map2D();

        gameMap.printCell("10:15");
        gameMap.printCell("20:7");
        gameMap.printCell("16:0");

    }
}