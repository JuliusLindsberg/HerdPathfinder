package org.herdsimulation.Route;

// When Policy interacts with the model, utility interacts with the environment.
// The information flow of the simulation is:
// Policy -> Utility <-> Environment (Map2D)

import org.herdsimulation.Route.Policy;

// This is going to be a challenge to implement, since on one hand MDPs are supposed to not be bound by time or state.
// On the other hand, the utility of actions taken are dependent on various environmental factors which are dynamic in nature.
public class Utility extends Policy
{
    int timeStamp;
    Utility(String startPoint, String endPoint) {
        super(startPoint, endPoint);
    }
}
