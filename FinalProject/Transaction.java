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
        return viewOrder(customer).get(index);
    }

    //Show All
    public static List<Order> viewOrder(Customer customer){
        List<Order> customerOrder = new ArrayList<>();
        for (Order o : orderList) {
            if (o.getCustomer().getEmail() == customer.getEmail())
                customerOrder.add(o);
        }
        return customerOrder;
    }

    public Transaction(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Transaction() {
        this.orderList = new ArrayList<>();
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static boolean addOrder(Order order) {
        return orderList.add(order);
    }

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
                Customer customer = Customer.getByEmail(parts[1]);
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
                    String name = parts[0];
                    int type = Integer.parseInt(parts[1]);
                    double price = Double.parseDouble(parts[2]);
                    int shelfLife = Integer.parseInt(parts[3]);
                    Date startDate = formatter.parse(parts[4]);
                    double discountRate = Double.parseDouble(parts[5]);
                    int sellType = Integer.parseInt(parts[6]);
                    int productNum = Integer.parseInt(parts[7]);
                    Product tmpProduct = new Product(name, type, price, shelfLife, startDate, discountRate, sellType, productNum);
                    tmpList.add(tmpProduct);
                }
                Order tmp = map.get(i).setProducts(tmpList);
                orderList.add(tmp);
            }
        }
        scanner.close();
    }

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
                sb.append(p.getName());
                sb.append(',');
                sb.append(p.getPrice());
                sb.append(',');
                sb.append(p.getShelfList());
                sb.append(',');
                sb.append(formatter.format(p.getStartDate()));
                sb.append(',');
                sb.append(p.getDiscountRate());
                sb.append(',');
                sb.append(p.getSellType());
                sb.append(',');
                sb.append(p.getProductNum());
                sb.append('\n');
            }
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
}
