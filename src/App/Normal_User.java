package App;

public class Normal_User extends User {
    private boolean premium;

    public Normal_User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = ++id_count;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
