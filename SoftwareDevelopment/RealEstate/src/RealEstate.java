import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class RealEstate { 
 
    public static void main (final String[] args) throws IOException {
    ArrayList<String> allCases = new ArrayList<String>(); 
    Document doc = Jsoup.connect
            ("http://vweb2.brevardclerk.us/Foreclosures/foreclosure_sales.html").get();

    Elements caseNumbers = doc.select("tr td:contains(XXXX-XX)");
    for (Element caseNumber : caseNumbers) {
        allCases.add(caseNumber.text());
        //System.out.printf("%s%s%n%n", "CASE NUMBER: ", caseNumber.text());
    }
    int i = 0;
    for (String caseNumber : allCases) {
        System.out.println(allCases.get(i));
        i++;
    }
    
   }
}