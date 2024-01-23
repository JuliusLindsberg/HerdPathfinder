package org.herdsimulation;

import org.herdsimulation.Behaviors.*;


import java.util.List;

public class Herd {
    HerdMode mode;
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
        symbol = (char)Cell.r.nextInt(65, 90);
        x = _x; y = _y;
        mode = HerdMode.roaming;
        Model model = new Model();
        State[] behaviors = new State[]
                {
                new Domestication(20.0f),
                new Exploration(),
                new Roaming()
                };
    }
}
