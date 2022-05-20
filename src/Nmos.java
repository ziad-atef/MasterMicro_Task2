import java.util.HashMap;


public class Nmos extends Component{

    Nmos(String id) {
        super(id, "nmos");
        properties = new HashMap<>(3);
        netList = new HashMap<>(3);
    }


}
