package practice.coding.parsers;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by rnuka on 10/20/15.
 */

/*
input sample.json

{
    "age":30,
    "name":"ravi nuka",
    "address":["San Ramon","CA","94582"]
}

 */
public class JsonParser {


   private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    //read from url
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            Object obj = parser.parse(jsonText);
            json = (JSONObject)parser.parse(jsonText);
            return json;
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            is.close();
        }

        return json;

    }




    //read from text file
    public Integer loadJSONFile()
    {
        JSONParser parser = new JSONParser();
        try{

            Object obj = parser.parse(new FileReader("/Users/rnuka/Desktop/sample.json"));
            JSONObject jsonObj = (JSONObject)obj;

            Long age = (Long)jsonObj.get("age");
            System.out.println("age:"+age);

            String name = (String)jsonObj.get("name");
            System.out.println("name:" + name);

            JSONArray address = (JSONArray)jsonObj.get("address");

            for(Object str : address){
                System.out.println(str);
            }



        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    public static void main(String[] args){
        JsonParser cjp = new JsonParser();
        cjp.loadJSONFile();
        try {
            JSONObject json = cjp.readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=2de143494c0b295cca9337e1e96b00e0");
            System.out.println(json.toString());
            System.out.println("------");

            JSONObject main = (JSONObject)json.get("main");
            System.out.println(main.toString());
            System.out.println("------");
            System.out.println("min:"+main.get("temp_min"));
            System.out.println("max:"+main.get("temp_max"));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
