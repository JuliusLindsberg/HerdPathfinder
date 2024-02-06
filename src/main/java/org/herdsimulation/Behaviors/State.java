package org.herdsimulation.Behaviors;

import jdk.jshell.spi.ExecutionControl;
import org.herdsimulation.Environment.Herd;
import org.herdsimulation.Environment.Map2D;
import org.herdsimulation.Models.HerdMode;
import org.herdsimulation.Models.Model;
import org.herdsimulation.Route.Policy;

public abstract class State
{
    //How far away cell scans can be conducted in chunks
    final int scanDistance = 4;
    private Map2D activeMap;
    // in theory, herds may end up in different dimensions.
    // The easiest way to deal with this problem would probably be by resetting the entire model and switch the map.
    // If this situation won't be dealt with in the final mod, crashes and undefined behavior would be likely follow.
    public void changeMap(Herd herd, Model model, Map2D newMap)
    {
        activeMap = newMap;
        model.reset();
    }
    //this function has many uses depending on what type of string is inputted <-
    public Policy[] cellScan(String scan)
    {
        if(activeMap == null)
        {
            throw new RuntimeException("An active Map2D was not selected to be used by a State before a cellScan() call.");
        }
        // -> If the input string contains a partial policy, a list of traversable routes from this point is returned
        // Example: 16:W@0:5
        if(scan.contains(","))
        {
            return activeMap.isTraversable(scan, scanDistance);
        }
        // -> If the input string contains a policy, knowledge on whether the route still appears to be traversable is returned
        // Example: 5:E@0:5,16:W@0:5
        else if(scan.contains("@"))
        {
            return activeMap.traversablesFrom(scan, scanDistance);
        }
        // -> If the input string contains cell coordinates, some random traversables from within this cell are returned
        // Example: 20:10
        else if(scan.contains(":"))
        {
            throw new ExecutionControl.NotImplementedException("Functionality for cell scans is not yet implemented!");
        }
        // -> Unknown scan format. As long as the activeMap has been set, cellScan function is supposed to be
        // safe from other exceptions than that.
        else
        {
            return null;
        }
    }
    static void setupMap()
    {

    }
    public abstract HerdMode transition(Herd herd, Model model);
    public abstract void behavior(Herd herd, Model model);
    public abstract void scan( Herd herd, Model model );
}
