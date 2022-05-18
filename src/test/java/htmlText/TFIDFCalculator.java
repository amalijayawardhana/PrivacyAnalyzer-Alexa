package htmlText;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static htmlText.htmlText.*;

public class TFIDFCalculator {
//    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }


    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }

    public static void main(String[] args) throws IOException {

        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul","ip");
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);

//        String url1 = "https://www.skymeesound.com/Privacy/pracy-en.html";
//        String url2 = "https://www.autopo.st/privacy-policy-2/";
//        String url3 = "https://www.qantas.com/sg/en/support/privacy-and-security.html?ADSRMode=EnglishOnly";
////        final String url = "https://www.skymeesound.com/Privacy/pracy-en.html";
//        doc1 = List.of(htmlCode(url1));
//        doc2 = List.of(htmlCode(url2));
//        doc3 = List.of(htmlCode(url3));
//        documents = Arrays.asList(doc1, doc2, doc3);

//        List<String> uniqueNameLst = new ArrayList<>();
        TFIDFCalculator calculator = new TFIDFCalculator();
//        for (String word:doc1) {
//            if(!uniqueNameLst.contains(word)){
//                uniqueNameLst.add(word);
//            }
//        }
//        System.out.println(uniqueNameLst);
//        for (String word:uniqueNameLst) {

            double tfidf = calculator.tfIdf(doc1, documents, "ipsum");
//            System.out.println("TF-IDF (are) = " + df.format(tfidf));
            System.out.println("TF-IDF = " + tfidf);
//        }
//        System.out.println(doc1);
//        System.out.println(doc2);
//        System.out.println(doc3);

    }
}
