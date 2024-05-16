package com.example.stockproject;
import java.util.Objects;


public abstract class User {

    public static int Id = 0;
    protected String username;
    protected String password;
    protected int  id ;



    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setId() {
        this.id = Id;
    }
    public int getId() {return id;}
    public String getPassword(){return password;}



    public String GetUsername() {
        return username;
    }


    public static boolean  ChangeUsername(String New_name, String type){
        if(type.equalsIgnoreCase("normal")) {
              if (New_name != null) {
                  for(User user : Data.Users){
                      if (Objects.equals(user.username, New_name)) {
                          return false;
                      }
                  }
                  Data.Users.get(Data.getUserIndex()).setUsername(New_name);
                  return true;
              }

        }
        else if (type.equalsIgnoreCase("Admin")) {
                if (New_name != null) {
                    for(User admin : Data.Admins){
                        if (Objects.equals(admin.username, New_name)) {
                            return false;
                        }
                    }
                    Data.Admins.get(Data.getAdminIndex()).setUsername(New_name);
                    return true;
                }

        }
        return false;
    }

    public static boolean ChangePassword(String current_password, String New_password , String type){
        if(type.equalsIgnoreCase("normal")) {
            if (Objects.equals(Data.Users.get(Data.getUserIndex()).password, current_password)) {
                if (New_password != null) {
                    Data.Users.get(Data.getUserIndex()).setPassword(New_password);
                    return true;
                }
            }
        }
        else if (type.equalsIgnoreCase("Admin")) {
            if (Objects.equals(Data.Admins.get(Data.getAdminIndex()).password, current_password)) {
                if (New_password != null) {
                    Data.Admins.get(Data.getAdminIndex()).setPassword(New_password);
                    return true;
                }
            }
        }
        return false;
    }


}


