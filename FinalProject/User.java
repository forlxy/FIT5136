public class User {
    private String email;
    private String password;
    
    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean changePassword(String password) {
        if (password != getPassword() && Registered.validatePassword(password)) {
            setPassword(password);
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
