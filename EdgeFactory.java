import org.apache.commons.collections15.Factory;

// This class simply makes a factory for our edges. The create() function makes a new edge and increments e, so that
// each edge will have a different id. Check the edge class's constructor.
class EdgeFactory implements Factory
{
    private int e = 0;
    public edge1 create()
    {
        return (new edge1(e++));
    }
}
