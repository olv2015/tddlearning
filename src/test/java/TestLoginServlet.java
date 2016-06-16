import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import javax.servlet.http.HttpServlet;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by et33579 on 16/06/2016.
 */
public class TestLoginServlet {

    @Test
    public void wrongPasswordShouldReditectToErrorPage() throws Exception {
        HttpServlet servlet = new LoginServlet();
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/login");
        request.addParameter("j_username", "nosuchuser");
        request.addParameter("j_password", "wrongpassword");
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        assertEquals("/invalidlogin", response.getRedirectedUrl());
    }

    @Test
    public void validLoginForwardsToFrontPageAndStoresUserName() throws Exception{
        final String validUserName = "validuser";
        final String validPassword = "validpassword";
        final FakeAuthentificationService authentificator = new FakeAuthentificationService();
        authentificator.addUser(validUserName, validPassword);

        HttpServlet servlet = new LoginServlet(){
            @Override
            protected AuthentificationService getAuthentificationService() {
                return authentificator;
            }

        };
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/login");
        request.addParameter("j_username", validUserName);
        request.addParameter("j_password", validPassword);
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        assertEquals("/frontpage", response.getRedirectedUrl());
        assertEquals("validuser", request.getSession().getAttribute("username"));

    }
}
