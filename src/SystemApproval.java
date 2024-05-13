/**
 * A class that allows an admin to approve or reject the users' requests
 *
 * @author Mazen Atef
 * @version 1.0
 * @scince 2024-05-12
 */
import java.util.ArrayList;

public class SystemApproval {
    public static ArrayList<Order> requests = new ArrayList<>();
    
    /**
     * This method is used to change the status of each request
     * @param admin
     */
    public void make_decision(User admin) {
        for (Order request: requests) {
            // request.set_status("""action_button approve or reject""");
            requests.remove(request);
        }
    }
}
