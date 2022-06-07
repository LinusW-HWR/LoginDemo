import java.util.HashMap;

public class UserList {

    private HashMap<String,String> users = new HashMap<>();

    public UserList(){
        users.put("linus","linus123");
        users.put("justin","justin123");
    }

    public boolean hasUser(String user){
        if(users.containsKey(user)){
            return true;
        }
        return false;
    }

    public boolean checkUserPasswd(String user,String passwd){
        if(users.get(user).equals(passwd)){
            return true;
        }
        return false;
    }
}
