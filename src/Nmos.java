import java.util.HashMap;
import java.util.Vector;


public class Nmos extends Component{

    Vector<Float> Values;
    Vector<String> Nodes;
    Nmos(String id) {
        super(id, "nmos");
        Values = new Vector<Float>(3);
        Nodes = new Vector<String>(3);
    }

    public boolean isConnected(String node) {
        return Nodes.contains(node);
    }
}
