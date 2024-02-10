package org.herdsimulation.Environment;

import org.herdsimulation.Route.Policy;

import java.util.ArrayList;

// This class is responsible for keeping track of the real map. The real underlying data of the map are to be
// considered as unobserved confounders by the Model: there is only partial information present.
public class Map2D
{
    static int defaultSize = 200;
    static int defaultHerdSize = 1;
    static public int getDefaultSize()
    {
        return defaultSize;
    }
    int width, height;
    final int highTraversableThreshold = 200;
    final int lowTraversableThreshold = 100;
    Cell[][] cells;
    ArrayList<Agent> herds;
    Cell cellByString(String cellID)
    {
        String[] separation = cellID.split(":", 2);
        System.out.println(separation[0]);
        int x = Integer.parseInt(separation[0]);
        int y = Integer.parseInt(separation[1]);
        if(y >= height || x >= width )
        {
            throw new ArrayIndexOutOfBoundsException("Cell (" + x + ", " + y + ") is out of map bounds!");
        }
        return cells[ y ][ x ];
    }
    public Policy[] isTraversable(String scan, int distance)
    {
        Policy[] returnPolicy = null;

        return returnPolicy;
    }
    public Policy[] traversablesFrom(String scan, int distance)
    {
        Policy[] returnPolicy = null;

        return returnPolicy;
    }
    static public void setDefaultSize(int newSize)
    {
        defaultSize = newSize;
    }
    void generate(int _width, int _height, int herdAmount)
    {
        width = _width; height = _height;
        cells = new Cell[height][width];

        for(int i = 0; i < height; i++)
        {
            for(int c = 0; c < width; c++)
            {
                cells[i][c] = new Cell( Math.min( 1.0f, Math.max( 0.0f, (float)Cell.r.nextGaussian(0.5, 0.2) ) ), c, i);
            }
        }

        herds = new ArrayList<Agent>();
        for(int i = 0; i < herdAmount; i++)
        {
            herds.add(new Agent( Cell.r.nextInt(0, width) , Cell.r.nextInt(0, height) ));
        }
    }
    public Map2D(int _width, int _height, int herdAmount)
    {
        generate(_width, _height, herdAmount);
    }
    public Map2D()
    {
        generate(defaultSize, defaultSize, defaultHerdSize);
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
    public void printCell(int x, int y)
    {
        cells[y][x].printCell();
    }
    public void printCell(String cellID)
    {
        getCell(cellID).printCell();
    }
    public void printMapSection(int x1, int x2, int y1, int y2)
    {
        for(int i = y1; i < y2; i++)
        {
            for(int c = x1; c < x2; c++)
            {
                boolean herdResiding = false;
                // if any herds are residing in this cell, print the symbol of the first herd instead
                if(!herds.isEmpty())
                {
                    for(Agent herd: herds)
                    {
                        if(herd.X() == c && herd.Y() == i)
                        {
                            System.out.print(herd.Symbol());
                            herdResiding = true;
                            break;
                        }
                    }
                }
                if(!herdResiding)
                {
                    if( cells[i][c].traversables.size() > highTraversableThreshold )
                    {
                        System.out.print('|');
                    }
                    else if( cells[i][c].traversables.size() > lowTraversableThreshold )
                    {
                        System.out.print(':');
                    }
                    else if(cells[i][c].traversables.size() > 1)
                    {
                        System.out.print('.');
                    }
                    else{
                        System.out.print(' ');
                    }
                }
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
    public void printMap()
    {
        printMapSection(0, width, 0, height);
    }
}
