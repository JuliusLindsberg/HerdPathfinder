package org.herdsimulation.Models;

import org.herdsimulation.Behaviors.State;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.crypto.dsig.XMLObject;
import java.util.List;
import java.util.Map;

// this is the subjective model of the map the herd uses for calculating the utilities from its policies.
// The model by design is an imperfect representation of the 2D map with statistical probabilities
// making up for various unobserved confounders. New policies are generated on runtime when the herd observes its surroundings.
// Habits are closed loops formed of known viable policies. If a habit is broken by changes in the environment, the
// herd is supposed to search for alternative routes.

public class Model
{
    Map<String, State> states;
    public static String XMLMathExpression(XMLObject element)
    {

        return null;
    }
    protected Model()
    {

    }
    protected void InitializeModel(Node type)
    {
        NamedNodeMap attributes = type.getAttributes();
        attributes.getNamedItem("");
    }
    String[] policies;
    //String[] habits;
    public void reset()
    {
        policies = null;
    }

}
