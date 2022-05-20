import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class Component {
    private String ID, Type;
    protected HashMap<String, Float> properties;
    protected HashMap<String, String> netList;

    Component(String id, String type){
        ID = id;
        Type = type;
    }

    public void addProperty(String name, float value){
        properties.put(name, value);
    }

    public void addNode(String terminal, String node){
        netList.put(terminal, node);
    }

    public String getId() {
        return ID;
    }


    public String getType() {
        return Type;
    }

    public boolean isConnected(String node)
    {
        return netList.containsValue(node);
    }
}
