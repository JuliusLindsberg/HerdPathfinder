package org.herdsimulation.Environment;

import org.herdsimulation.Models.Model;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

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
    public Agent(int _x, int _y, char _sign, String XMLFile, String type, String mob)
    {
        super();
        System.out.println("Constructing Agent!");
        DocumentBuilder builder = null;
        Document doc = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            doc = builder.parse(new File(XMLFile));
            doc.getDocumentElement().normalize();

        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        Node constructorElement = null;
        NodeList nodeList = doc.getElementsByTagName(type);
        System.out.println(" nodeList length " + nodeList.getLength());
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            //System.out.println("prosessing element " + nodeList.item(i).getNodeName());
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            //System.out.println(" attributes length " + attributes.getLength());
            Node attribute = attributes.getNamedItem("mob");
            if( attribute != null)
            {
                System.out.println("Element found");
                constructorElement = nodeList.item(i);
                break;
            }
        }
        if(constructorElement == null)
        {
            throw new RuntimeException("Constructor element for agent of type (" + type + ", " + mob + ") was not found!");
        }
        //Initialize the MDP model using the XML file data
        InitializeModel(constructorElement);
        //assign a random alphabet character as a symbol for the herd:
        // Cell.r.nextInt(65, 90)
        sign = _sign;
        x = _x; y = _y;
        System.out.println("Agent constructed!");
    }
}
