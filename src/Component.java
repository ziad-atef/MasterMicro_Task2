import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class Component {
    private String ID, Type;

    Component(String id, String type){
        ID = id;
        Type = type;
    }



    public String getId() {
        return ID;
    }


    public String getType() {
        return Type;
    }

    public abstract boolean isConnected(String node);
}
