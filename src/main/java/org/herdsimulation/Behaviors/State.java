package org.herdsimulation.Behaviors;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import org.herdsimulation.Environment.Agent;
import org.herdsimulation.Environment.Map2D;
import org.herdsimulation.Models.Model;
import org.herdsimulation.Route.Route;

import java.util.Set;

public abstract class State
{
    //How far away cell scans can be conducted in chunks
    int scanDistance = 4;
    Set<String> actionSpace;
    private Map2D activeMap;
    // in theory, herds may end up in different dimensions during runtime.
    // The easiest way to deal with this problem would probably be by resetting the entire model and switch the map.
    // Another way to resolve the issue would be to define the dimensions in the xml files of the herd.
    // If this situation won't be dealt with in the final mod, crashes and undefined behavior would be likely follow.
    public void changeMap(Agent agent, Model model, Map2D newMap)
    {
        activeMap = newMap;
        model.reset();
    }
    //this function has many uses depending on what type of string is inputted <-
    public Route[] cellScan(String scan)
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
            // Not implemented yet!
            return null;
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
    //returns the
    public abstract String transition(Model model);
    public abstract void behavior(Model model);
    public abstract void scan(Model model);
}
