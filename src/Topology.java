import java.util.Vector;

public class Topology {
    private String ID;
    private Vector<Component> Components;

    public Topology(String id) {
        ID = id;
    }

    public Topology(String id, int components)
    {
        ID = id;
        Components = new Vector<Component>(components);
    }

    public void  addComponent(Component component)
    {

    }
}
