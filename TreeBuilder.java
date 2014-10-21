import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DirectedGraph;

public class TreeBuilder
{
    DelegateForest<node1,edge1> mTree;
    TreeBuilder(DirectedGraph<node1,edge1> graph)
    {
        mTree = new DelegateForest<node1, edge1>();
        for (node1 n : graph.getVertices())
        {
            mTree.addVertex(n);
        }
        for (edge1 e : graph.getEdges())
        {
            mTree.addEdge(e, graph.getSource(e),graph.getDest(e));
        }
    }

    public DelegateForest<node1, edge1> getTree()
    {
        return mTree;
    }
}
