package org.herdsimulation.Models;

import java.util.List;

// this is the subjective model of the map the herd uses for calculating the utilities from its policies.
// The model by design is an imperfect representation of the 2D map with statistical probabilities
// representing unobserved confounders. New policies are generated on runtime when the herd observes its surroundings.
// Habits are closed loops formed of known viable policies. If a habit is broken by changes in the environment, the
// herd is supposed to search for alternative routes.

public class Model
{
    String[] policies;
    //String[] habits;
    public Model(String XMLName)
    {

    }
    public Model(String[] policies)
    {

    }
    public void reset()
    {
        policies = null;
        //habits = null;
    }
}
