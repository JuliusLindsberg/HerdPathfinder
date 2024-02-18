package org.herdsimulation.Behaviors;

import org.herdsimulation.Environment.Agent;
import org.herdsimulation.Models.Model;
import org.herdsimulation.Models.Herd;

// Herds in the exploration state wander freely within their environment, looking for grazeable terrain from their surroundings.
// Optimal performance is evaluated by the success in forming long chains of routes with viable grazing areas along the route.
// Boundaries of some superstructure such as a fence enclosure or, say, a grassland biome between a desert and an ocean are not yet known.
// Exploration behavior state is supposed to resemble most Lévy flight.
// https://en.wikipedia.org/wiki/L%C3%A9vy_flight
public class Dispersion extends State
{
    public Dispersion(String XMLName)
    {

    }
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
