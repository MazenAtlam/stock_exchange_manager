package com.example.stockproject;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Data {

    public static UserFactory userFactory = new UserFactory();
    public static ArrayList <User> Users = new ArrayList<>();
    public static ArrayList <User> Admins = new ArrayList<>();
    public static ArrayList <User> DeletedUsers = new ArrayList<>();
    public static ArrayList <User> PremiumUsers =new ArrayList<>();
//    private static Market market; // until market class created
    private static int AdminIndex;
    private static int UserIndex;
    private static int Id ;




    public static boolean UsernameIsAvailable(String username){
        for (User value : Users) {
            if (Objects.equals(username, value.username)) {

                return false;
            }
        }
        Id++;
        return true;
    }

    public static boolean AdminNameIsAvailable(String username){
        for (User admin : Admins){
            if (Objects.equals(admin.username , username)){
                return false;
            }
        }

        return true;
    }

    public static boolean VerifyLogin(String username , String password){
            for (User value : Users) {
                if (Objects.equals(username, value.username) && Objects.equals(password, value.password)) {
                    UserIndex = Users.indexOf(value);
                    return true;
                }
            }
        return false;
    }

    public static boolean VerifyAdminLogin(String username , String password){

        System.out.println(Admins);
        for (User value : Admins) {
            if (Objects.equals(username, value.username) && Objects.equals(password, value.password)) {
                AdminIndex = Admins.indexOf(value);
                return true;
            }
        }
        return false;
    }

    public static int getUserIndex() {
        return UserIndex;
    }

    public static int getAdminIndex() {
        return AdminIndex;
    }



    public static boolean IsAdmin(User user){
        for (User value : Admins) {
            if (Objects.equals(user,value)) {
                return true;
            }
        }
        return false;
    }

    public static void setUsers(String username , String password){
        User user = userFactory.GetUser(userFactory.NORMAL);
        Users.add(user);

        user.setUsername(username);
        user.setPassword(password);
        user.setId(Id);
        System.out.println(Users);
    }

}
