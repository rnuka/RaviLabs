package practice.coding.strings;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;

public class QuoteSearch {
    public QuoteSearch() {
    }
    
    public static void main(String[] args)
    {
        URL url;
        try{
            url = new URL("http://finance.yahoo.com/q?s=goog");
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            String input = new String(baos.toByteArray(), encoding);
            //System.out.println(input);
            System.out.println("--------------");
            int start = input.indexOf("Last Trade:", 0);
            int from = input.indexOf("<b>", start);
            int to = input.indexOf("</b>", from);
            String price = input.substring(from + 3, to);
            System.out.println(price);
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        
    
}
