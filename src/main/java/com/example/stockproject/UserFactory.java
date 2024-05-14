package com.example.stockproject;

public class UserFactory {
    public static final int ADMIN = 1;
    public static final int NORMAL = 2;

    public User GetUser(int type ){


        if( type == NORMAL){
            return new Normal_User();
        }

        else if ( type == ADMIN ) {
           return new Admin();
        }

        return null;
    }
}
