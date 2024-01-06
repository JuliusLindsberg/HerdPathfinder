package org.herdsimulation;

import org.herdsimulation.Behaviors.*;


import java.util.List;

public class Herd {
    HerdMode mode;

    public Herd()
    {
        mode = HerdMode.roaming;
        Model model = new Model();
        State[] behaviors = new State[] {
                new Domestication(20.0f),
                new Exploration(),
                new Roaming()};
    }
}
