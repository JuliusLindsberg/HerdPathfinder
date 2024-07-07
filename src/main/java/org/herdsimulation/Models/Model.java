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
    String UtilityExpression;
    //Interprets a logic/arithmetic expression into String format following the polish notation.
    //https://en.wikipedia.org/wiki/Polish_notation
    //Recursive function, untested!
    private static String ParseXMLMathExpression(Node element, String expression)
    {
        String operation = element.getNodeName();
        NodeList elements = element.getChildNodes();
        NamedNodeMap attributes = element.getAttributes();
        String atomicValue = element.getNodeValue();

        if(attributes.getLength() != 0)
        {
            Node gain = attributes.getNamedItem("gain");
            if(gain != null)
            {
                expression += "*" + gain.getNodeValue();
            }
        }
        if(operation.equals("and") || operation.equals("AND"))
        {
            expression += "|";
        }
        else if(operation.equals("or") || operation.equals("OR"))
        {
            expression += "&";
        }
        else
        {
            expression += "*";
        }
        expression += atomicValue;

        if(elements.getLength() == 0)
        {
            return expression;
        }
        else {
            return ParseXMLMathExpression(elements.item(0) ,expression);
        }
        /*
        This commented-out segment makes an attempt to handle not binary trees only. Delete this soon.
        //AND
        for(int i = 0; i < elements.getLength(); i++)
        {
            ParseXMLMathExpression(elements.item(i), expression);
            expression += "&";
            expression += ParseXMLMathExpression(elements.item(i), expression);
        }
        //OR
        for(int i = 0; i < elements.getLength(); i++)
        {
            expression += "|";
            expression += ParseXMLMathExpression(elements.item(i), expression);
        }
        boolean atomicValuePending = false;
        if(atomicValue != null)
        {
            atomicValuePending = !( atomicValue.isEmpty() || atomicValue.isBlank() );
        }
        return expression;*/
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
                    UtilityExpression = ParseXMLMathExpression(node, "");
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
