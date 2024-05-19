package App.User.Admin;

import App.Data;
import App.User.User;
import java.io.IOException;
import App.WarningMessage;

public class Admin extends User {
    User userTemp;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        Admin.id_count++;
        this.id = id_count;
    }

    public void addUser(String username, String password) {
        Data.setUsers(username, password);
    }

    public User retrieveUser(String username) {
        try {
            if (username == null || username.equals("")) {
                    WarningMessage.show("EmptyField", "Please enter a name");
                    return null;    
            } else {
                for (User item : Data.DeletedUsers) {
                    if (item.getUsername().equals(username)) {
                        Data.DeletedUsers.remove(item);
                        Data.Users.add(item);
                        return item;
                    }
                }
                WarningMessage.show("UserNotFound", "User is not deleted or not found");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
        return null;
    }

    public void deleteUser(String username) {
        userTemp = Data.isInList(username, Data.Users);
        if (userTemp != null) {
            Data.DeletedUsers.add(userTemp);
            Data.Users.remove(userTemp);
        } else {
            try {
                WarningMessage.show("UserNotFound", "User is not found");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
