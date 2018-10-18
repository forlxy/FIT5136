import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    private String id;
    private Customer customer;
    private List<Product> products;
    private Date time;
    private double paidPrice;

    public Order(String id, Customer customer, List<Product> products, Date time, double paidPrice) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.time = time;
        this.paidPrice = paidPrice;
    }

    /**
     * convern the customer information to string.
     * @return
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                ", time=" + time +
                ", paidPrice=" + paidPrice +
                '}';
    }

    /**
     * Check is the same customer.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Double.compare(order.paidPrice, paidPrice) == 0 &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(products, order.products) &&
                Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customer, products, time, paidPrice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerEmail() {
        return customer.getEmail();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(double paidPrice) {
        this.paidPrice = paidPrice;
    }
}
