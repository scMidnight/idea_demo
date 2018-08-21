package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

public class Test {
    public static void main(String[] args) {
        String xmlString = "<root><peop>fugui</peop></root>";
        try {
            Document document = DocumentHelper.parseText(xmlString);
            System.out.println(document.asXML());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
