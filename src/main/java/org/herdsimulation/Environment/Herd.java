package org.herdsimulation.Environment;

import org.herdsimulation.Behaviors.Domestication;
import org.herdsimulation.Behaviors.Exploration;
import org.herdsimulation.Behaviors.Roaming;
import org.herdsimulation.Behaviors.State;
import org.herdsimulation.Models.Model;

public class Herd
{
    char symbol;
    int x, y;
    public int X()
    {
        return x;
    }
    public int Y()
    {
        return y;
    }
    public char Symbol()
    {
        return symbol;
    }
    public Herd(int _x, int _y)
    {
        //assign a random alphabet character as a symbol for the herd
        symbol = (char) Cell.r.nextInt(65, 90);
        x = _x; y = _y;
    }
}
