
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.security.acl.Owner;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.List;

/**
 * Write a description of class MainInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainInterface
{
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

    public static Customer getCurrentUser(){
        return currentCustomer;
    }

    public MainInterface(Customer user, int state)
    {
        currentCustomer = user;

        mfvs = new JFrame("MFVS");

        try {
            ShelfController.readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonPanel = new JPanel();
        bottomPanel = new JPanel();

        DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 20) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        List<Product> shelf = ShelfController.getShelfProducts();

        for (Product p: shelf){
            Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.discountRate, p.sellType, p.getProductNumber()};

            tableModel.addRow(data);
        }

        productTable = new JTable(tableModel);

        productTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < shelf.size()) {
                    new GUI_addToCart(shelf.get(row)).setVisible(true);
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
        init();
    }

    public void init()
    {
        mfvs.setBounds(400,250,800,400);
//        loginDialog.setBounds(300, 300, 200, 170);
//        registerDialog.setBounds(300, 300, 200, 170);
//        searchProductDialog.setBounds(300, 300, 200, 170);
//        addProductDialog.setBounds(300, 300, 200, 170);
//        editProductDialog.setBounds(300, 300, 200, 170);
//        checkStorageDialog.setBounds(300, 300, 200, 170);
//        cartDialog.setBounds(300, 300, 200, 170);

        buttonPanel.add(searchButton);
        buttonPanel.add(productButton);
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
        productButton.addActionListener(e -> new ManageProductUI(mfvs, true).setVisible(true));
        searchButton.addActionListener(e -> new SearchUI(mfvs, true).setVisible(true));

        cartButton.addActionListener(e -> new CartUI(mfvs, true).setVisible(true));
        orderButton.addActionListener(e -> new OrderUI(mfvs, true).setVisible(true));
        personButton.addActionListener(e -> new OrderUI(mfvs, true).setVisible(true));


        mfvs.setLayout(new BorderLayout());
        mfvs.add(buttonPanel, BorderLayout.NORTH);
        mfvs.add(new JScrollPane(productTable), BorderLayout.CENTER);
        mfvs.add(bottomPanel, BorderLayout.SOUTH);

        //mfvs.pack();
        mfvs.setVisible(true);
    }

    public class CartUI extends JDialog
    {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private ListSelectionListener listSelectionListener;
        private JFrame mfvs;
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

        public CartUI(final JFrame frame, boolean modal)
        {
            super(frame, modal);

            buttonPanel = new JPanel();
            bottomPanel = new JPanel();
            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 20) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            List<Product> cart = CartController.getProductList();

            for (Product p: cart){
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.discountRate, p.sellType, p.getProductNumber()};

                tableModel.addRow(data);
            }

            productTable = new JTable(tableModel);

            productTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table =(JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < cart.size()) {
                        new GUI_editCart(row, cart.get(row)).setVisible(true);
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
            loginDialog = new Dialog(mfvs, true);
            registerDialog = new Dialog(mfvs, true);
            searchProductDialog = new Dialog(mfvs, true);
            addProductDialog = new Dialog(mfvs, true);
            editProductDialog = new Dialog(mfvs, true);
            checkStorageDialog = new Dialog(mfvs, true);
            cartDialog = new Dialog(mfvs, true);
            init();
        }

        public void init()
        {
            setBounds(400,250,800,400);
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


    }



    public class OrderUI extends JDialog
    {
        private String[] tableColumn = {"ID", "Customer", "Time", "Price"};

        private ListSelectionListener listSelectionListener;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable orderTable;

        private JButton closeButton;


        public OrderUI(final JFrame frame, boolean modal)
        {
            super(frame, modal);

            buttonPanel = new JPanel();
            bottomPanel = new JPanel();
            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 20) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            List<Order> orders = TransactionController.viewOrders(getCurrentUser());

            for (Order o: orders){
                Object[] data = {o.getId(), o.getTime(), o.getPaidPrice()};

                tableModel.addRow(data);
            }

            orderTable = new JTable(tableModel);

            orderTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table =(JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < orders.size()) {
                        new OrderProductUI(frame, modal, orders.get(row)).setVisible(true);
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

        public void init()
        {
            setBounds(400,250,800,400);

            bottomPanel.add(closeButton);

            setLayout(new BorderLayout());
            add(buttonPanel, BorderLayout.NORTH);
            add(new JScrollPane(orderTable), BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

        }


    }


    public class OrderProductUI extends JDialog
    {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private ListSelectionListener listSelectionListener;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable productTable;

        private JButton closeButton;


        public OrderProductUI(final JFrame frame, boolean modal, Order order)
        {
            super(frame, modal);

            buttonPanel = new JPanel();
            bottomPanel = new JPanel();

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 20) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            for (Product p : order.getProducts()){
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.discountRate, p.sellType, p.getProductNumber()};

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

        public void init()
        {
            setBounds(400,250,800,400);

            bottomPanel.add(closeButton);

            setLayout(new BorderLayout());
            add(buttonPanel, BorderLayout.NORTH);
            add(new JScrollPane(productTable), BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

        }


    }



    public class ManageProductUI extends JDialog
    {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private ListSelectionListener listSelectionListener;
        private JFrame mfvs;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable productTable;

        private JButton addButton;
        private JButton closeButton;

        private Dialog loginDialog;
        private Dialog registerDialog;
        private Dialog searchProductDialog;
        private Dialog addProductDialog;
        private Dialog editProductDialog;
        private Dialog checkStorageDialog;
        private Dialog cartDialog;

        public ManageProductUI(final JFrame frame, boolean modal)
        {
            super(frame, modal);

            buttonPanel = new JPanel();
            bottomPanel = new JPanel();

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 20) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            List<Product> shelf = ShelfController.getShelfProducts();

            for (Product p: shelf){
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.discountRate, p.sellType, p.getProductNumber()};

                tableModel.addRow(data);
            }

            productTable = new JTable(tableModel);

            productTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table =(JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < shelf.size()) {
//                        new GUI_shelf(row, shelf.get(row)).setVisible(true);
                    }
                }
            });

            addButton = new JButton("Add Product");
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

        public void init()
        {
            setBounds(400,250,800,400);
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


    public class SearchUI extends JDialog
    {
        private String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
                , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

        private ListSelectionListener listSelectionListener;
        private JFrame mfvs;
        private JPanel buttonPanel;
        private JPanel bottomPanel;
        private JTable productTable;

        public List<Product> shelf;

        private JTextField searchTextField;

        private JButton clearButton;
        private JButton closeButton;
        private JButton purchaseButton;
        private JButton searchButton;

        public SearchUI(final JFrame frame, boolean modal)
        {
            super(frame, modal);

            buttonPanel = new JPanel();
            bottomPanel = new JPanel();

            DefaultTableModel tableModel = new DefaultTableModel(tableColumn, 20) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            shelf = ShelfController.getShelfProducts();


            for (Product p: shelf){
                Object[] data = {p.getId(), p.getName(), p.getType(), p.getPrice(), p.getShelfLife(), p.getStartDate(), p.discountRate, p.sellType, p.getProductNumber()};

                tableModel.addRow(data);
            }

            productTable = new JTable(tableModel);

            productTable.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table =(JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row < shelf.size()) {
                        new GUI_addToCart(shelf.get(row)).setVisible(true);
                    }
                }
            });


            searchTextField = new JTextField();

            
            searchTextField.setBounds(144,62,117,31);
            
            clearButton = new JButton("Clear");
            closeButton = new JButton("Close");
            purchaseButton = new JButton("Purchase");
            searchButton = new JButton("Search");

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                }
            });

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    shelf = ShelfController.searchProduct(searchTextField.getText());
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

        public void init()
        {
            setBounds(400,250,800,400);

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
        public GUI_addToCart(Product product){

            this.setTitle("GUI_addToCart");
            this.setSize(500,400);
            //menu generate method
            generateMenu();
            this.setJMenuBar(menuBar);

            //pane with null layout
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(500,400));
            contentPane.setBackground(new Color(192,192,192));


            addToCart_panel = new JPanel(null);
            addToCart_panel.setBorder(BorderFactory.createEtchedBorder(1));
            addToCart_panel.setBounds(104,66,303,170);
            addToCart_panel.setBackground(new Color(214,217,223));
            addToCart_panel.setForeground(new Color(0,0,0));
            addToCart_panel.setEnabled(true);
            addToCart_panel.setFont(new Font("sansserif",0,12));
            addToCart_panel.setVisible(true);

            addToCart_title_label = new JLabel();
            addToCart_title_label.setBounds(94,13,118,31);
            addToCart_title_label.setBackground(new Color(214,217,223));
            addToCart_title_label.setForeground(new Color(0,0,0));
            addToCart_title_label.setEnabled(true);
            addToCart_title_label.setFont(new Font("SansSerif",0,17));
            addToCart_title_label.setText("Add To Cart");
            addToCart_title_label.setVisible(true);

            addToCart_add_button = new JButton();
            addToCart_add_button.setBounds(36,109,90,35);
            addToCart_add_button.setBackground(new Color(214,217,223));
            addToCart_add_button.setForeground(new Color(0,0,0));
            addToCart_add_button.setEnabled(true);
            addToCart_add_button.setFont(new Font("sansserif",0,12));
            addToCart_add_button.setText("Add");
            addToCart_add_button.setVisible(true);

            addToCart_cancel_button = new JButton();
            addToCart_cancel_button.setBounds(167,109,90,35);
            addToCart_cancel_button.setBackground(new Color(214,217,223));
            addToCart_cancel_button.setForeground(new Color(0,0,0));
            addToCart_cancel_button.setEnabled(true);
            addToCart_cancel_button.setFont(new Font("sansserif",0,12));
            addToCart_cancel_button.setText("Cancel");
            addToCart_cancel_button.setVisible(true);

            addToCart_number_label = new JLabel();
            addToCart_number_label.setBounds(57,61,90,35);
            addToCart_number_label.setBackground(new Color(214,217,223));
            addToCart_number_label.setForeground(new Color(0,0,0));
            addToCart_number_label.setEnabled(true);
            addToCart_number_label.setFont(new Font("SansSerif",0,12));
            addToCart_number_label.setText("Number:");
            addToCart_number_label.setVisible(true);

            addToCart_number_textfield = new JTextField();
            addToCart_number_textfield.setBounds(144,62,117,31);
            addToCart_number_textfield.setBackground(new Color(255,255,255));
            addToCart_number_textfield.setForeground(new Color(0,0,0));
            addToCart_number_textfield.setEnabled(true);
            addToCart_number_textfield.setFont(new Font("sansserif",0,12));
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
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }

        //method for generate menu
        public void generateMenu(){
            menuBar = new JMenuBar();

            JMenu file = new JMenu("File");
            JMenu tools = new JMenu("Tools");
            JMenu help = new JMenu("Help");

            JMenuItem open = new JMenuItem("Open   ");
            JMenuItem save = new JMenuItem("Save   ");
            JMenuItem exit = new JMenuItem("Exit   ");
            JMenuItem preferences = new JMenuItem("Preferences   ");
            JMenuItem about = new JMenuItem("About   ");


            file.add(open);
            file.add(save);
            file.addSeparator();
            file.add(exit);
            tools.add(preferences);
            help.add(about);

            menuBar.add(file);
            menuBar.add(tools);
            menuBar.add(help);
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

        //Constructor
        public GUI_editCart(int row, Product product){

            this.setTitle("GUI_editCart");
            this.setSize(500,400);
            //menu generate method
            generateMenu();
            this.setJMenuBar(menuBar);

            //pane with null layout
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(500,400));
            contentPane.setBackground(new Color(192,192,192));


            editCart_add_button = new JButton();
            editCart_add_button.setBounds(28,105,67,35);
            editCart_add_button.setBackground(new Color(214,217,223));
            editCart_add_button.setForeground(new Color(0,0,0));
            editCart_add_button.setEnabled(true);
            editCart_add_button.setFont(new Font("sansserif",0,12));
            editCart_add_button.setText("Edit");
            editCart_add_button.setVisible(true);


            editCart_cancel_button = new JButton();
            editCart_cancel_button.setBounds(200,105,67,35);
            editCart_cancel_button.setBackground(new Color(214,217,223));
            editCart_cancel_button.setForeground(new Color(0,0,0));
            editCart_cancel_button.setEnabled(true);
            editCart_cancel_button.setFont(new Font("sansserif",0,12));
            editCart_cancel_button.setText("Cancel");
            editCart_cancel_button.setVisible(true);


            editCart_delete_button = new JButton();
            editCart_delete_button.setBounds(116,105,67,35);
            editCart_delete_button.setBackground(new Color(214,217,223));
            editCart_delete_button.setForeground(new Color(0,0,0));
            editCart_delete_button.setEnabled(true);
            editCart_delete_button.setFont(new Font("sansserif",0,12));
            editCart_delete_button.setText("Delete");
            editCart_delete_button.setVisible(true);

            editCart_number_label = new JLabel();
            editCart_number_label.setBounds(44,47,77,31);
            editCart_number_label.setBackground(new Color(214,217,223));
            editCart_number_label.setForeground(new Color(0,0,0));
            editCart_number_label.setEnabled(true);
            editCart_number_label.setFont(new Font("SansSerif",0,12));
            editCart_number_label.setText("Number:");
            editCart_number_label.setVisible(true);

            editCart_number_textfield = new JTextField();
            editCart_number_textfield.setBounds(140,47,117,31);
            editCart_number_textfield.setBackground(new Color(255,255,255));
            editCart_number_textfield.setForeground(new Color(0,0,0));
            editCart_number_textfield.setEnabled(true);
            editCart_number_textfield.setFont(new Font("sansserif",0,12));
            editCart_number_textfield.setText("" + product.getProductNumber());
            editCart_number_textfield.setVisible(true);

            editCart_panel = new JPanel(null);
            editCart_panel.setBorder(BorderFactory.createEtchedBorder(1));
            editCart_panel.setBounds(99,65,294,163);
            editCart_panel.setBackground(new Color(214,217,223));
            editCart_panel.setForeground(new Color(0,0,0));
            editCart_panel.setEnabled(true);
            editCart_panel.setFont(new Font("sansserif",0,12));
            editCart_panel.setVisible(true);

            editCart_title = new JLabel();
            editCart_title.setBounds(117,10,104,28);
            editCart_title.setBackground(new Color(214,217,223));
            editCart_title.setForeground(new Color(0,0,0));
            editCart_title.setEnabled(true);
            editCart_title.setFont(new Font("SansSerif",0,17));
            editCart_title.setText("Edit");
            editCart_title.setVisible(true);


            editCart_add_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    CartController.updateCart(row, Integer.parseInt(editCart_number_textfield.getText()));
                    dispose();
                }
            });
            editCart_delete_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    CartController.removeItem(row);
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
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }

        //method for generate menu
        public void generateMenu(){
            menuBar = new JMenuBar();

            JMenu file = new JMenu("File");
            JMenu tools = new JMenu("Tools");
            JMenu help = new JMenu("Help");

            JMenuItem open = new JMenuItem("Open   ");
            JMenuItem save = new JMenuItem("Save   ");
            JMenuItem exit = new JMenuItem("Exit   ");
            JMenuItem preferences = new JMenuItem("Preferences   ");
            JMenuItem about = new JMenuItem("About   ");


            file.add(open);
            file.add(save);
            file.addSeparator();
            file.add(exit);
            tools.add(preferences);
            help.add(about);

            menuBar.add(file);
            menuBar.add(tools);
            menuBar.add(help);
        }


    }
}


