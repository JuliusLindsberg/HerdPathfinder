package org.herdsimulation.Behaviors;
import org.herdsimulation.Models.Model;

// This is the hardest model state to give a straight description of, but it is best understood as an intermediary between
// Domestication and Exploration. In the roaming state, the boundaries of a superstructure are somewhat known, but in the
// Atoms in a fluid analogy thermal equilibrium has not yet been achieved. The most likely reason for this being the presence
// Of other herds in the area. Under the Roaming behavior optimal policies are to be found mainly by scheduling previously known route
// patterns. The hope being that this state will simultaneously optimize grazing while still preserving individual behavioral patterns
// between multiple herds with differing knowledge of route patterns in an environment.

public class Roaming extends State
{
    @Override
    public String transition(Model model)
    {
        return null;
    }

    @Override
    public void behavior(Model model)
    {

    }
    @Override
    public void scan(Model model)
    {

    }
}
