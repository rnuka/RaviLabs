package practice.coding.parsers;

import java.io.FileReader;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.simple.parser.JSONParser;

/**
 * Created by rnuka on 12/12/15.
 */
public class JsonParser2 {

    public static void main(String args[]){
        JSONParser jp = new JSONParser();
        try {
            Object obj = jp.parse(new FileReader("/Users/rnuka/Desktop/Sample.json"));


        }catch(JSONException e){

        }catch(Exception e){

        }


    }
}
