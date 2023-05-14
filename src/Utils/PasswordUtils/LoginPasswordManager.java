package Utils.PasswordUtils;

import User.User;

import java.util.HashMap;
import java.util.TreeMap;

public class LoginPasswordManager
{
    public static HashMap<String, String> users = new HashMap<>();

    public static void setUser(String login, String password)
    {
        users.put(login, password);
    }

    public static boolean compareUser(User user)
    {
        String password = LoginPasswordManager.users.get(user.getLogin());
        if (user.getPassword() == password)
        {
            return true;
        }
        if (user.getNewable())
        {
            setUser(user.getLogin(), user.getPassword());
            return true;
        }
        else
        {
            return false;
        }
    }
}
