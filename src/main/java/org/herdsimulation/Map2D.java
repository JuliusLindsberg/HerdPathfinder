package org.herdsimulation;

import java.util.List;

// This class is responsible for keeping track of the real map. The real underlying data of the map are to be
// considered as unobserved confounders by the Model: there is only partial information present.
public class Map2D {
    static int defaultSize = 200;
    static public int getDefaultSize()
    {
        return defaultSize;
    }
    int width, height;
    Cell[][] cells;
    Cell cellByString(String cellID)
    {
        String[] separation = cellID.split(":", 2);
        System.out.println(separation[0]);
        return cells[ Integer.parseInt(separation[0]) ][ Integer.parseInt(separation[1]) ];
    }
    static public void setDefaultSize(int newSize)
    {
        defaultSize = newSize;
    }
    public Map2D(int _width, int _height)
    {
        cells = new Cell[width][height];
        width = _width; height = _height;
    }
    public Map2D()
    {
        width = defaultSize; height = defaultSize;
        cells = new Cell[width][height];
        for(int i = 0; i < height; i++) {
            for(int c = 0; c < width; c++) {
                cells[i][c] = new Cell( Math.min( 1.0f, Math.max( 0.0f, (float)Cell.r.nextGaussian(0.5, 0.2) ) ), c, i);
            }
        }
    }
    public Cell getCell(String cellID)
    {
        if(cellID.contains(","))
        {
            throw new UnsupportedOperationException("Real utility cannot be calculated from policies. Use a model for this instead.");
        }
        if(cellID.contains("@"))
        {
            String[] trueID = cellID.split("@", 2);
            return cellByString( trueID[1] );
        }
        else
        {
            return cellByString(cellID);
        }
    }
    public String[] generatePolicies(String cellID)
    {
        Cell surroundings = getCell(cellID);
        //String[] newPolicies = ;
        return null;
    }
    public void printCell(String cellID)
    {
        getCell(cellID).printCell();
    }
}
