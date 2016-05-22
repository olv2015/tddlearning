import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by crystalsphere on 5/22/16.
 */
public class TestTemplate {
    @Test
    public void oneVariable() throws Exception{
        Template template =
                new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());

    }

    @Test
    public void differentVariable() throws Exception{
        Template template =
                new Template("Hello, ${name}");
        template.set("name", "Someone");
        assertEquals("Hello, Someone", template.evaluate());

    }

    @Test
    public void differentTemplate() throws Exception{
        Template template =
                new Template("Hi, ${name}");
        template.set("name", "Someone");
        assertEquals("Hi, Someone", template.evaluate());

    }

    @Test
    public void multipleVariables() throws Exception {
        Template template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
        assertEquals("1, 2, 3", template.evaluate());
    }

}
