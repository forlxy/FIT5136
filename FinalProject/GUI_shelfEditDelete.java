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


public class GUI_shelfEditDelete extends JFrame {

	private JMenuBar menuBar;
	private JLabel addToShelf_product_id_label;
	private JButton shelfAdd_edit_button;
	private JButton shelfEditDelete_cancel_button;
	private JButton shelfEditDelete_confirm_button;
	private JLabel shelfEditDelete_discountRate_label;
	private JTextField shelfEditDelete_discountRate_ltextfield;
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
	private JLabel shelf__label;
	private JPanel shelf_id_pannel;
	private JTextField shelf_price_textfield4;

	//Constructor 
	public GUI_shelfEditDelete(){

		this.setTitle("GUI_shelfEditDelete");
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

		shelfAdd_edit_button = new JButton();
		shelfAdd_edit_button.setBounds(122,419,75,35);
		shelfAdd_edit_button.setBackground(new Color(214,217,223));
		shelfAdd_edit_button.setForeground(new Color(0,0,0));
		shelfAdd_edit_button.setEnabled(true);
		shelfAdd_edit_button.setFont(new Font("sansserif",0,12));
		shelfAdd_edit_button.setText("Delete");
		shelfAdd_edit_button.setVisible(true);

		shelfEditDelete_cancel_button = new JButton();
		shelfEditDelete_cancel_button.setBounds(213,419,75,35);
		shelfEditDelete_cancel_button.setBackground(new Color(214,217,223));
		shelfEditDelete_cancel_button.setForeground(new Color(0,0,0));
		shelfEditDelete_cancel_button.setEnabled(true);
		shelfEditDelete_cancel_button.setFont(new Font("sansserif",0,12));
		shelfEditDelete_cancel_button.setText("Cancel");
		shelfEditDelete_cancel_button.setVisible(true);

		shelfEditDelete_confirm_button = new JButton();
		shelfEditDelete_confirm_button.setBounds(33,419,75,35);
		shelfEditDelete_confirm_button.setBackground(new Color(214,217,223));
		shelfEditDelete_confirm_button.setForeground(new Color(0,0,0));
		shelfEditDelete_confirm_button.setEnabled(true);
		shelfEditDelete_confirm_button.setFont(new Font("sansserif",0,12));
		shelfEditDelete_confirm_button.setText("Confirm");
		shelfEditDelete_confirm_button.setVisible(true);

		shelfEditDelete_discountRate_label = new JLabel();
		shelfEditDelete_discountRate_label.setBounds(74,282,90,35);
		shelfEditDelete_discountRate_label.setBackground(new Color(214,217,223));
		shelfEditDelete_discountRate_label.setForeground(new Color(0,0,0));
		shelfEditDelete_discountRate_label.setEnabled(true);
		shelfEditDelete_discountRate_label.setFont(new Font("sansserif",0,12));
		shelfEditDelete_discountRate_label.setText("Discount Rate:");
		shelfEditDelete_discountRate_label.setVisible(true);

		shelfEditDelete_discountRate_ltextfield = new JTextField();
		shelfEditDelete_discountRate_ltextfield.setBounds(163,282,90,35);
		shelfEditDelete_discountRate_ltextfield.setBackground(new Color(255,255,255));
		shelfEditDelete_discountRate_ltextfield.setForeground(new Color(0,0,0));
		shelfEditDelete_discountRate_ltextfield.setEnabled(true);
		shelfEditDelete_discountRate_ltextfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_discountRate_ltextfield.setText("");
		shelfEditDelete_discountRate_ltextfield.setVisible(true);

		shelfEditDelete_id_textfield = new JTextField();
		shelfEditDelete_id_textfield.setBounds(163,42,90,35);
		shelfEditDelete_id_textfield.setBackground(new Color(255,255,255));
		shelfEditDelete_id_textfield.setForeground(new Color(0,0,0));
		shelfEditDelete_id_textfield.setEnabled(true);
		shelfEditDelete_id_textfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_id_textfield.setText("");
		shelfEditDelete_id_textfield.setVisible(true);

		shelfEditDelete_name_label = new JLabel();
		shelfEditDelete_name_label.setBounds(74,82,90,35);
		shelfEditDelete_name_label.setBackground(new Color(214,217,223));
		shelfEditDelete_name_label.setForeground(new Color(0,0,0));
		shelfEditDelete_name_label.setEnabled(true);
		shelfEditDelete_name_label.setFont(new Font("sansserif",0,12));
		shelfEditDelete_name_label.setText("Name:");
		shelfEditDelete_name_label.setVisible(true);

		shelfEditDelete_name_textfield = new JTextField();
		shelfEditDelete_name_textfield.setBounds(163,82,90,35);
		shelfEditDelete_name_textfield.setBackground(new Color(255,255,255));
		shelfEditDelete_name_textfield.setForeground(new Color(0,0,0));
		shelfEditDelete_name_textfield.setEnabled(true);
		shelfEditDelete_name_textfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_name_textfield.setText("");
		shelfEditDelete_name_textfield.setVisible(true);

		shelfEditDelete_number_label = new JLabel();
		shelfEditDelete_number_label.setBounds(74,362,90,29);
		shelfEditDelete_number_label.setBackground(new Color(214,217,223));
		shelfEditDelete_number_label.setForeground(new Color(0,0,0));
		shelfEditDelete_number_label.setEnabled(true);
		shelfEditDelete_number_label.setFont(new Font("sansserif",0,12));
		shelfEditDelete_number_label.setText("Number:");
		shelfEditDelete_number_label.setVisible(true);

		shelfEditDelete_number_textfield = new JTextField();
		shelfEditDelete_number_textfield.setBounds(163,361,90,35);
		shelfEditDelete_number_textfield.setBackground(new Color(255,255,255));
		shelfEditDelete_number_textfield.setForeground(new Color(0,0,0));
		shelfEditDelete_number_textfield.setEnabled(true);
		shelfEditDelete_number_textfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_number_textfield.setText("");
		shelfEditDelete_number_textfield.setVisible(true);

		shelfEditDelete_price_label = new JLabel();
		shelfEditDelete_price_label.setBounds(74,162,90,35);
		shelfEditDelete_price_label.setBackground(new Color(214,217,223));
		shelfEditDelete_price_label.setForeground(new Color(0,0,0));
		shelfEditDelete_price_label.setEnabled(true);
		shelfEditDelete_price_label.setFont(new Font("sansserif",0,12));
		shelfEditDelete_price_label.setText("Price:");
		shelfEditDelete_price_label.setVisible(true);

		shelfEditDelete_sellType_label = new JLabel();
		shelfEditDelete_sellType_label.setBounds(74,322,90,35);
		shelfEditDelete_sellType_label.setBackground(new Color(214,217,223));
		shelfEditDelete_sellType_label.setForeground(new Color(0,0,0));
		shelfEditDelete_sellType_label.setEnabled(true);
		shelfEditDelete_sellType_label.setFont(new Font("sansserif",0,12));
		shelfEditDelete_sellType_label.setText("Sell Type:");
		shelfEditDelete_sellType_label.setVisible(true);

		shelfEditDelete_sellType_textfield = new JTextField();
		shelfEditDelete_sellType_textfield.setBounds(163,322,90,35);
		shelfEditDelete_sellType_textfield.setBackground(new Color(255,255,255));
		shelfEditDelete_sellType_textfield.setForeground(new Color(0,0,0));
		shelfEditDelete_sellType_textfield.setEnabled(true);
		shelfEditDelete_sellType_textfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_sellType_textfield.setText("");
		shelfEditDelete_sellType_textfield.setVisible(true);

		shelfEditDelete_shelfLife_label = new JLabel();
		shelfEditDelete_shelfLife_label.setBounds(74,202,90,35);
		shelfEditDelete_shelfLife_label.setBackground(new Color(214,217,223));
		shelfEditDelete_shelfLife_label.setForeground(new Color(0,0,0));
		shelfEditDelete_shelfLife_label.setEnabled(true);
		shelfEditDelete_shelfLife_label.setFont(new Font("sansserif",0,12));
		shelfEditDelete_shelfLife_label.setText("ShelfLife:");
		shelfEditDelete_shelfLife_label.setVisible(true);

		shelfEditDelete_shelfLife_textfield = new JTextField();
		shelfEditDelete_shelfLife_textfield.setBounds(163,202,90,35);
		shelfEditDelete_shelfLife_textfield.setBackground(new Color(255,255,255));
		shelfEditDelete_shelfLife_textfield.setForeground(new Color(0,0,0));
		shelfEditDelete_shelfLife_textfield.setEnabled(true);
		shelfEditDelete_shelfLife_textfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_shelfLife_textfield.setText("");
		shelfEditDelete_shelfLife_textfield.setVisible(true);

		shelfEditDelete_startDate_label = new JLabel();
		shelfEditDelete_startDate_label.setBounds(74,242,90,35);
		shelfEditDelete_startDate_label.setBackground(new Color(214,217,223));
		shelfEditDelete_startDate_label.setForeground(new Color(0,0,0));
		shelfEditDelete_startDate_label.setEnabled(true);
		shelfEditDelete_startDate_label.setFont(new Font("sansserif",0,12));
		shelfEditDelete_startDate_label.setText("Start Date:");
		shelfEditDelete_startDate_label.setVisible(true);

		shelfEditDelete_startDate_textfield = new JTextField();
		shelfEditDelete_startDate_textfield.setBounds(163,242,90,35);
		shelfEditDelete_startDate_textfield.setBackground(new Color(255,255,255));
		shelfEditDelete_startDate_textfield.setForeground(new Color(0,0,0));
		shelfEditDelete_startDate_textfield.setEnabled(true);
		shelfEditDelete_startDate_textfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_startDate_textfield.setText("");
		shelfEditDelete_startDate_textfield.setVisible(true);

		shelfEditDelete_title_label = new JLabel();
		shelfEditDelete_title_label.setBounds(69,5,220,35);
		shelfEditDelete_title_label.setBackground(new Color(214,217,223));
		shelfEditDelete_title_label.setForeground(new Color(0,0,0));
		shelfEditDelete_title_label.setEnabled(true);
		shelfEditDelete_title_label.setFont(new Font("SansSerif",0,20));
		shelfEditDelete_title_label.setText("Edit/Delete Product");
		shelfEditDelete_title_label.setVisible(true);

		shelfEditDelete_type_textfield = new JTextField();
		shelfEditDelete_type_textfield.setBounds(163,122,90,35);
		shelfEditDelete_type_textfield.setBackground(new Color(255,255,255));
		shelfEditDelete_type_textfield.setForeground(new Color(0,0,0));
		shelfEditDelete_type_textfield.setEnabled(true);
		shelfEditDelete_type_textfield.setFont(new Font("sansserif",0,12));
		shelfEditDelete_type_textfield.setText("");
		shelfEditDelete_type_textfield.setVisible(true);

		shelf__label = new JLabel();
		shelf__label.setBounds(74,122,90,35);
		shelf__label.setBackground(new Color(214,217,223));
		shelf__label.setForeground(new Color(0,0,0));
		shelf__label.setEnabled(true);
		shelf__label.setFont(new Font("sansserif",0,12));
		shelf__label.setText("Type:");
		shelf__label.setVisible(true);

		shelf_id_pannel = new JPanel(null);
		shelf_id_pannel.setBorder(BorderFactory.createEtchedBorder(1));
		shelf_id_pannel.setBounds(81,9,322,474);
		shelf_id_pannel.setBackground(new Color(214,217,223));
		shelf_id_pannel.setForeground(new Color(0,0,0));
		shelf_id_pannel.setEnabled(true);
		shelf_id_pannel.setFont(new Font("sansserif",0,12));
		shelf_id_pannel.setVisible(true);

		shelf_price_textfield4 = new JTextField();
		shelf_price_textfield4.setBounds(163,162,90,35);
		shelf_price_textfield4.setBackground(new Color(255,255,255));
		shelf_price_textfield4.setForeground(new Color(0,0,0));
		shelf_price_textfield4.setEnabled(true);
		shelf_price_textfield4.setFont(new Font("sansserif",0,12));
		shelf_price_textfield4.setText("");
		shelf_price_textfield4.setVisible(true);

		//adding components to contentPane panel
		shelfEditDelete_pannel.add(addToShelf_product_id_label);
		shelfEditDelete_pannel.add(shelfAdd_edit_button);
		shelfEditDelete_pannel.add(shelfEditDelete_cancel_button);
		shelfEditDelete_pannel.add(shelfEditDelete_confirm_button);
		shelfEditDelete_pannel.add(shelfEditDelete_discountRate_label);
		shelfEditDelete_pannel.add(shelfEditDelete_discountRate_ltextfield);
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
		shelfEditDelete_pannel.add(shelf__label);
		contentPane.add(shelf_id_pannel);
		shelfEditDelete_pannel.add(shelf_price_textfield4);

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
				new GUI_shelfEditDelete();
			}
		});
	}

}