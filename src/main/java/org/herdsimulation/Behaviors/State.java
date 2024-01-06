package org.herdsimulation.Behaviors;

import org.herdsimulation.*;

public abstract class State
{

    public abstract HerdMode transition();
    public abstract void behavior(Model model);
}
