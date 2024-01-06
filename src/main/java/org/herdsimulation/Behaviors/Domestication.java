package org.herdsimulation.Behaviors;

import org.herdsimulation.Model;

public class Domestication extends State {
    float radius;
    public Domestication(float _radius)
    {
        radius = _radius;
    }
    @Override
    public HerdMode transition() {
        return null;
    }

    @Override
    public void behavior(Model model) {

    }
}
