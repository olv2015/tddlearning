import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by et33579 on 26/05/2016.
 */
public class TestTemplatePerformance {
    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("This is template with many words and many variables for performance testing actually should be one hundret words" +
                "and twenty variables. We use numbers from 1 to 20 as a variables for now. So first is ${one}, second is ${two}, ${three}, " +
                "${four}, ${five}, ${six}, ${seven}, ${eight}, ${nine}, ${ten}, " +
                "${eleven}, ${twelve}, ${thirteen}, ${fourteen}, ${fifteen}, ${sixteen}, ${seventeen}, ${eighteen}, ${nineteen}, ${twenty}" +
                "And we repeat just to achieve the hundret words. This is template with many words and many variables for performance " +
                "testing actually should be one hundret words and twenty variables. We use numbers from 1 to 20 as a variables for now." +
                "This is template with many words and many variables for performance testing actually should be one hundret words and twenty variables" +
                "This is template with many words and many variables for performance testing actually should be one hundret words and twenty variables");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
        template.set("four", "4");
        template.set("five", "5");
        template.set("six", "6");
        template.set("seven", "7");
        template.set("eight", "8");
        template.set("nine", "9");
        template.set("ten", "10");
        template.set("eleven", "11");
        template.set("twelve", "12");
        template.set("thirteen", "13");
        template.set("fourteen", "14");
        template.set("fifteen", "15");
        template.set("sixteen", "16");
        template.set("seventeen", "17");
        template.set("eighteen", "18");
        template.set("nineteen", "19");
        template.set("twenty", "20");

    }

    @Test
    public void templateWith100WordsAnd20Variables() throws Exception{
        long expected = 20L;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        assertTrue("took " + time +"ms while the target was " + expected + "ms", time <= expected);

    }
}
