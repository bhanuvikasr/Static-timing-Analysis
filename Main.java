import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
    	String filename = "treeAttribute.graphml";
    	if(args.length > 0)
            filename = args[0];
        new GraphML(filename);
    }
}