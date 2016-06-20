import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by et33579 on 20/06/2016.
 */
public class LoginController implements Controller {

    private AuthentificationService authentification;

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String user = httpServletRequest.getParameter("j_username");
        String pass = httpServletRequest.getParameter("j_password");
        if (authentification.isValidLogin(user, pass)) {
            return new ModelAndView("frontpage");
        }
        return new ModelAndView("wrongpassword");
    }

    public void setAuthentification(FakeAuthentificationService authentification) {
        this.authentification = authentification;
    }
}
