
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.io.GraphMLMetadata;
import edu.uci.ics.jung.io.GraphMLReader;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import org.apache.commons.collections15.BidiMap;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

class GraphML
{
    public GraphML(String filename) throws ParserConfigurationException, SAXException, IOException
    {
        //making a GraphML Reader to read a directed Graph of type node1 and edge1.
        GraphMLReader<DirectedGraph<node1, edge1>, node1, edge1> gmlr =
            new GraphMLReader<DirectedGraph<node1, edge1>, node1, edge1>(new VertexFactory(), new EdgeFactory());

        //Creating a directed graph object to store the graph data in
        final DirectedGraph<node1, edge1> graph = new DirectedSparseMultigraph<node1, edge1>();

        gmlr.load(filename, graph); //Here we read the graph from graphml file

        BidiMap<node1, String> vertex_ids = gmlr.getVertexIDs();  //The vertexIDs are stored in a BidiMap.
        Map<String, GraphMLMetadata<node1>> vertex_device = gmlr.getVertexMetadata(); //Our vertex Metadata is stored in a map.
        Map<String, GraphMLMetadata<edge1>> edge1_meta = gmlr.getEdgeMetadata(); // Our edge1 Metadata is stored in a map.

        //Taking info about edges
        for (node1 n : graph.getVertices())
        {
            n.setValue(vertex_ids.get(n)); //Set the value of the node1 to the vertex_id which was read in from the GraphML Reader.
            n.setDevice(vertex_device.get("d0").transformer.transform(n)); // Set the device, which we get from the Map, vertex_device.
            //Let's print out the data 
            System.out.println("ID: "+n.getID()+", Value: "+n.getValue()+", Device: "+n.getDevice());
        }      
        //Making a tree
        node1 out=new node1(1);
        for(node1 n: graph.getVertices())
        {
            if((n.getDevice().equals("out")))
            {
                out=n;
            }
        }
        TreeBuilder treeBuilder = new TreeBuilder(graph);
        List path= treeBuilder.getTree().getPath(out);
        Iterator i=path.iterator();
        while(i.hasNext())
        {
            Object obj=i.next();
            System.out.println(obj+" ");
        }
    }
}