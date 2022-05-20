import java.util.HashMap;

public class miscellaneous extends Component{

    protected HashMap<String, Float> properties;
    protected HashMap<String, String> netList;
    miscellaneous(String id, String type) {
        super(id, type);
        properties = new HashMap<>();
        netList = new HashMap<>();
    }

    public void addProperty(String name, float value){
        properties.put(name, value);
    }

    public void addNode(String terminal, String node){
        netList.put(terminal, node);
    }

    public boolean isConnected(String node)
    {
        if( netList.containsValue(node) )
            return true;
        else
            return false;
    }

}
