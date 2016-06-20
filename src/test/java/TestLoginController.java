import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by et33579 on 20/06/2016.
 */
public class TestLoginController {
    private static final String VALID_USERNAME = "validuser";
    private static final String CORRECT_PASSWORD = "validpassword";

    @Before
    public void setUp(){

    }

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", "wrongpassword");
        MockHttpServletResponse response = new MockHttpServletResponse();

        FakeAuthentificationService mock = new FakeAuthentificationService();
        mock.addUser(VALID_USERNAME, CORRECT_PASSWORD);

        LoginController c = new LoginController();
        c.setAuthentification(mock);
        ModelAndView v = c.handleRequest(request, response);

        assertEquals("wrongpassword", v.getViewName());



    }

    @Test
    public void valisLoginForwardsToFrontPage() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", CORRECT_PASSWORD);
        MockHttpServletResponse response = new MockHttpServletResponse();

        FakeAuthentificationService mock = new FakeAuthentificationService();
        mock.addUser(VALID_USERNAME, CORRECT_PASSWORD);

        LoginController c = new LoginController();
        c.setAuthentification(mock);
        ModelAndView v = c.handleRequest(request, response);

        assertEquals("frontpage", v.getViewName());

    }

}
