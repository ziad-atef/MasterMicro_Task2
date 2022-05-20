import java.util.HashMap;

public class Resistor extends Component {

    public Resistor(String id) {
        super(id, "resistor");
        properties = new HashMap<>(3);
        netList = new HashMap<>(2);
    }
}
