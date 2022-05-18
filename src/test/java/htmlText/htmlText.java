package htmlText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class htmlText {

    static List<List<String>> documents;
    static List<String> doc1 ;
    static List<String> doc2;
    static List<String> doc3;
    public static String[] htmlCode(String url) throws IOException {
        Document htmlCode = Jsoup.connect(url).get();
       String s =  Jsoup.parse(htmlCode.toString(), "ISO-8859-1").select("body").text();
//        String[] words = s.split("\\s+");
        return s.split("\\s+");
    }
    public static void main(String[] args) throws IOException {
        String url1 = "https://www.skymeesound.com/Privacy/pracy-en.html";
        String url2 = "https://www.autopo.st/privacy-policy-2/";
        String url3 = "https://www.qantas.com/sg/en/support/privacy-and-security.html?ADSRMode=EnglishOnly";
//        final String url = "https://www.skymeesound.com/Privacy/pracy-en.html";
        doc1 = List.of(htmlCode(url1));
        doc2 = List.of(htmlCode(url2));
        doc3 = List.of(htmlCode(url3));
        documents = Arrays.asList(doc1, doc2, doc3);

//        documents.add(doc1);
//        documents.add(doc2);
//        documents.add(doc3);
//        String a = doc1.toString() + doc2.toString() + doc3.toString();
//        System.out.println(a);

        try {
            String body1 = Jsoup.parse(Jsoup.connect(url1).get().toString(), "ISO-8859-1").select("body").text();
            String body2 = Jsoup.parse(Jsoup.connect(url2).get().toString(), "ISO-8859-1").select("body").text();
            String body3 = Jsoup.parse(Jsoup.connect(url3).get().toString(), "ISO-8859-1").select("body").text();
            System.out.println(body1+body2+body3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
