package org.herdsimulation.Models;

import org.herdsimulation.Behaviors.State;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.crypto.dsig.XMLObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// this is the subjective model of the map the herd uses for calculating the utilities from its policies.
// The model by design is an imperfect representation of the 2D map with statistical probabilities
// making up for various unobserved confounders. New policies are generated on runtime when the herd observes its surroundings.
// Habits are closed loops formed of known viable policies. If a habit is broken by changes in the environment, the
// herd is supposed to search for alternative routes.

public class Model
{
    HashMap<String, State> states;
    public static String XMLMathExpression(Node element)
    {

        return null;
    }
    protected Model()
    {

    }
    protected void InitializeModel(Node element)
    {
        NamedNodeMap attributes = element.getAttributes();
        Node mob = attributes.getNamedItem("mob");
        Node ratio = attributes.getNamedItem("ratio");
        NodeList childNodes = element.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++)
        {
            Node node = childNodes.item(i);
            String name = node.getNodeName();
            switch (name)
            {
                case "Utility":
                    break;
                case "Exploration":
                    break;
                case "Roaming":
                    break;
                default:
                    continue;
            }
        }
    }
    String[] policies;
    //String[] habits;
    public void reset()
    {
        policies = null;
    }

}
