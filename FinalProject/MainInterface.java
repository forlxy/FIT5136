
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.security.acl.Owner;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Write a description of class MainInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainInterface {
    private static String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
            , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};
    private final JButton closeButton;

    private ListSelectionListener listSelectionListener;
    private JFrame mfvs;
    private JPanel buttonPanel;
    private JPanel bottomPanel;
    private JTable productTable;
    private DefaultTableModel defaultTableModel;

    private JButton productButton;
    private JButton searchButton;
    private JButton orderButton;
    private JButton personButton;
    private JButton cartButton;
    private static Customer currentCustomer;

    private Dialog loginDialog;
    private Dialog registerDialog;
    private Dialog searchProductDialog;
    private Dialog addProductDialog;
    private Dialog editProductDialog;
    private Dialog checkStorageDialog;
    private Dialog cartDialog;

    public static List<Product> shelf;
    public static List<Product> shelfAfterSearch;


    public static Customer getCurrentUser() {
        return currentCustomer;
    }


    public void updateShelf() {

        DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        shelf = ShelfController.getShelfProducts();

        for (Product p : shelf) {
            Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

            tableModel.addRow(data);
        }
        tableModel.fireTableDataChanged();
        productTable.setModel(tableModel);

    }

    public MainInterface(Customer user, int state) {
        currentCustomer = user;


        mfvs = new JFrame("MFVS");

        try {
            ShelfController.readFile();
            TransactionController.readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonPanel = new JPanel();
        bottomPanel = new JPanel();

        DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        shelf = ShelfController.getShelfProducts();

        for (Product p : shelf) {
            Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

            tableModel.addRow(data);
        }

        productTable = new JTable(tableModel);

        productTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < shelf.size()) {
                    JFrame jf = new GUI_addToCart(shelf.get(row));
                    jf.setVisible(true);
                }
            }
        });


        searchButton = new JButton("SearchProduct");
        productButton = new JButton("ManageProduct");
        cartButton = new JButton("Cart");
        orderButton = new JButton("Order");
        closeButton = new JButton("Close");
        personButton = new JButton("Me");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ShelfController.writeFile();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                mfvs.dispose();
            }
        });
//        loginDialog = new CartUI(mfvs);
//        registerDialog = new Dialog(mfvs, true);
//        searchProductDialog = new Dialog(mfvs, true);
//        addProductDialog = new Dialog(mfvs, true);
//        editProductDialog = new Dialog(mfvs, true);
//        checkStorageDialog = new Dialog(mfvs, true);
        init(state);
    }

    public void init(int state) {
        mfvs.setBounds(400, 250, 800, 400);
//        loginDialog.setBounds(300, 300, 200, 170);
//        registerDialog.setBounds(300, 300, 200, 170);
//        searchProductDialog.setBounds(300, 300, 200, 170);
//        addProductDialog.setBounds(300, 300, 200, 170);
//        editProductDialog.setBounds(300, 300, 200, 170);
//        checkStorageDialog.setBounds(300, 300, 200, 170);
//        cartDialog.setBounds(300, 300, 200, 170);

        buttonPanel.add(searchButton);
        if (state == 0) {
            buttonPanel.add(productButton);
        }
        buttonPanel.add(cartButton);
        buttonPanel.add(orderButton);
        buttonPanel.add(personButton);

        bottomPanel.add(closeButton);

//        loginButton.addActionListener(e -> loginDialog.setVisible(true));
//        registerButton.addActionListener(e -> registerDialog.setVisible(true));
//        searchButton.addActionListener(e -> searchProductDialog.setVisible(true));
//        addButton.addActionListener(e -> addProductDialog.setVisible(true));
//        editButton.addActionListener(e -> editProductDialog.setVisible(true));
//        checkButton.addActionListener(e -> checkStorageDialog.setVisible(true));
        productButton.addActionListener(e -> new ManageProductUI().setVisible(true));
        searchButton.addActionListener(e -> new SearchUI().setVisible(true));

        cartButton.addActionListener(e -> new CartUI().setVisible(true));
        orderButton.addActionListener(e -> new OrderUI().setVisible(true));
        personButton.addActionListener(e -> new GUI_userInfo().setVisible(true));


        mfvs.setLayout(new BorderLayout());
        mfvs.add(buttonPanel, BorderLayout.NORTH);
        mfvs.add(new JScrollPane(productTable), BorderLayout.CENTER);
        mfvs.add(bottomPanel, BorderLayout.SOUTH);

        //mfvs.pack();
        mfvs.setVisible(true);
    }

    public class CartUI extends JFrame {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable productTable;

        private JButton clearButton;
        private JButton closeButton;
        private JButton purchaseButton;

        private Dialog loginDialog;
        private Dialog registerDialog;
        private Dialog searchProductDialog;
        private Dialog addProductDialog;
        private Dialog editProductDialog;
        private Dialog checkStorageDialog;
        private Dialog cartDialog;

        public CartUI() {

            buttonPanel = new JPanel();
            bottomPanel = new JPanel();
            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            List<Product> cart = CartController.getProductList();

            for (Product p : cart) {
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

                tableModel.addRow(data);
            }

            productTable = new JTable(tableModel);

            productTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table = (JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < cart.size()) {
                        new GUI_editCart(productTable, row, cart.get(row)).setVisible(true);
                    }
                }
            });

            clearButton = new JButton("Clear");
            closeButton = new JButton("Close");
            purchaseButton = new JButton("Purchase");

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                }
            });

            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    for (Product product : Cart.getProductList()) {
//                        Product pInCart = Shelf.replaceProdcut(product.getId());
//                        if (pInCart != null) {
//                            pInCart.setProductNumber(product.getProductNumber() + pInCart.getProductNumber());
//                        }
//                    }
                    clearCartUI();
                    updateShelf();
                }
            });


            purchaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Double totalPrice = Cart.getTotalPrice();

                    if (CartController.purchase()) {

                        System.out.println("TotalPrice: " + totalPrice);
                        getCurrentUser().setBalance(getCurrentUser().getBalance() - totalPrice);
                        updateShelf();
                        try {
                            RegisteredController.writeFile();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            TransactionController.writeFile();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    dispose();
                }
            });
            loginDialog = new Dialog(mfvs, true);
            registerDialog = new Dialog(mfvs, true);
            searchProductDialog = new Dialog(mfvs, true);
            addProductDialog = new Dialog(mfvs, true);
            editProductDialog = new Dialog(mfvs, true);
            checkStorageDialog = new Dialog(mfvs, true);
            cartDialog = new Dialog(mfvs, true);
            init();
        }

        public void init() {
            setBounds(400, 250, 800, 400);
            loginDialog.setBounds(300, 300, 200, 170);
            registerDialog.setBounds(300, 300, 200, 170);
            searchProductDialog.setBounds(300, 300, 200, 170);
            addProductDialog.setBounds(300, 300, 200, 170);
            editProductDialog.setBounds(300, 300, 200, 170);
            checkStorageDialog.setBounds(300, 300, 200, 170);
            cartDialog.setBounds(300, 300, 200, 170);

            bottomPanel.add(purchaseButton);
            bottomPanel.add(clearButton);
            bottomPanel.add(closeButton);

            setLayout(new BorderLayout());
            add(buttonPanel, BorderLayout.NORTH);
            add(new JScrollPane(productTable), BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

        }

        public void clearCartUI() {
            CartController.clearCart();
            DefaultTableModel cartTableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            productTable.setModel(cartTableModel);

        }


    }


    public class OrderUI extends JFrame {
        private String[] tableColumn = {"ID", "Customer", "Time", "Price"};

        private ListSelectionListener listSelectionListener;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable orderTable;

        private JButton closeButton;


        public OrderUI() {


            buttonPanel = new JPanel();
            bottomPanel = new JPanel();
            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            List<Order> orders;
            if (getCurrentUser().getEmail().equals("admin@test.com")) {
                 orders = TransactionController.viewOrders();
                for (Order o : orders) {
                    Object[] data = {o.getId(), o.getCustomer().getEmail(), o.getTime(), o.getPaidPrice()};
                    tableModel.addRow(data);
                }
            } else {
                orders = TransactionController.viewOrders(getCurrentUser());
                for (Order o : orders) {
                    Object[] data = {o.getId(), o.getCustomer().getEmail(), o.getTime(), o.getPaidPrice()};
                    tableModel.addRow(data);
                }
            }

            orderTable = new JTable(tableModel);

            orderTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table = (JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < orders.size()) {
                        new OrderProductUI(orders.get(row)).setVisible(true);
                    }
                }
            });

            closeButton = new JButton("Close");

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                }
            });
            init();
        }

        public void init() {
            setBounds(400, 250, 800, 400);

            bottomPanel.add(closeButton);

            setLayout(new BorderLayout());
            add(buttonPanel, BorderLayout.NORTH);
            add(new JScrollPane(orderTable), BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

        }


    }


    public class OrderProductUI extends JFrame {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private ListSelectionListener listSelectionListener;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable productTable;

        private JButton closeButton;


        public OrderProductUI(Order order) {


            buttonPanel = new JPanel();
            bottomPanel = new JPanel();

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            for (Product p : order.getProducts()) {
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

                tableModel.addRow(data);
            }

            productTable = new JTable(tableModel);

            closeButton = new JButton("Close");

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                }
            });
            init();
        }

        public void init() {
            setBounds(400, 250, 800, 400);

            bottomPanel.add(closeButton);

            setLayout(new BorderLayout());
            add(buttonPanel, BorderLayout.NORTH);
            add(new JScrollPane(productTable), BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

        }


    }


    public class ManageProductUI extends JFrame {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private ListSelectionListener listSelectionListener;
        private JFrame mfvs;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        public JTable productTable;

        private JButton addButton;
        private JButton closeButton;

        private Dialog loginDialog;
        private Dialog registerDialog;
        private Dialog searchProductDialog;
        private Dialog addProductDialog;
        private Dialog editProductDialog;
        private Dialog checkStorageDialog;
        private Dialog cartDialog;

        public ManageProductUI() {


            buttonPanel = new JPanel();
            bottomPanel = new JPanel();

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            shelf = ShelfController.getShelfProducts();

            for (Product p : shelf) {
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

                tableModel.addRow(data);
            }

            productTable = new JTable(tableModel);

            productTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table = (JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < shelf.size()) {
//                        new GUI_shelf(row, shelf.get(row)).setVisible(true);
                        new GUI_shelfEditDelete(productTable, row, shelf.get(row));
                    }
                }
            });

            addButton = new JButton("Add Product");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JFrame jf = new GUI_shelfAdd(productTable);
                    jf.setVisible(true);
                }
            });

            closeButton = new JButton("Close");

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                }
            });
            loginDialog = new Dialog(mfvs, true);
            registerDialog = new Dialog(mfvs, true);
            searchProductDialog = new Dialog(mfvs, true);
            addProductDialog = new Dialog(mfvs, true);
            editProductDialog = new Dialog(mfvs, true);
            checkStorageDialog = new Dialog(mfvs, true);
            cartDialog = new Dialog(mfvs, true);
            init();
        }

        public void init() {
            setBounds(400, 250, 800, 400);
            loginDialog.setBounds(300, 300, 200, 170);
            registerDialog.setBounds(300, 300, 200, 170);
            searchProductDialog.setBounds(300, 300, 200, 170);
            addProductDialog.setBounds(300, 300, 200, 170);
            editProductDialog.setBounds(300, 300, 200, 170);
            checkStorageDialog.setBounds(300, 300, 200, 170);
            cartDialog.setBounds(300, 300, 200, 170);

            buttonPanel.add(addButton);

            bottomPanel.add(closeButton);

            setLayout(new BorderLayout());
            add(buttonPanel, BorderLayout.NORTH);
            add(new JScrollPane(productTable), BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

        }


    }


    public class SearchUI extends JFrame {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private ListSelectionListener listSelectionListener;
        private JFrame mfvs;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable productTable;


        private JTextField searchTextField;

        private JButton clearButton;
        private JButton closeButton;
        private JButton purchaseButton;
        private JButton searchButton;


        public SearchUI() {


            buttonPanel = new JPanel();
            bottomPanel = new JPanel();

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            shelf = ShelfController.getShelfProducts();

            for (Product p : shelf) {
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

                tableModel.addRow(data);
            }

            productTable = new JTable(tableModel);



            searchTextField = new JTextField();

            //searchTextField.setBounds(144, 62, 150, 31);
            searchTextField.setPreferredSize(new Dimension(150, 31));

            clearButton = new JButton("Clear");
            closeButton = new JButton("Close");
            purchaseButton = new JButton("Purchase");
            searchButton = new JButton("Search");

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateSearchShelf(searchTextField.getText());
                }
            });

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                }
            });

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println(searchTextField.getText());
                    updateSearchShelf(searchTextField.getText());
                }
            });


            loginDialog = new Dialog(mfvs, true);
            registerDialog = new Dialog(mfvs, true);
            searchProductDialog = new Dialog(mfvs, true);
            addProductDialog = new Dialog(mfvs, true);
            editProductDialog = new Dialog(mfvs, true);
            checkStorageDialog = new Dialog(mfvs, true);
            cartDialog = new Dialog(mfvs, true);
            init();
        }

        public void updateSearchShelf(String pName) {

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            shelf = ShelfController.getShelfProducts();
            shelfAfterSearch = new ArrayList<>();
            for (Product p : shelf) {
                if (p.getName().equals(pName)) {
                    Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};
                    shelfAfterSearch.add(p);
                    tableModel.addRow(data);
                }

            }
            tableModel.fireTableDataChanged();
            productTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table = (JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < shelfAfterSearch.size()) {
                        new GUI_addToCart(shelfAfterSearch.get(row)).setVisible(true);
                    }
                }
            });
            productTable.setModel(tableModel);


        }

        public void init() {
            setBounds(400, 250, 800, 400);

            buttonPanel.add(searchTextField);
            buttonPanel.add(searchButton);

            bottomPanel.add(closeButton);

            setLayout(new BorderLayout());
            add(buttonPanel, BorderLayout.NORTH);
            add(new JScrollPane(productTable), BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

        }


    }


    class GUI_addToCart extends JFrame {

        private JMenuBar menuBar;
        private JPanel addToCart_panel;
        private JLabel addToCart_title_label;
        private JButton addToCart_add_button;
        private JButton addToCart_cancel_button;
        private JLabel addToCart_number_label;
        private JTextField addToCart_number_textfield;

        //Constructor
        public GUI_addToCart(Product product) {

            this.setTitle("GUI_addToCart");
            this.setSize(303, 170);
            //menu generate method
            //generateMenu();
            this.setJMenuBar(menuBar);

            //pane with null layout
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(303, 170));
            contentPane.setBackground(new Color(192, 192, 192));


            addToCart_panel = new JPanel(null);
            addToCart_panel.setBorder(BorderFactory.createEtchedBorder(1));
            addToCart_panel.setBounds(-5, -5, 303, 170);
            addToCart_panel.setBackground(new Color(214, 217, 223));
            addToCart_panel.setForeground(new Color(0, 0, 0));
            addToCart_panel.setEnabled(true);
            addToCart_panel.setFont(new Font("sansserif", 0, 12));
            addToCart_panel.setVisible(true);

            addToCart_title_label = new JLabel();
            addToCart_title_label.setBounds(94, 13, 118, 31);
            addToCart_title_label.setBackground(new Color(214, 217, 223));
            addToCart_title_label.setForeground(new Color(0, 0, 0));
            addToCart_title_label.setEnabled(true);
            addToCart_title_label.setFont(new Font("SansSerif", 0, 17));
            addToCart_title_label.setText("Add To Cart");
            addToCart_title_label.setVisible(true);

            addToCart_add_button = new JButton();
            addToCart_add_button.setBounds(36, 109, 90, 35);
            addToCart_add_button.setBackground(new Color(214, 217, 223));
            addToCart_add_button.setForeground(new Color(0, 0, 0));
            addToCart_add_button.setEnabled(true);
            addToCart_add_button.setFont(new Font("sansserif", 0, 12));
            addToCart_add_button.setText("Add");
            addToCart_add_button.setVisible(true);

            addToCart_add_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int purchaseQuantity = Integer.parseInt(addToCart_number_textfield.getText());
                    if (purchaseQuantity > 0 && purchaseQuantity <= product.getProductNumber()) {
                        //product.setProductNumber(product.getProductNumber() - purchaseQuantity);
                        updateShelf();

                        Product pToc = new Product(product.getId(), product.getName(), product.getType(), product.getPrice(), product.getShelfLife(), product.getStartDate(), product.getDiscountRate(), product.getSellType(), purchaseQuantity);
                        CartController.addItem(pToc);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry, the purchase quantity can not exceed in-stock quantity!");
                    }
                    dispose();
                }
            });

            addToCart_cancel_button = new JButton();
            addToCart_cancel_button.setBounds(167, 109, 90, 35);
            addToCart_cancel_button.setBackground(new Color(214, 217, 223));
            addToCart_cancel_button.setForeground(new Color(0, 0, 0));
            addToCart_cancel_button.setEnabled(true);
            addToCart_cancel_button.setFont(new Font("sansserif", 0, 12));
            addToCart_cancel_button.setText("Cancel");
            addToCart_cancel_button.setVisible(true);
            addToCart_cancel_button.addActionListener(e -> dispose());

            addToCart_number_label = new JLabel();
            addToCart_number_label.setBounds(57, 61, 90, 35);
            addToCart_number_label.setBackground(new Color(214, 217, 223));
            addToCart_number_label.setForeground(new Color(0, 0, 0));
            addToCart_number_label.setEnabled(true);
            addToCart_number_label.setFont(new Font("SansSerif", 0, 12));
            addToCart_number_label.setText("Number:");
            addToCart_number_label.setVisible(true);

            addToCart_number_textfield = new JTextField();
            addToCart_number_textfield.setBounds(144, 62, 117, 31);
            addToCart_number_textfield.setBackground(new Color(255, 255, 255));
            addToCart_number_textfield.setForeground(new Color(0, 0, 0));
            addToCart_number_textfield.setEnabled(true);
            addToCart_number_textfield.setFont(new Font("sansserif", 0, 12));
            addToCart_number_textfield.setText("");
            addToCart_number_textfield.setVisible(true);

            //adding components to contentPane panel
            contentPane.add(addToCart_panel);
            addToCart_panel.add(addToCart_title_label);
            addToCart_panel.add(addToCart_add_button);
            addToCart_panel.add(addToCart_cancel_button);
            addToCart_panel.add(addToCart_number_label);
            addToCart_panel.add(addToCart_number_textfield);

            //adding panel to JFrame and seting of window position and close operation
            this.add(contentPane);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }
    }


    class GUI_editCart extends JFrame {

        private JMenuBar menuBar;
        private JButton editCart_add_button;
        private JButton editCart_cancel_button;
        private JButton editCart_delete_button;
        private JLabel editCart_number_label;
        private JTextField editCart_number_textfield;
        private JPanel editCart_panel;
        private JLabel editCart_title;

        JTable productTable;


        public void updateCart() {
            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            List<Product> cart = CartController.getProductList();

            for (Product p : cart) {
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

                tableModel.addRow(data);
            }

            tableModel.fireTableDataChanged();
            productTable.setModel(tableModel);

        }

        //Constructor
        public GUI_editCart(JTable productTable, int row, Product product) {

            this.productTable = productTable;
            this.setTitle("GUI_editCart");
            this.setSize(300, 200);
            //menu generate method
            this.setJMenuBar(menuBar);

            //pane with null layout
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(300, 200));
            contentPane.setBackground(new Color(192, 192, 192));


            editCart_add_button = new JButton();
            editCart_add_button.setBounds(28, 105, 73, 35);
            editCart_add_button.setBackground(new Color(214, 217, 223));
            editCart_add_button.setForeground(new Color(0, 0, 0));
            editCart_add_button.setEnabled(true);
            editCart_add_button.setFont(new Font("sansserif", 0, 12));
            editCart_add_button.setText("Edit");
            editCart_add_button.setVisible(true);


            editCart_cancel_button = new JButton();
            editCart_cancel_button.setBounds(200, 105, 73, 35);
            editCart_cancel_button.setBackground(new Color(214, 217, 223));
            editCart_cancel_button.setForeground(new Color(0, 0, 0));
            editCart_cancel_button.setEnabled(true);
            editCart_cancel_button.setFont(new Font("sansserif", 0, 12));
            editCart_cancel_button.setText("Cancel");
            editCart_cancel_button.setVisible(true);


            editCart_delete_button = new JButton();
            editCart_delete_button.setBounds(116, 105, 73, 35);
            editCart_delete_button.setBackground(new Color(214, 217, 223));
            editCart_delete_button.setForeground(new Color(0, 0, 0));
            editCart_delete_button.setEnabled(true);
            editCart_delete_button.setFont(new Font("sansserif", 0, 12));
            editCart_delete_button.setText("Delete");
            editCart_delete_button.setVisible(true);

            editCart_number_label = new JLabel();
            editCart_number_label.setBounds(44, 47, 77, 31);
            editCart_number_label.setBackground(new Color(214, 217, 223));
            editCart_number_label.setForeground(new Color(0, 0, 0));
            editCart_number_label.setEnabled(true);
            editCart_number_label.setFont(new Font("SansSerif", 0, 12));
            editCart_number_label.setText("Number:");
            editCart_number_label.setVisible(true);

            editCart_number_textfield = new JTextField();
            editCart_number_textfield.setBounds(140, 47, 117, 31);
            editCart_number_textfield.setBackground(new Color(255, 255, 255));
            editCart_number_textfield.setForeground(new Color(0, 0, 0));
            editCart_number_textfield.setEnabled(true);
            editCart_number_textfield.setFont(new Font("sansserif", 0, 12));
            editCart_number_textfield.setText("" + product.getProductNumber());
            editCart_number_textfield.setVisible(true);

            editCart_panel = new JPanel(null);
            editCart_panel.setBorder(BorderFactory.createEtchedBorder(1));
            editCart_panel.setBounds(-5, -5, 300, 200);
            editCart_panel.setBackground(new Color(214, 217, 223));
            editCart_panel.setForeground(new Color(0, 0, 0));
            editCart_panel.setEnabled(true);
            editCart_panel.setFont(new Font("sansserif", 0, 12));
            editCart_panel.setVisible(true);

            editCart_title = new JLabel();
            editCart_title.setBounds(117, 10, 104, 28);
            editCart_title.setBackground(new Color(214, 217, 223));
            editCart_title.setForeground(new Color(0, 0, 0));
            editCart_title.setEnabled(true);
            editCart_title.setFont(new Font("SansSerif", 0, 17));
            editCart_title.setText("Edit");
            editCart_title.setVisible(true);


            editCart_add_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    CartController.updateCart(row, Integer.parseInt(editCart_number_textfield.getText()));
                    updateCart();
                    dispose();
                }
            });
            editCart_delete_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    CartController.removeItem(row);
                    updateCart();
                    dispose();
                }
            });
            editCart_cancel_button.addActionListener(e -> dispose());

            //adding components to contentPane panel
            editCart_panel.add(editCart_add_button);
            editCart_panel.add(editCart_cancel_button);
            editCart_panel.add(editCart_delete_button);
            editCart_panel.add(editCart_number_label);
            editCart_panel.add(editCart_number_textfield);
            contentPane.add(editCart_panel);
            editCart_panel.add(editCart_title);

            //adding panel to JFrame and seting of window position and close operation
            this.add(contentPane);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }
    }


    public class GUI_shelfAdd extends JFrame {

        private JMenuBar menuBar;
        private JLabel shelfAdd_product_id_label;
        private JButton shelfAdd_cancel_button;
        private JButton shelfAdd_confirm_button;
        private JLabel shelfAdd_discountRate_label;
        private JLabel shelfAdd_name_label;
        private JLabel shelfAdd_number_label;
        private JLabel shelfAdd_price_label;
        private JLabel shelfAdd_sellType_label;
        private JLabel shelfAdd_shelfLife_label;
        private JLabel shelfAdd_startDate_label;
        private JLabel shelfAdd_title_label;
        private JLabel shelf_type_label;
        private JTextField shelf_discountRate_ltextfield;
        private JPanel shelfAdd_pannel;
        private JTextField shelf_id_textfield;
        private JTextField shelf_name_textfield;
        private JTextField shelf_price_textfield4;
        private JTextField shelf_productNumber_textfield;
        private JTextField shelf_sellType_textfield;
        private JTextField shelf_shelfLife_textfield;
        private JTextField shelf_startDate_textfield;
        private JTextField shelf_type_textfield;

        private JTable productTable;

        public void updateManageShelf() {

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            shelf = ShelfController.getShelfProducts();

            for (Product p : shelf) {
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

                tableModel.addRow(data);
            }
            tableModel.fireTableDataChanged();
            productTable.setModel(tableModel);

        }

        //Constructor
        public GUI_shelfAdd(JTable productTable) {

            this.productTable = productTable;
            this.setTitle("GUI_shelfAdd");
            this.setSize(533, 504);
            //menu generate method
            //generateMenu();
            this.setJMenuBar(menuBar);

            //pane with null layout
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(533, 504));
            contentPane.setBackground(new Color(192, 192, 192));


            shelfAdd_product_id_label = new JLabel();
            shelfAdd_product_id_label.setBounds(74, 42, 90, 35);
            shelfAdd_product_id_label.setBackground(new Color(214, 217, 223));
            shelfAdd_product_id_label.setForeground(new Color(0, 0, 0));
            shelfAdd_product_id_label.setEnabled(true);
            shelfAdd_product_id_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_product_id_label.setText("ID:");
            shelfAdd_product_id_label.setVisible(true);

            shelfAdd_cancel_button = new JButton();
            shelfAdd_cancel_button.setBounds(177, 409, 90, 35);
            shelfAdd_cancel_button.setBackground(new Color(214, 217, 223));
            shelfAdd_cancel_button.setForeground(new Color(0, 0, 0));
            shelfAdd_cancel_button.setEnabled(true);
            shelfAdd_cancel_button.setFont(new Font("sansserif", 0, 12));
            shelfAdd_cancel_button.setText("Cancel");
            shelfAdd_cancel_button.setVisible(true);

            shelfAdd_cancel_button.addActionListener(e -> dispose());

            shelfAdd_confirm_button = new JButton();
            shelfAdd_confirm_button.setBounds(50, 409, 90, 35);
            shelfAdd_confirm_button.setBackground(new Color(214, 217, 223));
            shelfAdd_confirm_button.setForeground(new Color(0, 0, 0));
            shelfAdd_confirm_button.setEnabled(true);
            shelfAdd_confirm_button.setFont(new Font("sansserif", 0, 12));
            shelfAdd_confirm_button.setText("Confirm");
            shelfAdd_confirm_button.setVisible(true);

            shelfAdd_confirm_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (shelf_id_textfield.getText().equals("") || shelf_name_textfield.getText().equals("") || shelf_type_textfield.getText().equals("")
                            || shelf_price_textfield4.getText().equals("") || shelf_shelfLife_textfield.getText().equals("") || shelf_startDate_textfield.getText().equals("")
                            || shelf_discountRate_ltextfield.getText().equals("") || shelf_sellType_textfield.getText().equals("") || shelf_productNumber_textfield.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Sorry, one or more text fields are empty");
                    } else {
                        try {
                            int pId = Integer.parseInt(shelf_id_textfield.getText());
                            String pName = shelf_name_textfield.getText();
                            int pType = Integer.parseInt(shelf_type_textfield.getText());
                            double pPrice = Double.parseDouble(shelf_price_textfield4.getText());
                            int pLife = Integer.parseInt(shelf_shelfLife_textfield.getText());
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String date = shelf_startDate_textfield.getText();
                            Date pDate = formatter.parse(shelf_startDate_textfield.getText());
                            double pRate = Double.parseDouble(shelf_discountRate_ltextfield.getText());
                            int pSellType = Integer.parseInt(shelf_sellType_textfield.getText());
                            int pNum = Integer.parseInt(shelf_productNumber_textfield.getText());
                            if (!ShelfController.validateProductId(pId)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product Id is invalid!");
                            } else if (!ShelfController.validateProductName(pName)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product name is invalid!");
                            } else if (!ShelfController.validateProductType(pType)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product type is invalid!");
                            } else if (!ShelfController.validateProductPrice(pPrice)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product price is invalid!");
                            } else if (!ShelfController.validateProductShelfLife(pLife)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product shelf life is invalid!");
                            } else if (!ShelfController.validateProductStartDate(date)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product date is invalid!");
                            } else if (!ShelfController.validateProductDiscountRate(pRate)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product discount rate is invalid!");
                            } else if (!ShelfController.validateProductSellType(pSellType)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product sell type is invalid!");
                            } else if (!ShelfController.validateProductNum(pNum)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product quantity is invalid!");
                            } else {
                                Product product = new Product(pId, pName, pType, pPrice, pLife, pDate, pRate, pSellType, pNum);

                                ShelfController.insertProduct(product);
                                updateManageShelf();
                                updateShelf();
                                try {
                                    ShelfController.writeFile();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                dispose();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });

            shelfAdd_discountRate_label = new JLabel();
            shelfAdd_discountRate_label.setBounds(74, 282, 90, 35);
            shelfAdd_discountRate_label.setBackground(new Color(214, 217, 223));
            shelfAdd_discountRate_label.setForeground(new Color(0, 0, 0));
            shelfAdd_discountRate_label.setEnabled(true);
            shelfAdd_discountRate_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_discountRate_label.setText("Discount Rate:");
            shelfAdd_discountRate_label.setVisible(true);

            shelfAdd_name_label = new JLabel();
            shelfAdd_name_label.setBounds(74, 82, 90, 35);
            shelfAdd_name_label.setBackground(new Color(214, 217, 223));
            shelfAdd_name_label.setForeground(new Color(0, 0, 0));
            shelfAdd_name_label.setEnabled(true);
            shelfAdd_name_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_name_label.setText("Name:");
            shelfAdd_name_label.setVisible(true);

            shelfAdd_number_label = new JLabel();
            shelfAdd_number_label.setBounds(74, 362, 90, 29);
            shelfAdd_number_label.setBackground(new Color(214, 217, 223));
            shelfAdd_number_label.setForeground(new Color(0, 0, 0));
            shelfAdd_number_label.setEnabled(true);
            shelfAdd_number_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_number_label.setText("Number:");
            shelfAdd_number_label.setVisible(true);

            shelfAdd_price_label = new JLabel();
            shelfAdd_price_label.setBounds(74, 162, 90, 35);
            shelfAdd_price_label.setBackground(new Color(214, 217, 223));
            shelfAdd_price_label.setForeground(new Color(0, 0, 0));
            shelfAdd_price_label.setEnabled(true);
            shelfAdd_price_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_price_label.setText("Price:");
            shelfAdd_price_label.setVisible(true);

            shelfAdd_sellType_label = new JLabel();
            shelfAdd_sellType_label.setBounds(74, 322, 90, 35);
            shelfAdd_sellType_label.setBackground(new Color(214, 217, 223));
            shelfAdd_sellType_label.setForeground(new Color(0, 0, 0));
            shelfAdd_sellType_label.setEnabled(true);
            shelfAdd_sellType_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_sellType_label.setText("Sell Type:");
            shelfAdd_sellType_label.setVisible(true);

            shelfAdd_shelfLife_label = new JLabel();
            shelfAdd_shelfLife_label.setBounds(74, 202, 90, 35);
            shelfAdd_shelfLife_label.setBackground(new Color(214, 217, 223));
            shelfAdd_shelfLife_label.setForeground(new Color(0, 0, 0));
            shelfAdd_shelfLife_label.setEnabled(true);
            shelfAdd_shelfLife_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_shelfLife_label.setText("ShelfLife:");
            shelfAdd_shelfLife_label.setVisible(true);

            shelfAdd_startDate_label = new JLabel();
            shelfAdd_startDate_label.setBounds(74, 242, 90, 35);
            shelfAdd_startDate_label.setBackground(new Color(214, 217, 223));
            shelfAdd_startDate_label.setForeground(new Color(0, 0, 0));
            shelfAdd_startDate_label.setEnabled(true);
            shelfAdd_startDate_label.setFont(new Font("sansserif", 0, 12));
            shelfAdd_startDate_label.setText("Start Date:");
            shelfAdd_startDate_label.setVisible(true);

            shelfAdd_title_label = new JLabel();
            shelfAdd_title_label.setBounds(96, 5, 220, 35);
            shelfAdd_title_label.setBackground(new Color(214, 217, 223));
            shelfAdd_title_label.setForeground(new Color(0, 0, 0));
            shelfAdd_title_label.setEnabled(true);
            shelfAdd_title_label.setFont(new Font("SansSerif", 0, 20));
            shelfAdd_title_label.setText("Add Product");
            shelfAdd_title_label.setVisible(true);

            shelf_type_label = new JLabel();
            shelf_type_label.setBounds(74, 122, 90, 35);
            shelf_type_label.setBackground(new Color(214, 217, 223));
            shelf_type_label.setForeground(new Color(0, 0, 0));
            shelf_type_label.setEnabled(true);
            shelf_type_label.setFont(new Font("sansserif", 0, 12));
            shelf_type_label.setText("Type:");
            shelf_type_label.setVisible(true);

            shelf_discountRate_ltextfield = new JTextField();
            shelf_discountRate_ltextfield.setBounds(163, 282, 90, 35);
            shelf_discountRate_ltextfield.setBackground(new Color(255, 255, 255));
            shelf_discountRate_ltextfield.setForeground(new Color(0, 0, 0));
            shelf_discountRate_ltextfield.setEnabled(true);
            shelf_discountRate_ltextfield.setFont(new Font("sansserif", 0, 12));
            shelf_discountRate_ltextfield.setText("");
            shelf_discountRate_ltextfield.setVisible(true);

            shelfAdd_pannel = new JPanel(null);
            shelfAdd_pannel.setBorder(BorderFactory.createEtchedBorder(1));
            shelfAdd_pannel.setBounds(81, 9, 322, 474);
            shelfAdd_pannel.setBackground(new Color(214, 217, 223));
            shelfAdd_pannel.setForeground(new Color(0, 0, 0));
            shelfAdd_pannel.setEnabled(true);
            shelfAdd_pannel.setFont(new Font("sansserif", 0, 12));
            shelfAdd_pannel.setVisible(true);

            shelf_id_textfield = new JTextField();
            shelf_id_textfield.setBounds(163, 42, 90, 35);
            shelf_id_textfield.setBackground(new Color(255, 255, 255));
            shelf_id_textfield.setForeground(new Color(0, 0, 0));
            shelf_id_textfield.setEnabled(true);
            shelf_id_textfield.setFont(new Font("sansserif", 0, 12));
            shelf_id_textfield.setText("");
            shelf_id_textfield.setVisible(true);

            shelf_name_textfield = new JTextField();
            shelf_name_textfield.setBounds(163, 82, 90, 35);
            shelf_name_textfield.setBackground(new Color(255, 255, 255));
            shelf_name_textfield.setForeground(new Color(0, 0, 0));
            shelf_name_textfield.setEnabled(true);
            shelf_name_textfield.setFont(new Font("sansserif", 0, 12));
            shelf_name_textfield.setText("");
            shelf_name_textfield.setVisible(true);

            shelf_price_textfield4 = new JTextField();
            shelf_price_textfield4.setBounds(163, 162, 90, 35);
            shelf_price_textfield4.setBackground(new Color(255, 255, 255));
            shelf_price_textfield4.setForeground(new Color(0, 0, 0));
            shelf_price_textfield4.setEnabled(true);
            shelf_price_textfield4.setFont(new Font("sansserif", 0, 12));
            shelf_price_textfield4.setText("");
            shelf_price_textfield4.setVisible(true);

            shelf_productNumber_textfield = new JTextField();
            shelf_productNumber_textfield.setBounds(163, 362, 90, 35);
            shelf_productNumber_textfield.setBackground(new Color(255, 255, 255));
            shelf_productNumber_textfield.setForeground(new Color(0, 0, 0));
            shelf_productNumber_textfield.setEnabled(true);
            shelf_productNumber_textfield.setFont(new Font("sansserif", 0, 12));
            shelf_productNumber_textfield.setText("");
            shelf_productNumber_textfield.setVisible(true);

            shelf_sellType_textfield = new JTextField();
            shelf_sellType_textfield.setBounds(163, 322, 90, 35);
            shelf_sellType_textfield.setBackground(new Color(255, 255, 255));
            shelf_sellType_textfield.setForeground(new Color(0, 0, 0));
            shelf_sellType_textfield.setEnabled(true);
            shelf_sellType_textfield.setFont(new Font("sansserif", 0, 12));
            shelf_sellType_textfield.setText("");
            shelf_sellType_textfield.setVisible(true);

            shelf_shelfLife_textfield = new JTextField();
            shelf_shelfLife_textfield.setBounds(163, 202, 90, 35);
            shelf_shelfLife_textfield.setBackground(new Color(255, 255, 255));
            shelf_shelfLife_textfield.setForeground(new Color(0, 0, 0));
            shelf_shelfLife_textfield.setEnabled(true);
            shelf_shelfLife_textfield.setFont(new Font("sansserif", 0, 12));
            shelf_shelfLife_textfield.setText("");
            shelf_shelfLife_textfield.setVisible(true);

            shelf_startDate_textfield = new JTextField();
            shelf_startDate_textfield.setBounds(163, 242, 90, 35);
            shelf_startDate_textfield.setBackground(new Color(255, 255, 255));
            shelf_startDate_textfield.setForeground(new Color(0, 0, 0));
            shelf_startDate_textfield.setEnabled(true);
            shelf_startDate_textfield.setFont(new Font("sansserif", 0, 12));
            shelf_startDate_textfield.setText("");
            shelf_startDate_textfield.setVisible(true);

            shelf_type_textfield = new JTextField();
            shelf_type_textfield.setBounds(163, 122, 90, 35);
            shelf_type_textfield.setBackground(new Color(255, 255, 255));
            shelf_type_textfield.setForeground(new Color(0, 0, 0));
            shelf_type_textfield.setEnabled(true);
            shelf_type_textfield.setFont(new Font("sansserif", 0, 12));
            shelf_type_textfield.setText("");
            shelf_type_textfield.setVisible(true);

            //adding components to contentPane panel
            shelfAdd_pannel.add(shelfAdd_product_id_label);
            shelfAdd_pannel.add(shelfAdd_cancel_button);
            shelfAdd_pannel.add(shelfAdd_confirm_button);
            shelfAdd_pannel.add(shelfAdd_discountRate_label);
            shelfAdd_pannel.add(shelfAdd_name_label);
            shelfAdd_pannel.add(shelfAdd_number_label);
            shelfAdd_pannel.add(shelfAdd_price_label);
            shelfAdd_pannel.add(shelfAdd_sellType_label);
            shelfAdd_pannel.add(shelfAdd_shelfLife_label);
            shelfAdd_pannel.add(shelfAdd_startDate_label);
            shelfAdd_pannel.add(shelfAdd_title_label);
            shelfAdd_pannel.add(shelf_type_label);
            shelfAdd_pannel.add(shelf_discountRate_ltextfield);
            contentPane.add(shelfAdd_pannel);
            shelfAdd_pannel.add(shelf_id_textfield);
            shelfAdd_pannel.add(shelf_name_textfield);
            shelfAdd_pannel.add(shelf_price_textfield4);
            shelfAdd_pannel.add(shelf_productNumber_textfield);
            shelfAdd_pannel.add(shelf_sellType_textfield);
            shelfAdd_pannel.add(shelf_shelfLife_textfield);
            shelfAdd_pannel.add(shelf_startDate_textfield);
            shelfAdd_pannel.add(shelf_type_textfield);

            //adding panel to JFrame and seting of window position and close operation
            this.add(contentPane);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }

    }

    public class GUI_shelfEditDelete extends JFrame {

        private JMenuBar menuBar;
        private JLabel addToShelf_product_id_label;
        private JButton shelfAdd_edit_button;
        private JButton shelfEditDelete_cancel_button;
        private JButton shelfEditDelete_confirm_button;
        private JLabel shelfEditDelete_discountRate_label;
        private JTextField shelfEditDelete_discountRate_textfield;
        private JTextField shelfEditDelete_id_textfield;
        private JLabel shelfEditDelete_name_label;
        private JTextField shelfEditDelete_name_textfield;
        private JLabel shelfEditDelete_number_label;
        private JTextField shelfEditDelete_number_textfield;
        private JLabel shelfEditDelete_price_label;
        private JLabel shelfEditDelete_sellType_label;
        private JTextField shelfEditDelete_sellType_textfield;
        private JLabel shelfEditDelete_shelfLife_label;
        private JTextField shelfEditDelete_shelfLife_textfield;
        private JLabel shelfEditDelete_startDate_label;
        private JTextField shelfEditDelete_startDate_textfield;
        private JLabel shelfEditDelete_title_label;
        private JTextField shelfEditDelete_type_textfield;
        private JLabel shelf_type_label;
        private JPanel shelfEditDelete_pannel;
        private JTextField shelf_price_textfield4;

        JTable productTable;


        public void updateManageShelf() {

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            shelf = ShelfController.getShelfProducts();

            for (Product p : shelf) {
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.getDiscountRate(), p.getSellType(), p.getProductNumber()};

                tableModel.addRow(data);
            }
            tableModel.fireTableDataChanged();
            productTable.setModel(tableModel);

        }

        //Constructor
        public GUI_shelfEditDelete(JTable productTable, int row, Product product) {

            this.productTable = productTable;
            this.setTitle("GUI_shelfEditDelete");
            this.setSize(322, 474);
            //menu generate method
            //generateMenu();
            this.setJMenuBar(menuBar);

            //pane with null layout
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(322, 474));
            contentPane.setBackground(new Color(192, 192, 192));


            addToShelf_product_id_label = new JLabel();
            addToShelf_product_id_label.setBounds(74, 42, 90, 35);
            addToShelf_product_id_label.setBackground(new Color(214, 217, 223));
            addToShelf_product_id_label.setForeground(new Color(0, 0, 0));
            addToShelf_product_id_label.setEnabled(true);
            addToShelf_product_id_label.setFont(new Font("sansserif", 0, 12));
            addToShelf_product_id_label.setText("ID:");
            addToShelf_product_id_label.setVisible(true);

            shelfAdd_edit_button = new JButton();
            shelfAdd_edit_button.setBounds(122, 419, 75, 35);
            shelfAdd_edit_button.setBackground(new Color(214, 217, 223));
            shelfAdd_edit_button.setForeground(new Color(0, 0, 0));
            shelfAdd_edit_button.setEnabled(true);
            shelfAdd_edit_button.setFont(new Font("sansserif", 0, 12));
            shelfAdd_edit_button.setText("Delete");
            shelfAdd_edit_button.setVisible(true);

            shelfAdd_edit_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    ShelfController.removeProduct(row);
                    updateManageShelf();
                    updateShelf();
                    dispose();
                }
            });

            shelfEditDelete_cancel_button = new JButton();
            shelfEditDelete_cancel_button.setBounds(213, 419, 75, 35);
            shelfEditDelete_cancel_button.setBackground(new Color(214, 217, 223));
            shelfEditDelete_cancel_button.setForeground(new Color(0, 0, 0));
            shelfEditDelete_cancel_button.setEnabled(true);
            shelfEditDelete_cancel_button.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_cancel_button.setText("Cancel");
            shelfEditDelete_cancel_button.setVisible(true);

            shelfEditDelete_cancel_button.addActionListener(e -> dispose());

            shelfEditDelete_confirm_button = new JButton();
            shelfEditDelete_confirm_button.setBounds(33, 419, 80, 35);
            shelfEditDelete_confirm_button.setBackground(new Color(214, 217, 223));
            shelfEditDelete_confirm_button.setForeground(new Color(0, 0, 0));
            shelfEditDelete_confirm_button.setEnabled(true);
            shelfEditDelete_confirm_button.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_confirm_button.setText("Confirm");
            shelfEditDelete_confirm_button.setVisible(true);


            shelfEditDelete_confirm_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (shelfEditDelete_id_textfield.getText().equals("") || shelfEditDelete_name_textfield.getText().equals("") || shelfEditDelete_type_textfield.getText().equals("")
                            || shelf_price_textfield4.getText().equals("") || shelfEditDelete_shelfLife_textfield.getText().equals("") || shelfEditDelete_startDate_textfield.getText().equals("")
                            || shelfEditDelete_discountRate_textfield.getText().equals("") || shelfEditDelete_sellType_textfield.getText().equals("") || shelfEditDelete_number_textfield.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Sorry, one or more text fields are empty");
                    } else {
                        try {
                            int pId = Integer.parseInt(shelfEditDelete_id_textfield.getText());
                            String pName = shelfEditDelete_name_textfield.getText();
                            int pType = Integer.parseInt(shelfEditDelete_type_textfield.getText());
                            double pPrice = Double.parseDouble(shelf_price_textfield4.getText());
                            int pLife = Integer.parseInt(shelfEditDelete_shelfLife_textfield.getText());
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String date = shelfEditDelete_startDate_textfield.getText();
                            Date pDate = formatter.parse(shelfEditDelete_startDate_textfield.getText());
                            double pRate = Double.parseDouble(shelfEditDelete_discountRate_textfield.getText());
                            int pSellType = Integer.parseInt(shelfEditDelete_sellType_textfield.getText());
                            int pNum = Integer.parseInt(shelfEditDelete_number_textfield.getText());
                            if (!ShelfController.validateProductId(pId)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product Id is invalid!");
                            } else if (!ShelfController.validateProductName(pName)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product name is invalid!");
                            } else if (!ShelfController.validateProductType(pType)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product type is invalid!");
                            } else if (!ShelfController.validateProductPrice(pPrice)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product price is invalid!");
                            } else if (!ShelfController.validateProductShelfLife(pLife)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product shelf life is invalid!");
                            } else if (!ShelfController.validateProductStartDate(date)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product date is invalid!");
                            } else if (!ShelfController.validateProductDiscountRate(pRate)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product discount rate is invalid!");
                            } else if (!ShelfController.validateProductSellType(pSellType)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product sell type is invalid!");
                            } else if (!ShelfController.validateProductNum(pNum)) {
                                JOptionPane.showMessageDialog(null, "Sorry, product quantity is invalid!");
                            } else {
                                Product product = new Product(pId, pName, pType, pPrice, pLife, pDate, pRate, pSellType, pNum);

                                ShelfController.updateProduct(row, product);
                                updateManageShelf();
                                updateShelf();
                                try {
                                    ShelfController.writeFile();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                dispose();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            shelfEditDelete_discountRate_label = new JLabel();
            shelfEditDelete_discountRate_label.setBounds(74, 282, 90, 35);
            shelfEditDelete_discountRate_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_discountRate_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_discountRate_label.setEnabled(true);
            shelfEditDelete_discountRate_label.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_discountRate_label.setText("Discount Rate:");
            shelfEditDelete_discountRate_label.setVisible(true);

            shelfEditDelete_discountRate_textfield = new JTextField();
            shelfEditDelete_discountRate_textfield.setBounds(163, 282, 90, 35);
            shelfEditDelete_discountRate_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_discountRate_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_discountRate_textfield.setEnabled(true);
            shelfEditDelete_discountRate_textfield.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_discountRate_textfield.setText("" + product.getDiscountRate());
            shelfEditDelete_discountRate_textfield.setVisible(true);

            shelfEditDelete_id_textfield = new JTextField();
            shelfEditDelete_id_textfield.setBounds(163, 42, 90, 35);
            shelfEditDelete_id_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_id_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_id_textfield.setEnabled(true);
            shelfEditDelete_id_textfield.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_id_textfield.setText("" + product.getId());
            shelfEditDelete_id_textfield.setVisible(true);

            shelfEditDelete_name_label = new JLabel();
            shelfEditDelete_name_label.setBounds(74, 82, 90, 35);
            shelfEditDelete_name_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_name_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_name_label.setEnabled(true);
            shelfEditDelete_name_label.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_name_label.setText("Name:");
            shelfEditDelete_name_label.setVisible(true);

            shelfEditDelete_name_textfield = new JTextField();
            shelfEditDelete_name_textfield.setBounds(163, 82, 90, 35);
            shelfEditDelete_name_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_name_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_name_textfield.setEnabled(true);
            shelfEditDelete_name_textfield.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_name_textfield.setText("" + product.getName());
            shelfEditDelete_name_textfield.setVisible(true);

            shelfEditDelete_number_label = new JLabel();
            shelfEditDelete_number_label.setBounds(74, 362, 90, 29);
            shelfEditDelete_number_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_number_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_number_label.setEnabled(true);
            shelfEditDelete_number_label.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_number_label.setText("Number:");
            shelfEditDelete_number_label.setVisible(true);

            shelfEditDelete_number_textfield = new JTextField();
            shelfEditDelete_number_textfield.setBounds(163, 361, 90, 35);
            shelfEditDelete_number_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_number_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_number_textfield.setEnabled(true);
            shelfEditDelete_number_textfield.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_number_textfield.setText("" + product.getProductNumber());
            shelfEditDelete_number_textfield.setVisible(true);

            shelfEditDelete_price_label = new JLabel();
            shelfEditDelete_price_label.setBounds(74, 162, 90, 35);
            shelfEditDelete_price_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_price_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_price_label.setEnabled(true);
            shelfEditDelete_price_label.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_price_label.setText("Price:");
            shelfEditDelete_price_label.setVisible(true);

            shelfEditDelete_sellType_label = new JLabel();
            shelfEditDelete_sellType_label.setBounds(74, 322, 90, 35);
            shelfEditDelete_sellType_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_sellType_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_sellType_label.setEnabled(true);
            shelfEditDelete_sellType_label.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_sellType_label.setText("Sell Type:");
            shelfEditDelete_sellType_label.setVisible(true);

            shelfEditDelete_sellType_textfield = new JTextField();
            shelfEditDelete_sellType_textfield.setBounds(163, 322, 90, 35);
            shelfEditDelete_sellType_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_sellType_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_sellType_textfield.setEnabled(true);
            shelfEditDelete_sellType_textfield.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_sellType_textfield.setText("" + product.getSellType());
            shelfEditDelete_sellType_textfield.setVisible(true);

            shelfEditDelete_shelfLife_label = new JLabel();
            shelfEditDelete_shelfLife_label.setBounds(74, 202, 90, 35);
            shelfEditDelete_shelfLife_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_shelfLife_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_shelfLife_label.setEnabled(true);
            shelfEditDelete_shelfLife_label.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_shelfLife_label.setText("ShelfLife:");
            shelfEditDelete_shelfLife_label.setVisible(true);

            shelfEditDelete_shelfLife_textfield = new JTextField();
            shelfEditDelete_shelfLife_textfield.setBounds(163, 202, 90, 35);
            shelfEditDelete_shelfLife_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_shelfLife_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_shelfLife_textfield.setEnabled(true);
            shelfEditDelete_shelfLife_textfield.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_shelfLife_textfield.setText("" + product.getShelfLife());
            shelfEditDelete_shelfLife_textfield.setVisible(true);

            shelfEditDelete_startDate_label = new JLabel();
            shelfEditDelete_startDate_label.setBounds(74, 242, 90, 35);
            shelfEditDelete_startDate_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_startDate_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_startDate_label.setEnabled(true);
            shelfEditDelete_startDate_label.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_startDate_label.setText("Start Date:");
            shelfEditDelete_startDate_label.setVisible(true);

            shelfEditDelete_startDate_textfield = new JTextField();
            shelfEditDelete_startDate_textfield.setBounds(163, 242, 90, 35);
            shelfEditDelete_startDate_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_startDate_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_startDate_textfield.setEnabled(true);
            shelfEditDelete_startDate_textfield.setFont(new Font("sansserif", 0, 12));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            shelfEditDelete_startDate_textfield.setText("" + formatter.format((product.getStartDate())));
            shelfEditDelete_startDate_textfield.setVisible(true);

            shelfEditDelete_title_label = new JLabel();
            shelfEditDelete_title_label.setBounds(69, 5, 220, 35);
            shelfEditDelete_title_label.setBackground(new Color(214, 217, 223));
            shelfEditDelete_title_label.setForeground(new Color(0, 0, 0));
            shelfEditDelete_title_label.setEnabled(true);
            shelfEditDelete_title_label.setFont(new Font("SansSerif", 0, 20));
            shelfEditDelete_title_label.setText("Edit/Delete Product");
            shelfEditDelete_title_label.setVisible(true);

            shelfEditDelete_type_textfield = new JTextField();
            shelfEditDelete_type_textfield.setBounds(163, 122, 90, 35);
            shelfEditDelete_type_textfield.setBackground(new Color(255, 255, 255));
            shelfEditDelete_type_textfield.setForeground(new Color(0, 0, 0));
            shelfEditDelete_type_textfield.setEnabled(true);
            shelfEditDelete_type_textfield.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_type_textfield.setText("" + product.getType());
            shelfEditDelete_type_textfield.setVisible(true);

            shelf_type_label = new JLabel();
            shelf_type_label.setBounds(74, 122, 90, 35);
            shelf_type_label.setBackground(new Color(214, 217, 223));
            shelf_type_label.setForeground(new Color(0, 0, 0));
            shelf_type_label.setEnabled(true);
            shelf_type_label.setFont(new Font("sansserif", 0, 12));
            shelf_type_label.setText("Type:");
            shelf_type_label.setVisible(true);

            shelfEditDelete_pannel = new JPanel(null);
            shelfEditDelete_pannel.setBorder(BorderFactory.createEtchedBorder(1));
            shelfEditDelete_pannel.setBounds(-5, -5, 322, 474);
            shelfEditDelete_pannel.setBackground(new Color(214, 217, 223));
            shelfEditDelete_pannel.setForeground(new Color(0, 0, 0));
            shelfEditDelete_pannel.setEnabled(true);
            shelfEditDelete_pannel.setFont(new Font("sansserif", 0, 12));
            shelfEditDelete_pannel.setVisible(true);

            shelf_price_textfield4 = new JTextField();
            shelf_price_textfield4.setBounds(163, 162, 90, 35);
            shelf_price_textfield4.setBackground(new Color(255, 255, 255));
            shelf_price_textfield4.setForeground(new Color(0, 0, 0));
            shelf_price_textfield4.setEnabled(true);
            shelf_price_textfield4.setFont(new Font("sansserif", 0, 12));
            shelf_price_textfield4.setText("" + product.getPrice());
            shelf_price_textfield4.setVisible(true);

            //adding components to contentPane panel
            shelfEditDelete_pannel.add(addToShelf_product_id_label);
            shelfEditDelete_pannel.add(shelfAdd_edit_button);
            shelfEditDelete_pannel.add(shelfEditDelete_cancel_button);
            shelfEditDelete_pannel.add(shelfEditDelete_confirm_button);
            shelfEditDelete_pannel.add(shelfEditDelete_discountRate_label);
            shelfEditDelete_pannel.add(shelfEditDelete_discountRate_textfield);
            shelfEditDelete_pannel.add(shelfEditDelete_id_textfield);
            shelfEditDelete_pannel.add(shelfEditDelete_name_label);
            shelfEditDelete_pannel.add(shelfEditDelete_name_textfield);
            shelfEditDelete_pannel.add(shelfEditDelete_number_label);
            shelfEditDelete_pannel.add(shelfEditDelete_number_textfield);
            shelfEditDelete_pannel.add(shelfEditDelete_price_label);
            shelfEditDelete_pannel.add(shelfEditDelete_sellType_label);
            shelfEditDelete_pannel.add(shelfEditDelete_sellType_textfield);
            shelfEditDelete_pannel.add(shelfEditDelete_shelfLife_label);
            shelfEditDelete_pannel.add(shelfEditDelete_shelfLife_textfield);
            shelfEditDelete_pannel.add(shelfEditDelete_startDate_label);
            shelfEditDelete_pannel.add(shelfEditDelete_startDate_textfield);
            shelfEditDelete_pannel.add(shelfEditDelete_title_label);
            shelfEditDelete_pannel.add(shelfEditDelete_type_textfield);
            shelfEditDelete_pannel.add(shelf_type_label);
            contentPane.add(shelfEditDelete_pannel);
            shelfEditDelete_pannel.add(shelf_price_textfield4);

            //adding panel to JFrame and seting of window position and close operation
            this.add(contentPane);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }
    }

    public class GUI_userInfo extends JFrame {

        private JMenuBar menuBar;
        private JLabel label1;
        private JLabel label2;
        private JLabel label3;
        private JLabel label4;
        private JLabel label5;
        private JLabel label6;
        private JLabel label7;
        private JLabel label8;
        private JLabel label9;
        private JPanel panel1;
        private JButton closeButton;
        private JButton changePassButton;


        //Constructor
        public GUI_userInfo() {

            this.setTitle("GUI_userInfo");
            this.setSize(400, 300);
            //menu generate method
            this.setJMenuBar(menuBar);


            //pane with null layout
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(400, 300));
            contentPane.setBackground(new Color(192, 192, 192));


            label1 = new JLabel();
            label1.setBounds(40, 60, 90, 40);
            label1.setBackground(new Color(214, 217, 223));
            label1.setForeground(new Color(0, 0, 0));
            label1.setEnabled(true);
            label1.setFont(new Font("sansserif", 0, 12));
            label1.setText("User emai: ");
            label1.setVisible(true);

            label2 = new JLabel();
            label2.setBounds(40, 100, 120, 40);
            label2.setBackground(new Color(214, 217, 223));
            label2.setForeground(new Color(0, 0, 0));
            label2.setEnabled(true);
            label2.setFont(new Font("sansserif", 0, 12));
            label2.setText("Current balance: ");
            label2.setVisible(true);

            label3 = new JLabel();
            label3.setBounds(40, 140, 90, 40);
            label3.setBackground(new Color(214, 217, 223));
            label3.setForeground(new Color(0, 0, 0));
            label3.setEnabled(true);
            label3.setFont(new Font("sansserif", 0, 12));
            label3.setText("Address:");
            label3.setVisible(true);

            label4 = new JLabel();
            label4.setBounds(40, 180, 90, 40);
            label4.setBackground(new Color(214, 217, 223));
            label4.setForeground(new Color(0, 0, 0));
            label4.setEnabled(true);
            label4.setFont(new Font("sansserif", 0, 12));
            label4.setText("Phone:");
            label4.setVisible(true);

            label5 = new JLabel();
            label5.setBounds(125, 12, 169, 33);
            label5.setBackground(new Color(214, 217, 223));
            label5.setForeground(new Color(0, 0, 0));
            label5.setEnabled(true);
            label5.setFont(new Font("SansSerif", 0, 20));
            label5.setText("User information");
            label5.setVisible(true);

            label6 = new JLabel();
            label6.setBounds(180, 60, 180, 40);
            label6.setBackground(new Color(214, 217, 223));
            label6.setForeground(new Color(0, 0, 0));
            label6.setEnabled(true);
            label6.setFont(new Font("sansserif", 0, 12));
            label6.setText(currentCustomer.getEmail());
            label6.setVisible(true);

            label7 = new JLabel();
            label7.setBounds(180, 100, 180, 40);
            label7.setBackground(new Color(214, 217, 223));
            label7.setForeground(new Color(0, 0, 0));
            label7.setEnabled(true);
            label7.setFont(new Font("sansserif", 0, 12));
            label7.setText("" + currentCustomer.getBalance());
            label7.setVisible(true);

            label8 = new JLabel();
            label8.setBounds(180, 140, 180, 40);
            label8.setBackground(new Color(214, 217, 223));
            label8.setForeground(new Color(0, 0, 0));
            label8.setEnabled(true);
            label8.setFont(new Font("sansserif", 0, 12));
            label8.setText(currentCustomer.getAddress());
            label8.setVisible(true);

            label9 = new JLabel();
            label9.setBounds(180, 180, 180, 40);
            label9.setBackground(new Color(214, 217, 223));
            label9.setForeground(new Color(0, 0, 0));
            label9.setEnabled(true);
            label9.setFont(new Font("sansserif", 0, 12));
            label9.setText(currentCustomer.getPhone());
            label9.setVisible(true);

            panel1 = new JPanel(null);
            panel1.setBorder(BorderFactory.createEtchedBorder(1));
            panel1.setBounds(-5, -5, 400, 300);
            panel1.setBackground(new Color(214, 217, 223));
            panel1.setForeground(new Color(0, 0, 0));
            panel1.setEnabled(true);
            panel1.setFont(new Font("sansserif", 0, 12));
            panel1.setVisible(true);

            changePassButton = new JButton();
            changePassButton.setBounds(80, 250, 150, 35);
            changePassButton.setBackground(new Color(214, 217, 223));
            changePassButton.setForeground(new Color(0, 0, 0));
            changePassButton.setEnabled(true);
            changePassButton.setFont(new Font("sansserif", 0, 12));
            changePassButton.setText("Change Password");
            changePassButton.setVisible(true);
            changePassButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    new GUI_changePassword();
                }

            });


            closeButton = new JButton();
            closeButton.setBounds(230, 250, 90, 35);
            closeButton.setBackground(new Color(214, 217, 223));
            closeButton.setForeground(new Color(0, 0, 0));
            closeButton.setEnabled(true);
            closeButton.setFont(new Font("sansserif", 0, 12));
            closeButton.setText("Close");
            closeButton.setVisible(true);
            closeButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            dispose();
                        }
                    });
                }
            });

            //adding components to contentPane panel
            panel1.add(label1);
            panel1.add(label2);
            panel1.add(label3);
            panel1.add(label4);
            panel1.add(label5);
            panel1.add(label6);
            panel1.add(label7);
            panel1.add(label8);
            panel1.add(label9);
            panel1.add(closeButton);
            panel1.add(changePassButton);
            contentPane.add(panel1);

            //adding panel to JFrame and seting of window position and close operation
            this.add(contentPane);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }

}


