package org.herdsimulation;
//import java.lang.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.lang.Math.random;
import static java.lang.Math.round;

// examples of cells referred to by Strings:
// 15:50    0:5    10:10
public class Cell {

    public static String intToDirection(int dir)
    {
        return switch (dir) {
            case 0 -> "N";
            case 1 -> "W";
            case 2 -> "S";
            case 3 -> "E";
            default -> "?";
        };
    }
    public static int DirectionToInt(String dir)
    {
        return switch (dir) {
            case "N" -> 0;
            case "W" -> 1;
            case "S" -> 2;
            case "E" -> 3;
            default -> -1;
        };
    }
    public final static int cellSize = 16;
    public final static float minReward = 0.0f;
    public final static float maxReward = 1.0f;
    public static Random r = new Random();
    float obstacleRate = 0.5f;
    final String cellID;
    static float randomReward()
    {
        return r.nextFloat(minReward, maxReward);
    }

    ArrayList<String> traversables;
    ArrayList<String> generateTraversables(float _obstacleRate)
    {
        ArrayList<String> newTraversables = new java.util.ArrayList<>(Collections.emptyList());
        //
        float traversableRate = (float) r.nextGaussian((double)(1.0f-obstacleRate)*(float)cellSize*cellSize, (double)(float)cellSize);
        int traversableCount =  round(traversableRate);
        for( int i = 0; i < traversableCount; i++ ) {

            int d1;
            int d2;
            do {
                d1 = r.nextInt(0, 4);
                d2 = r.nextInt(0, 4);
            } while (d1 == d2);
            String direction1 = intToDirection(d1);
            String direction2 = intToDirection(d2);
            String path = String.valueOf(r.nextInt(0, cellSize)) + ":" + direction1 + "@" + cellID + ","
                    + String.valueOf(r.nextInt(0, cellSize)) + ":" + direction2 + "@" + cellID;
            newTraversables.add(path);
        }
        return newTraversables;
    }

    float reward;
    public Cell(float _obstacleRate, int x, int y)
    {
        cellID = String.valueOf(x) + ":" + String.valueOf(y);
        obstacleRate = _obstacleRate;
        reward = randomReward();
        traversables = generateTraversables(obstacleRate);
    }
    public int getCellSize()
    {
        return cellSize;
    }
    public float getCellReward()
    {
        return reward;
    }

    public void printCell()
    {
        int printablesCount = Math.min(10, traversables.size());
        System.out.println( "Printing cell " + cellID + "!" );
        System.out.println( "Cell has " + traversables.size() + " traversables. Printing a random sample of " + printablesCount + " elements:" );
        for(int i = 0; i < printablesCount; i++)
        {
            System.out.println( traversables.get(r.nextInt(0, printablesCount)) );
        }
    }

}
