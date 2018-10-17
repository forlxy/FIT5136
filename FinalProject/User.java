public class User {
    private String email;
    private String password;
    
    public User() {

    }
    
    /**
     * Constructor for class User
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    /**
     * This is the method to allow user to change password 
     *
     * @param password  
     * @param newPassword
     * @Return true if the input password match the user password else return false.
     */
    public boolean changePassword(String password) {
        if (!password.equals(getPassword()) && Registered.validatePassword(password)) {
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
