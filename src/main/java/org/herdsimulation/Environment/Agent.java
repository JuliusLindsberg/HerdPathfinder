package org.herdsimulation.Environment;

import org.herdsimulation.Models.Model;

public class Agent extends Model
{
    char sign;
    int x, y;
    public int X()
    {
        return x;
    }
    public int Y()
    {
        return y;
    }
    public char Sign()
    {
        return sign;
    }
    public Agent(int _x, int _y, char _sign, String type)
    {
        super(type);
        //assign a random alphabet character as a symbol for the herd:
        // Cell.r.nextInt(65, 90)
        sign = _sign;
        x = _x; y = _y;
    }
}
