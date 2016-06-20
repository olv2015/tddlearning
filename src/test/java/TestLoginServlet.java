import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import javax.servlet.http.HttpServlet;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by et33579 on 16/06/2016.
 */
public class TestLoginServlet {

    private static final String VALID_USERNAME = "validuser";
    private static final String CORRECT_PASSWORD = "validpassword";

    private LoginServlet servlet;
    private FakeAuthentificationService authentificator;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;



    @Before
    public void setUp(){
        authentificator = new FakeAuthentificationService();
        authentificator.addUser(VALID_USERNAME, CORRECT_PASSWORD);
        servlet = new LoginServlet(){
            @Override
            protected AuthentificationService getAuthentificationService() {
                return authentificator;
            }

        };
        request = new MockHttpServletRequest();
        request.setMethod("GET");
        response = new MockHttpServletResponse();
    }

    @Test
    public void wrongPasswordShouldReditectToErrorPage() throws Exception {

        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", "wrongpassword");
        servlet.service(request, response);
        assertEquals("/invalidlogin", response.getRedirectedUrl());
    }

    @Test
    public void validLoginForwardsToFrontPageAndStoresUserName() throws Exception{

        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", CORRECT_PASSWORD);
        servlet.service(request, response);
        assertEquals("/frontpage", response.getRedirectedUrl());
        assertEquals("validuser", request.getSession().getAttribute("username"));

    }
}
