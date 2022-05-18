package htmlText;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class POSExample2 {

/*    public String htmlCode(String url) throws IOException {
        Document htmlCode = Jsoup.connect(url).get();
        return Jsoup.parse(htmlCode.toString(), "ISO-8859-1").select("body").text();
    }*/

    public static void main(String[] args) {
        final String url = "https://www.skymeesound.com/Privacy/pracy-en.html";


        try {
            Document htmlCode = Jsoup.connect(url).get();
            String text = Jsoup.parse(htmlCode.toString(), "ISO-8859-1").select("body").text();

//            document.add(htmlCode);
//            FileWriter fileWriter = new FileWriter("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/privacyData/text.txt", true);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println(text);
//            printWriter.close();
//            fileWriter.close();
//            System.out.println("successfully saved the data into file");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
//        String text = "Hey! I am Dinesh Krishnan.";

        CoreDocument coreDocument1 = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument1);

        List<CoreLabel> coreLabelList1 = coreDocument1.tokens();

        for(CoreLabel coreLabel1 : coreLabelList1) {

            String pos = coreLabel1.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(coreLabel1.originalText() + " = "+ pos);

//            FileWriter fileWriter = new FileWriter("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/html.csv", true);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println(coreLabel.originalText() + " = "+ pos);
//            printWriter.close();
//            fileWriter.close();
//            System.out.println("successfully saved the data into file");


            TFIDFCalculator calculator = new TFIDFCalculator();
//            double tfidf = calculator.tfIdf(coreLabelList1, documents, coreLabel1.originalText());

        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
