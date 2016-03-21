import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageTagger {

    private final MaxentTagger tagger;

    public PageTagger() {
        this.tagger = new MaxentTagger("english-left3words-distsim.tagger");
    }

    public String tagText(String text) {
        return tagger.tagString(text);
    }

    public String getText(URL inputUrl) {
        String html = getHtml(inputUrl);
        if (html == null) {
            return null;
        }
        return Jsoup.parse(html).body().text();
    }

    private String getHtml(URL inputUrl) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputUrl.openStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
            }
            in.close();
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println("IOException reading from URL: [" + ex.getMessage() + "]");
            return null;
        }
    }

}
