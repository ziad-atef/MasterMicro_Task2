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

    public String getID() {
        return ID;
    }

    public void  addComponent(Component component)
    {
        Components.add(component);
    }

    public Vector<Component> getComponents(){
        return Components;
    }

    public Vector<Component> getComponentsWithNetlistNode(String Node){

        Vector<Component> devices =new Vector<Component>();

        for(int i=0; i<Components.size();i++) {
            if (Components.get(i).isConnected(Node))
                devices.add(Components.get(i));
        }
        return devices;
    }
    @Override
    protected void finalize()
    {
        Components.clear();
    }
}
