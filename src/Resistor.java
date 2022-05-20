import java.util.HashMap;
import java.util.Vector;

public class Resistor extends Component {

    Vector<Float> Values;
    Vector<String> Nodes;
    public Resistor(String id) {
        super(id, "resistor");
        Values = new Vector<Float>(3);
        Nodes = new Vector<String>(2);
    }

    @Override
    public boolean isConnected(String node) {
        return Nodes.contains(node);
    }
}
