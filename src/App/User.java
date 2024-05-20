package App;

public abstract class User {
    protected String username;
    protected String password;
    protected static int id_count;
    protected int id;

    public String getUsername() {
        return username;
    }

    public Object getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
