
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    private String email;
    private String password;
    private Customer customer;

    /**
     * Constructor for objects of class User
     */
    public User(String email, String password)
    {
        // initialise instance variables
        this.email = email;
        this.password = password;
    }
    
    public User(String email, String password, Customer customer) {
        this.email = email;
        this.password = password;
        this.customer = customer;
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
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

}
