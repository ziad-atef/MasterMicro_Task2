import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        API TestAPI = new API();

        System.out.println("Hello, World!");
        // parsing file "JSONExample.json"
        TestAPI.readJSON("D:\\GitHub\\MasterMicro_Task2\\src\\topology.json");



    }
}