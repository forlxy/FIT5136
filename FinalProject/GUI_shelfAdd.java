/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


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
	private JLabel shelf__label;
	private JTextField shelf_discountRate_ltextfield;
	private JPanel shelf_id_pannel;
	private JTextField shelf_id_textfield;
	private JTextField shelf_name_textfield;
	private JTextField shelf_price_textfield4;
	private JTextField shelf_productNumber_textfield;
	private JTextField shelf_sellType_textfield;
	private JTextField shelf_shelfLife_textfield;
	private JTextField shelf_startDate_textfield;
	private JTextField shelf_type_textfield;

	//Constructor 
	public GUI_shelfAdd(){

		this.setTitle("GUI_shelfAdd");
		this.setSize(533,504);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(533,504));
		contentPane.setBackground(new Color(192,192,192));


		addToShelf_product_id_label = new JLabel();
		addToShelf_product_id_label.setBounds(74,42,90,35);
		addToShelf_product_id_label.setBackground(new Color(214,217,223));
		addToShelf_product_id_label.setForeground(new Color(0,0,0));
		addToShelf_product_id_label.setEnabled(true);
		addToShelf_product_id_label.setFont(new Font("sansserif",0,12));
		addToShelf_product_id_label.setText("ID:");
		addToShelf_product_id_label.setVisible(true);

		shelfAdd_cancel_button = new JButton();
		shelfAdd_cancel_button.setBounds(177,409,90,35);
		shelfAdd_cancel_button.setBackground(new Color(214,217,223));
		shelfAdd_cancel_button.setForeground(new Color(0,0,0));
		shelfAdd_cancel_button.setEnabled(true);
		shelfAdd_cancel_button.setFont(new Font("sansserif",0,12));
		shelfAdd_cancel_button.setText("Cancel");
		shelfAdd_cancel_button.setVisible(true);

		shelfAdd_confirm_button = new JButton();
		shelfAdd_confirm_button.setBounds(50,409,90,35);
		shelfAdd_confirm_button.setBackground(new Color(214,217,223));
		shelfAdd_confirm_button.setForeground(new Color(0,0,0));
		shelfAdd_confirm_button.setEnabled(true);
		shelfAdd_confirm_button.setFont(new Font("sansserif",0,12));
		shelfAdd_confirm_button.setText("Confirm");
		shelfAdd_confirm_button.setVisible(true);

		shelfAdd_discountRate_label = new JLabel();
		shelfAdd_discountRate_label.setBounds(74,282,90,35);
		shelfAdd_discountRate_label.setBackground(new Color(214,217,223));
		shelfAdd_discountRate_label.setForeground(new Color(0,0,0));
		shelfAdd_discountRate_label.setEnabled(true);
		shelfAdd_discountRate_label.setFont(new Font("sansserif",0,12));
		shelfAdd_discountRate_label.setText("Discount Rate:");
		shelfAdd_discountRate_label.setVisible(true);

		shelfAdd_name_label = new JLabel();
		shelfAdd_name_label.setBounds(74,82,90,35);
		shelfAdd_name_label.setBackground(new Color(214,217,223));
		shelfAdd_name_label.setForeground(new Color(0,0,0));
		shelfAdd_name_label.setEnabled(true);
		shelfAdd_name_label.setFont(new Font("sansserif",0,12));
		shelfAdd_name_label.setText("Name:");
		shelfAdd_name_label.setVisible(true);

		shelfAdd_number_label = new JLabel();
		shelfAdd_number_label.setBounds(74,362,90,29);
		shelfAdd_number_label.setBackground(new Color(214,217,223));
		shelfAdd_number_label.setForeground(new Color(0,0,0));
		shelfAdd_number_label.setEnabled(true);
		shelfAdd_number_label.setFont(new Font("sansserif",0,12));
		shelfAdd_number_label.setText("Number:");
		shelfAdd_number_label.setVisible(true);

		shelfAdd_price_label = new JLabel();
		shelfAdd_price_label.setBounds(74,162,90,35);
		shelfAdd_price_label.setBackground(new Color(214,217,223));
		shelfAdd_price_label.setForeground(new Color(0,0,0));
		shelfAdd_price_label.setEnabled(true);
		shelfAdd_price_label.setFont(new Font("sansserif",0,12));
		shelfAdd_price_label.setText("Price:");
		shelfAdd_price_label.setVisible(true);

		shelfAdd_sellType_label = new JLabel();
		shelfAdd_sellType_label.setBounds(74,322,90,35);
		shelfAdd_sellType_label.setBackground(new Color(214,217,223));
		shelfAdd_sellType_label.setForeground(new Color(0,0,0));
		shelfAdd_sellType_label.setEnabled(true);
		shelfAdd_sellType_label.setFont(new Font("sansserif",0,12));
		shelfAdd_sellType_label.setText("Sell Type:");
		shelfAdd_sellType_label.setVisible(true);

		shelfAdd_shelfLife_label = new JLabel();
		shelfAdd_shelfLife_label.setBounds(74,202,90,35);
		shelfAdd_shelfLife_label.setBackground(new Color(214,217,223));
		shelfAdd_shelfLife_label.setForeground(new Color(0,0,0));
		shelfAdd_shelfLife_label.setEnabled(true);
		shelfAdd_shelfLife_label.setFont(new Font("sansserif",0,12));
		shelfAdd_shelfLife_label.setText("ShelfLife:");
		shelfAdd_shelfLife_label.setVisible(true);

		shelfAdd_startDate_label = new JLabel();
		shelfAdd_startDate_label.setBounds(74,242,90,35);
		shelfAdd_startDate_label.setBackground(new Color(214,217,223));
		shelfAdd_startDate_label.setForeground(new Color(0,0,0));
		shelfAdd_startDate_label.setEnabled(true);
		shelfAdd_startDate_label.setFont(new Font("sansserif",0,12));
		shelfAdd_startDate_label.setText("Start Date:");
		shelfAdd_startDate_label.setVisible(true);

		shelfAdd_title_label = new JLabel();
		shelfAdd_title_label.setBounds(96,5,220,35);
		shelfAdd_title_label.setBackground(new Color(214,217,223));
		shelfAdd_title_label.setForeground(new Color(0,0,0));
		shelfAdd_title_label.setEnabled(true);
		shelfAdd_title_label.setFont(new Font("SansSerif",0,20));
		shelfAdd_title_label.setText("Add Product");
		shelfAdd_title_label.setVisible(true);

		shelf__label = new JLabel();
		shelf__label.setBounds(74,122,90,35);
		shelf__label.setBackground(new Color(214,217,223));
		shelf__label.setForeground(new Color(0,0,0));
		shelf__label.setEnabled(true);
		shelf__label.setFont(new Font("sansserif",0,12));
		shelf__label.setText("Type:");
		shelf__label.setVisible(true);

		shelf_discountRate_ltextfield = new JTextField();
		shelf_discountRate_ltextfield.setBounds(163,282,90,35);
		shelf_discountRate_ltextfield.setBackground(new Color(255,255,255));
		shelf_discountRate_ltextfield.setForeground(new Color(0,0,0));
		shelf_discountRate_ltextfield.setEnabled(true);
		shelf_discountRate_ltextfield.setFont(new Font("sansserif",0,12));
		shelf_discountRate_ltextfield.setText("");
		shelf_discountRate_ltextfield.setVisible(true);

		shelf_id_pannel = new JPanel(null);
		shelf_id_pannel.setBorder(BorderFactory.createEtchedBorder(1));
		shelf_id_pannel.setBounds(81,9,322,474);
		shelf_id_pannel.setBackground(new Color(214,217,223));
		shelf_id_pannel.setForeground(new Color(0,0,0));
		shelf_id_pannel.setEnabled(true);
		shelf_id_pannel.setFont(new Font("sansserif",0,12));
		shelf_id_pannel.setVisible(true);

		shelf_id_textfield = new JTextField();
		shelf_id_textfield.setBounds(163,42,90,35);
		shelf_id_textfield.setBackground(new Color(255,255,255));
		shelf_id_textfield.setForeground(new Color(0,0,0));
		shelf_id_textfield.setEnabled(true);
		shelf_id_textfield.setFont(new Font("sansserif",0,12));
		shelf_id_textfield.setText("");
		shelf_id_textfield.setVisible(true);

		shelf_name_textfield = new JTextField();
		shelf_name_textfield.setBounds(163,82,90,35);
		shelf_name_textfield.setBackground(new Color(255,255,255));
		shelf_name_textfield.setForeground(new Color(0,0,0));
		shelf_name_textfield.setEnabled(true);
		shelf_name_textfield.setFont(new Font("sansserif",0,12));
		shelf_name_textfield.setText("");
		shelf_name_textfield.setVisible(true);

		shelf_price_textfield4 = new JTextField();
		shelf_price_textfield4.setBounds(163,162,90,35);
		shelf_price_textfield4.setBackground(new Color(255,255,255));
		shelf_price_textfield4.setForeground(new Color(0,0,0));
		shelf_price_textfield4.setEnabled(true);
		shelf_price_textfield4.setFont(new Font("sansserif",0,12));
		shelf_price_textfield4.setText("");
		shelf_price_textfield4.setVisible(true);

		shelf_productNumber_textfield = new JTextField();
		shelf_productNumber_textfield.setBounds(163,362,90,35);
		shelf_productNumber_textfield.setBackground(new Color(255,255,255));
		shelf_productNumber_textfield.setForeground(new Color(0,0,0));
		shelf_productNumber_textfield.setEnabled(true);
		shelf_productNumber_textfield.setFont(new Font("sansserif",0,12));
		shelf_productNumber_textfield.setText("");
		shelf_productNumber_textfield.setVisible(true);

		shelf_sellType_textfield = new JTextField();
		shelf_sellType_textfield.setBounds(163,322,90,35);
		shelf_sellType_textfield.setBackground(new Color(255,255,255));
		shelf_sellType_textfield.setForeground(new Color(0,0,0));
		shelf_sellType_textfield.setEnabled(true);
		shelf_sellType_textfield.setFont(new Font("sansserif",0,12));
		shelf_sellType_textfield.setText("");
		shelf_sellType_textfield.setVisible(true);

		shelf_shelfLife_textfield = new JTextField();
		shelf_shelfLife_textfield.setBounds(163,202,90,35);
		shelf_shelfLife_textfield.setBackground(new Color(255,255,255));
		shelf_shelfLife_textfield.setForeground(new Color(0,0,0));
		shelf_shelfLife_textfield.setEnabled(true);
		shelf_shelfLife_textfield.setFont(new Font("sansserif",0,12));
		shelf_shelfLife_textfield.setText("");
		shelf_shelfLife_textfield.setVisible(true);

		shelf_startDate_textfield = new JTextField();
		shelf_startDate_textfield.setBounds(163,242,90,35);
		shelf_startDate_textfield.setBackground(new Color(255,255,255));
		shelf_startDate_textfield.setForeground(new Color(0,0,0));
		shelf_startDate_textfield.setEnabled(true);
		shelf_startDate_textfield.setFont(new Font("sansserif",0,12));
		shelf_startDate_textfield.setText("");
		shelf_startDate_textfield.setVisible(true);

		shelf_type_textfield = new JTextField();
		shelf_type_textfield.setBounds(163,122,90,35);
		shelf_type_textfield.setBackground(new Color(255,255,255));
		shelf_type_textfield.setForeground(new Color(0,0,0));
		shelf_type_textfield.setEnabled(true);
		shelf_type_textfield.setFont(new Font("sansserif",0,12));
		shelf_type_textfield.setText("");
		shelf_type_textfield.setVisible(true);

		//adding components to contentPane panel
		shelfAdd_pannel.add(addToShelf_product_id_label);
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
		shelfAdd_pannel.add(shelf__label);
		shelfAdd_pannel.add(shelf_discountRate_ltextfield);
		contentPane.add(shelf_id_pannel);
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



	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI_shelfAdd();
			}
		});
	}

}