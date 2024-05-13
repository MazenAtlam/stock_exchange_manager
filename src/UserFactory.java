package com.example.stockproject;

public class UserFactory {
    public final int ADMIN = 1;
    public final int NORMAL = 2;

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
