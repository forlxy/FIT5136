import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Shelf {

    private static List<Product> shelfProducts;

    public Shelf() {
    }

    static {
        shelfProducts = new ArrayList<Product>();
    }

    public static List<Product> getShelfProducts() {
        return shelfProducts;
    }

    public static List<Product> searchProduct(String productName) {

        List<Product> searchedProducts = new ArrayList<Product>();

        for (Product product : shelfProducts) {
            if (product.getName().equals(productName)) {
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }

    public static boolean updateProduct(int index, Product newProduct) {
        return shelfProducts.set(index, newProduct) != null;
    }

    public static Product getProductById(int Id) {
        for (Product product : shelfProducts) {
            if (product.getId() == Id) {
                return product;
            }
        }
        return null;
    }


    public static boolean insertProduct(Product product) {
        return shelfProducts.add(product);
    }

    public static boolean removeProduct(int index) {
        return shelfProducts.remove(index) != null;
    }




    public static void readFile() throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File("Shelf.csv"));
        String line;
        int size;
        while (scanner.hasNext()) {

            line = scanner.next();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int type = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);
            int shelfLife = Integer.parseInt(parts[4]);
            Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(parts[5]);
            double discountRate = Double.parseDouble(parts[6]);
            ;
            int sellType = Integer.parseInt(parts[7]);
            int productNumber = Integer.parseInt(parts[8]);

            Product product = new Product(id, name, type, price, shelfLife,
                    startDate, discountRate, sellType, productNumber);
            shelfProducts.add(product);

        }
        scanner.close();
    }

    public static void writeFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("Shelf.csv"));
        StringBuilder sb = new StringBuilder();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Product product : shelfProducts) {
            sb.append(Integer.toString(product.getId()));
            sb.append(',');
            sb.append(product.getName());
            sb.append(',');
            sb.append(Integer.toString(product.getType()));
            sb.append(',');
            sb.append(Double.toString(product.getPrice()));
            sb.append(',');
            sb.append(Integer.toString(product.getShelfLife()));
            sb.append(',');
            sb.append(dateFormat.format(product.getStartDate()));
            sb.append(',');
            sb.append(Double.toString(product.getDiscountRate()));
            sb.append(',');
            sb.append(Integer.toString(product.getSellType()));
            sb.append(',');
            sb.append(Integer.toString(product.getProductNumber()));
            sb.append('\n');
        }

        pw.write(sb.toString());
        pw.close();
        System.out.println("Write to ShelfDB done!");
    }


}
