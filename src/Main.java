import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");



        JSONObject jo = new JSONObject();

        jo.put("firstName", "John");
        jo.put("lastName", "Smith");
        jo.put("age", 25);

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("JSONExample.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.write(jo.toJSONString());

        pw.flush();
        pw.close();
    }
}