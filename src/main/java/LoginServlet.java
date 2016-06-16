import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by et33579 on 16/06/2016.
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String user = request.getParameter("j_username");
        String pass = request.getParameter("j_password");
        if (getAuthentificationService().isValidLogin(user, pass)){
            response.sendRedirect("/frontpage");
            request.getSession().setAttribute("username", user);
        }  else {
            response.sendRedirect("/invalidlogin");
        }
    }

    protected AuthentificationService getAuthentificationService(){
        return null;
    }
}
