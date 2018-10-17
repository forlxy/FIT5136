
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Write a description of class MainInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CartUI
{
    private static String[] tableColumn = {"ID", "Name", "FoodType", "Price", "Shelf Life"
            , "Start Date", "Discount Rate", "Sell Type", "Number of Product"};

    private ListSelectionListener listSelectionListener;
    private JFrame mfvs;
    private JPanel buttonPanel;
    private JPanel bottomPanel;
    private JTable productTable;
    private DefaultTableModel defaultTableModel;

    private JButton loginButton;
    private JButton registerButton;
    private JButton searchButton;
    private JButton addButton;
    private JButton editButton;
    private JButton checkButton;
    private JButton cartButton;

    private Dialog loginDialog;
    private Dialog registerDialog;
    private Dialog searchProductDialog;
    private Dialog addProductDialog;
    private Dialog editProductDialog;
    private Dialog checkStorageDialog;
    private Dialog cartDialog;

    public CartUI()
    {
        mfvs = new JFrame("MFVS");

        buttonPanel = new JPanel();
        bottomPanel = new JPanel();
        productTable = new JTable(new DefaultTableModel(tableColumn, 20) ){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };


        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        searchButton = new JButton("SearchProduct");
        addButton = new JButton("AddProduct");
        editButton = new JButton("EditProduct");
        checkButton = new JButton("CheckStorage");
        cartButton = new JButton("Cart");

        loginDialog = new Dialog(mfvs, true);
        registerDialog = new Dialog(mfvs, true);
        searchProductDialog = new Dialog(mfvs, true);
        addProductDialog = new Dialog(mfvs, true);
        editProductDialog = new Dialog(mfvs, true);
        checkStorageDialog = new Dialog(mfvs, true);
        cartDialog = new Dialog(mfvs, true);
    }

    public void init()
    {
        mfvs.setBounds(400,250,800,400);
        loginDialog.setBounds(300, 300, 200, 170);
        registerDialog.setBounds(300, 300, 200, 170);
        searchProductDialog.setBounds(300, 300, 200, 170);
        addProductDialog.setBounds(300, 300, 200, 170);
        editProductDialog.setBounds(300, 300, 200, 170);
        checkStorageDialog.setBounds(300, 300, 200, 170);
        cartDialog.setBounds(300, 300, 200, 170);

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(cartButton);

        bottomPanel.add(new JButton("AAAAAAAAAA"));

        loginButton.addActionListener(e -> loginDialog.setVisible(true));
        registerButton.addActionListener(e -> registerDialog.setVisible(true));
        searchButton.addActionListener(e -> searchProductDialog.setVisible(true));
        addButton.addActionListener(e -> addProductDialog.setVisible(true));
        editButton.addActionListener(e -> editProductDialog.setVisible(true));
        checkButton.addActionListener(e -> checkStorageDialog.setVisible(true));
        cartButton.addActionListener(e -> cartDialog.setVisible(true));

        mfvs.setLayout(new BorderLayout());
        mfvs.add(buttonPanel, BorderLayout.NORTH);
        mfvs.add(new JScrollPane(productTable), BorderLayout.CENTER);
        mfvs.add(bottomPanel, BorderLayout.SOUTH);

        //mfvs.pack();
        mfvs.setVisible(true);
    }

    class loginListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }

}


