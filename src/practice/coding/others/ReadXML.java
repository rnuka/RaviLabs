package practice.coding.others;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by rnuka on 11/5/15.
 */
public class ReadXML {
    public void mapXML(InputStream s){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(s);
            Element root = doc.getDocumentElement();
            System.out.println("root="+root.toString());
            if(root.getAttribute("id") != null && !root.getAttribute("id").trim().equals("")) {
                System.out.println("id="+root.getAttribute("id"));
            }
            NodeList nodes = root.getChildNodes();
            for(int i = 0; i < nodes.getLength(); i++ ) {
                Node node = nodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    if(e.getTagName()=="CompanyName") {
                        System.out.println("companyName=" + e.getTextContent());
                    }else if(e.getTagName()=="ContactName") {
                        System.out.println("ContactName=" + e.getTextContent());
                    }else if(e.getTagName()=="ContactTitle") {
                        System.out.println("ContactTitle=" + e.getTextContent());
                    }else if(e.getTagName()=="Phone") {
                        System.out.println("Phone=" + e.getTextContent());
                    }else if(e.getTagName()=="FullAddress") {
                        System.out.println("FullAddress=" + e.getTextContent());
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    //test
    public static void main(String[] args){
        ReadXML read = new ReadXML();
        String s = "" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Root id= \"1\">\n" +
                "      <CompanyName>Great Lakes Food Market</CompanyName>\n" +
                "      <ContactName>Howard Snyder</ContactName>\n" +
                "      <ContactTitle>Marketing Manager</ContactTitle>\n" +
                "      <Phone>(503) 555-7555</Phone>\n" +
                "      <FullAddress>\n" +
                "        <Address>2732 Baker Blvd.</Address>\n" +
                "        <City>Eugene</City>\n" +
                "        <Region>OR</Region>\n" +
                "        <PostalCode>97403</PostalCode>\n" +
                "        <Country>USA</Country>\n" +
                "      </FullAddress>\n" +
                "</Root>" +
                "";
        InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        read.mapXML(stream);
    }
}
