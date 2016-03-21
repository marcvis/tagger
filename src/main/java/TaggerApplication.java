import java.net.MalformedURLException;
import java.net.URL;

public class TaggerApplication {

    public static void main(String[] args) {
        if (args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("Must provide a URL/URI for tagging!");
            System.exit(1);
        }

        try {
            URL url = new URL(args[0]);
            PageTagger pageTagger = new PageTagger();
            String urlText = pageTagger.getText(url);
            if (urlText == null) {
                System.out.println("Failed to retrieve html from URL: [" + url.getHost() + "]");
                System.exit(1);
            }

            String taggedText = pageTagger.tagText(urlText);
            System.out.print(taggedText);
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL.  Exception message: [" + ex.getMessage() +"]");
            System.exit(1);
        }
    }
}
