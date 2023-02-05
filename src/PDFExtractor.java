//File Handling
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//Data type for returning metadata
import java.util.HashMap;
import java.util.Map;

//Tika Components
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class PDFExtractor {
    BodyContentHandler handler = new BodyContentHandler(-1);
    Metadata metadata = new Metadata();
    ParseContext parseContext = new ParseContext();
    FileInputStream inputStream;
    PDFParser pdfParser = new PDFParser();

    //Void constructor to initialize requisite components
    public void PDFExtractor(){

    }

    public void importPDF(String filepath) throws FileNotFoundException{
        inputStream = new FileInputStream(new File(filepath));
        try{
            pdfParser.parse(inputStream, handler, metadata, parseContext);
            System.out.println(handler.toString());
        } catch (IOException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        }catch (TikaException e){
            e.printStackTrace();
        }
    }

    public String getDocumentText(){
        return handler.toString();
    }

    public Map<String, String> getMetaData(){
        String[] metadatanames = metadata.names();
        Map<String, String> metamap = new HashMap<>();
        for(String name: metadatanames){
            metamap.put(name, metadata.get(name));
        }
        return metamap;
    }
}
