package htmlText;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.pipeline.StanfordCoreNLP.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class POSExample {

/*    public String htmlCode(String url) throws IOException {
        Document htmlCode = Jsoup.connect(url).get();
        return Jsoup.parse(htmlCode.toString(), "ISO-8859-1").select("body").text();
    }*/

    public static void main(String[] args) {
        final String url = "https://www.skymeesound.com/Privacy/pracy-en.html";


        try {
//            Document htmlCode = Jsoup.connect(url).get();
//            String text = Jsoup.parse(htmlCode.toString(), "ISO-8859-1").select("body").text();

//            document.add(htmlCode);
//            FileWriter fileWriter = new FileWriter("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/privacyData/text.txt", true);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println(text);
//            printWriter.close();
//            fileWriter.close();
//            System.out.println("successfully saved the data into file");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

//        Path path = Path.of("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/text.txt");
//            String content = Files.readString(path, StandardCharsets.US_ASCII);
//            System.out.println(content);
        String text = "Feeder Privacy Policy In  privacy policy we explain how we collect  use information  you  your users In order to protect the rights  interests of you  your users please read the privacy policy in detail  register under the premise of clear understanding the privacy policy  the terms of service are inseparable as whole If you click the I agree button during the registration process you fully accept the terms of service  the privacy policy All the contents of the policy  on the basis of knowledge clearly agree to handle use  disclose information about your  your users in accordance with the provisions of the privacy policy  the terms of service If you do not accept  Privacy Policy  the terms of service please do not install use register or access our services in any other way How to collect information Information in the process of registration  use as stated in the terms of service you need to agree to the privacy policy  the terms of service to use our service when applying for the registration of APP When you register you need to provide us with accurate personal data such as mailbox ID card contact mode account information etc In order to provide you with better services we automatically store your information  integrate the information in the case of voluntary selection of services or information Please provide timely detailed  accurate information  update the registration materials All original keyed information be cited as registered information If the problems caused by the registration information are not true you bear the consequences accordingly Please do not transfer or lend your account number or password to others If you find that your account is illegally used by others you should inform us immediately The Internet does not exclude that the account or password is illegally used by others because of hacking or your careless oversight  situation is not related to us Through our statistical analysis our relevant services help you underst how your users use your application  help you ";


        CoreDocument coreDocument1 = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument1);

        List<CoreLabel> coreLabelList1 = coreDocument1.tokens();

        for(CoreLabel coreLabel1 : coreLabelList1) {

            String pos = coreLabel1.get(CoreAnnotations.PartOfSpeechAnnotation.class);

//            System.out.println(coreLabel1.originalText() + " = "+ pos);


            FileWriter fileWriter = new FileWriter("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/test.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            if ((pos.equals("VB")) /*|| (pos.equals("NN")) || (pos.equals("NNS"))*/|| (pos.equals("VBS"))){
                printWriter.println(coreLabel1.originalText()+" ");
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("successfully saved the data into file");


            TFIDFCalculator calculator = new TFIDFCalculator();
//            double tfidf = calculator.tfIdf(coreLabelList1, documents, coreLabel1.originalText());

        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
