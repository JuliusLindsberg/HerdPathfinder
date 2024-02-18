package org.herdsimulation.Environment;

import org.herdsimulation.Models.Model;
import org.w3c.dom.Document;
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
    public Agent(int _x, int _y, char _sign, String XMLFile, String type)
    {
        super();
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

        NodeList nodeList = doc.getElementsByTagName(type);
        Node first = nodeList.item(0);

        //Initialize the MDP model with the help of XML data
        InitializeModel(first);
        //assign a random alphabet character as a symbol for the herd:
        // Cell.r.nextInt(65, 90)
        sign = _sign;
        x = _x; y = _y;
    }
}
