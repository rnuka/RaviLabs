package objects;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by crathinasababathy on 4/23/16.
 */
public class FileUtil {
    public void write2File(FileWriter fileWriter, String str){
        try {
          fileWriter.write(str);
        }catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    public static void main (String args[]){
        System.out.println("FileUtil.java");
    }
}
