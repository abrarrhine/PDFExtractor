public class Main {
    public static void main(String[] args) {

        PDFExtractor doc = new PDFExtractor();
        try{
            doc.importPDF("C:/solr-8.11.2/example/exampledocs/solr-word.pdf");
        } catch (Exception e){
            System.out.println(("Failed" + e.getMessage()));
        }
    }
}