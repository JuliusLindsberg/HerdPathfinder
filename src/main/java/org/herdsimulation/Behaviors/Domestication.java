package org.herdsimulation.Behaviors;

import org.herdsimulation.Environment.Herd;
import org.herdsimulation.Models.Model;

// In this state the overall motion of the Herd is enclosed within the boundaries of some superstructure such as fencing.
// The motion of the herd is to resemble Browninan motion as if motion of atoms within a thermal equilibrium. Under this
// behavior the probabilities for state-transitions when novel route discoveries to previously inaccessible chunks are found are high.
public class Domestication extends State
{
    float radius;
    public Domestication(String XMLName)
    {
        radius = _radius;
    }
    @Override
    public Herd transition(Herd herd, Model model) {
        return null;
    }

    @Override
    public void behavior(Herd herd, Model model) {

    }

    @Override
    public void scan(Herd herd, Model model)
    {

    }

}
