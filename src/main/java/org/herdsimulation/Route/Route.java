package org.herdsimulation.Route;
// Policy is a hypothetical route from one cell to another.
// If the route is traversable, it has a value of 1. If not, the value is 0.
// Policies follow an optimal substructure.

//examples of policies being referred to by Strings:
// 5:E@0:5,16:W@0:5    10:N@5:5,3:S@5:5
// 2:N@10:14,4:S@10:10    6:S@11:300,7:E@11:300,0:N@42:42

import org.herdsimulation.Environment.Map2D;

// It is intended that policies and routes transition the information of the 2D map into a graph structure
// in order to be more compatible with Markov chains and Markov Decision Processes. It is hypothesized that
// this approach is going to manifest itself in the game as a thin and approximately uniform cloud of pathfinding
// probabilities of animal movement on the over-world.
public class Route
{
    String start;
    String end;
    // Whether the route may be passed through
    boolean traversable;
    // Whether the route is a two-way or one-way passage. Fences adjacent to blocks would be one way for some routes to be one-way paths.
    boolean directed;
    public Route(String startPoint, String endPoint)
    {
        start = startPoint;
        end = endPoint;
        traversable = false;
    }
    Route(boolean isTraversable)
    {
        traversable = isTraversable;
    }
    public float getUtility(Map2D worldMap, int time)
    {
        if(!traversable)
        {
            return 0.0f;
        }
        else if ( worldMap.getCell(start) != worldMap.getCell(end) )
        {
            throw new UnsupportedOperationException("Utility from multiple cells not implemented yet");
        }
        else
        {
            return worldMap.getCell(start).getCellReward() - 0 * (float) time;
        }
    }
}
