package App.User;

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

    public void setUsername(String username2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUsername'");
    }

    public void setPassword(String password2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPassword'");
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
