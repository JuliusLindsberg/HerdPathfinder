package org.herdsimulation;
// Policy is a hypothetical route from one cell to another.
// If the route is traversable, it has a value of 1. If not, the value is 0.
// Policies follow an optimal substructure.

//examples of policies being referred to by Strings:
// 5:E@0:5,16:W@0:5    10:N@5:5,3:S@5:5
// 2:N@10:14,4:S@10:10    6:S@11:300,7:E@11:300,0:N@42:42
public class Policy
{
    static final float timePenalty = -0.1f;
    String start;
    String end;
    boolean traversable;
    Policy(String startPoint, String endPoint)
    {
        start = startPoint;
        end = endPoint;
        traversable = false;
    }
    Policy(boolean isTraversable)
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
            return worldMap.getCell(start).getCellReward() - timePenalty * (float) time;
        }
    }
}
