/**
 * A class that allows an admin to add a new admin
 *
 * @author Mazen Atef
 * @version 1.0
 * @scince 2024-05-12
 */

 public class AdminGenerator {
    /**
     * This method is used to add a new admin to our data
     * @param admin
     */
    public void add_admin(User admin) {
        if (admin == null)
            System.out.println("null passed in add_admin");
        else
            Data.admins.add(admin);
    }

    /**
     * This method is used to remove an admin from our data
     * @param admin
     */
    public void remove_admin(User admin) {
        if (admin == null)
            System.out.println("null passed in remove_admin");
        else
            Data.admins.remove(admin);
    }
}
