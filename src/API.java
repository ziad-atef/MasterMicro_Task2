import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class API {

    private Vector<Topology> Topologies;

    public API(){
        Topologies = new Vector<>();
    }
    public boolean readJSON(String FileName) throws IOException, ParseException {
        String ComponentID = null, Type = null;
        Component device = null;

        Topology newTopology;
        Object obj = new JSONParser().parse(new FileReader(FileName) );

        // typecasting obj to JSONObject
        JSONObject topology = (JSONObject) obj;

        String TopologyID = (String) topology.get("id");

        newTopology = new Topology(TopologyID);

        System.out.println(TopologyID);

        JSONArray Components = (JSONArray) topology.get("components");

        Iterator<Map.Entry> itr1;
        Iterator itr2 = Components.iterator();

        while (itr2.hasNext())
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();

                if(pair.getKey().equals("id"))
                    ComponentID = (String) pair.getValue();
                else if (pair.getKey().equals("type")) {
                    Type = (String) pair.getValue();
                }

                System.out.println( ComponentID + Type);
            }

            if(Type.equals("resistor"))
            {
                device = new Resistor(ComponentID);
            } else if (Type.equals("nmos"))
            {
                device = new Nmos(ComponentID);
            } else if (Type != null)
            {
                device = new miscellaneous(ComponentID,Type);
            }

            newTopology.addComponent(device);
            device = null;

        }
        return true;
    }

    public void writeJSON(String TopologyID) {

        PrintWriter JsonWriter;
        JSONObject JsonObject = new JSONObject();
        try {
            JsonWriter = new PrintWriter("../topologies"+TopologyID);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Topology topology : Topologies) {
            if (topology.getID().equals(TopologyID)) {

            }
        }

        JsonWriter.write( JsonObject.toJSONString() );
        JsonWriter.flush();
        JsonWriter.close();
    }

    public Vector<Topology> queryTopologies() {

        return Topologies;
    }

    public void deleteTopology(String TopologyID) {

        for (Topology topology : Topologies) {
            if (topology.getID().equals(TopologyID)) {
                topology.finalize();
            }
        }
        System.gc();
    }

    public Vector<Component> queryDevices(String TopologyID) {

        for (Topology topology : Topologies) {
            if (topology.getID().equals(TopologyID)) {
                return topology.getComponents();
            }
        }
        return null;
    }

    public Vector<Component> queryDevicesWithNetlistNode(String TopologyID, String NetlistNodeID) {

        for (Topology topology : Topologies) {
            if (topology.getID().equals(TopologyID)) {
                return topology.getComponentsWithNetlistNode(NetlistNodeID);
            }
        }
        return null;
    }
}
