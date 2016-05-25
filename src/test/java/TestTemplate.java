import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by crystalsphere on 5/22/16.
 */
public class TestTemplate {
    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");

    }

    @Test
    public void multipleVariables() throws Exception {
        assertExpectedEquals("1, 2, 3");
    }

    @Test
    public void unknownVariableIgnored() throws Exception{
        template.set("doesnotexists", "Hi");
        assertExpectedEquals("1, 2, 3");

    }

    @Test
    public void missingValueRaisedException() throws Exception{
        try {
            new Template("${foo}").evaluate();
            fail("evaluate() should throw exception if variable without value");
        }   catch (MissingValueException expected){

        }

    }

    private void assertExpectedEquals(String expected){
        assertEquals(expected, template.evaluate());
    }

}
