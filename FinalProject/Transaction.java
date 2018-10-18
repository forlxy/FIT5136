import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class Transaction {
    private static List<Order> orderList;

    //For owner
    public static Order viewOrder(int index){
        return orderList.get(index);
    }

    //For customer
    public static Order viewOrder(Customer customer, int index){
        return viewOrders(customer).get(index);
    }

    /**
     * Show all the order.
     * @param customer
     * @return
     */
    public static List<Order> viewOrders(Customer customer){
        List<Order> customerOrder = new ArrayList<>();
        for (Order o : orderList) {
            if (o.getCustomer().getEmail() == customer.getEmail())
                customerOrder.add(o);
        }
        return customerOrder;
    }

    public static List<Order> viewOrders() {
        return orderList;
    }

    public Transaction(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Transaction() {
        initialize();
    }

    static {
        initialize();
    }

    /**
     * initialize the orderList.
     */
    public static void initialize() {
        if (orderList == null)
            orderList = new ArrayList<>();
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static boolean addOrder(Order order) {
        return orderList.add(order);
    }

    /**
     * Readfile file from database.
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void readFile() throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File("transactions.csv"));
//        scanner.useDelimiter(",");
        String line;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss");

        int tSize;
        int[] orderSize;
        if (scanner.hasNext()) {
            line = scanner.next();
            String[] arguments = line.split(",");
            tSize = Integer.parseInt(arguments[0]);
            orderSize = new int[arguments.length - 1];
            Map<Integer, Order> map = new HashMap();
            for (int i = 0; i < tSize; i++) {
                line = scanner.next();
                String[] parts = line.split(",");
                orderSize[i] = Integer.parseInt(arguments[i + 1]);
                String id = parts[0];
                Customer customer = Registered.getByEmail(parts[1]);
//                Customer customer = new Customer("address", 10, "phone", "kasaluoqi@gmail.com","password");
                int listIndex = Integer.parseInt(parts[2]);
                Date time = formatter.parse(parts[3]);
                double paidPrice = Double.parseDouble(parts[4]);
                Order tmp = new Order(id, customer, null, time, paidPrice);
                map.put(listIndex, tmp);
            }

            for (int i = 0; i < tSize; i++){
                List<Product> tmpList = new ArrayList<>();
                for (int j = 0; j < orderSize[i]; j++) {
                    line = scanner.next();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int type = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    int shelfLife = Integer.parseInt(parts[4]);
                    Date startDate = formatter.parse(parts[5]);
                    double discountRate = Double.parseDouble(parts[6]);
                    int sellType = Integer.parseInt(parts[7]);
                    int productNum = Integer.parseInt(parts[8]);
                    Product tmpProduct = new Product(id, name, type, price, shelfLife, startDate, discountRate, sellType, productNum);
                    tmpList.add(tmpProduct);
                }
                Order tmp = map.get(i);
                tmp.setProducts(tmpList);
                orderList.add(tmp);
            }
        }
        scanner.close();
    }

    /**
     * writeFile from the database.
     * @throws FileNotFoundException
     */
    public static void writeFile() throws FileNotFoundException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss");

        PrintWriter pw = new PrintWriter(new File("transactions.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append(orderList.size());
        for (Order o : orderList){
            sb.append(',');
            sb.append(o.getProducts().size());
        }
        sb.append('\n');

        for ( int i = 0; i < orderList.size(); i++){
            Order o = orderList.get(i);
            sb.append(o.getId());
            sb.append(',');
            sb.append(o.getCustomer().getEmail());
            sb.append(',');
            sb.append(i);
            sb.append(',');
            sb.append(formatter.format(o.getTime()));
            sb.append(',');
            sb.append(o.getPaidPrice());
            sb.append('\n');
        }

        for (Order o : orderList) {
            for (Product p : o.getProducts()) {
                sb.append(p.getId());
                sb.append(',');
                sb.append(p.getName());
                sb.append(',');
                sb.append(p.getType());
                sb.append(',');
                sb.append(p.getPrice());
                sb.append(',');
                sb.append(p.getShelfLife());
                sb.append(',');
                sb.append(formatter.format(p.getStartDate()));
                sb.append(',');
                sb.append(p.getDiscountRate());
                sb.append(',');
                sb.append(p.getSellType());
                sb.append(',');
                sb.append(p.getProductNumber());
                sb.append('\n');
            }
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }

}
