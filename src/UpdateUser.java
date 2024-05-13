/**
 * A class that allows an admin to change a user premium status
 *
 * @author Mazen Atef
 * @version 1.0
 * @scince 2024-05-12
 */

public class UpdateUser {
    /**
     * This method is used to update a user to premium tier
     * @param user
     */
    public void add_premium_user(User user) {
        if (user == null)
            System.out.println("null passed in add_premium_user");
        else if (user.premium) {
            // show message "This user is already subscribed to premium"
        } else {
            user.premium = true;
            Data.premium_users.add(user);
        }
    }

    /**
     * This method is used to REMOVE a user from premium tier
     * @param user
     */
    public void remove_premium_user(User user) {
        if (user == null)
            System.out.println("null passed in remove_premium_user");
        else if (!user.premium) {
            // show message "This user is already not subscribed to premium"
        } else {
            user.premium = false;
            Data.premium_users.remove(user);
        }
    }
}
