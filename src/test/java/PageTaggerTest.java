import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class PageTaggerTest {

    private PageTagger subject;

    @Before
    public void setup() {
        subject = new PageTagger();
    }

    @Test
    public void itGivesTaggedOutputWhenGivenEnglish() {
        // GIVEN
        String text = "This is just a very small test.";
        String expectedTaggedText = "This_DT is_VBZ just_RB a_DT very_RB small_JJ test_NN ._. ";

        // WHEN
        String taggedText = subject.tagText(text);

        // THEN
        assertEquals(expectedTaggedText, taggedText);
    }

    @Test
    public void itDoesntFailWithNumericAndTabs() {
        // GIVEN
        String text = "12847563\t1984720\t19384728";

        // WHEN
        String taggedText = subject.tagText(text);

        // THEN
        assertNotNull(taggedText);
        assertFalse(taggedText.isEmpty());
    }

    @Test
    public void getTextReturnsTextOfHtmlBody() throws Exception {
        // GIVEN
        URL url = new File("src/test/resources/test.html").toURI().toURL();
        String expectedText = "hello world";

        // WHEN
        String actualText = subject.getText(url);

        // THEN
        assertEquals(expectedText, actualText);
    }
}
