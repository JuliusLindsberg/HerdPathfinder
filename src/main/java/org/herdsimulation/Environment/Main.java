package org.herdsimulation.Environment;

import org.herdsimulation.Environment.Map2D;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Herd simulation!");

        Map2D gameMap = new Map2D(40, 10, 5);

        gameMap.printCell("30:9");
        //gameMap.printCell("15:7");
        //gameMap.printCell("16:0");
        System.out.println("Now printing the game map");
        gameMap.printMap();
        gameMap.printMapSection(5, 10, 5, 10);
    }
}