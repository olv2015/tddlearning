import java.util.HashMap;
import java.util.Map;

/**
 * Created by et33579 on 16/06/2016.
 */
public class FakeAuthentificationService implements AuthentificationService{

    private Map<String, String> users = new HashMap<String, String>();

    public void addUser(String user, String pass){
        users.put(user, pass);
    }

    public boolean isValidLogin(String username, String password) {
        return users.containsKey(username) && password.equals(users.get(username));
    }
}
