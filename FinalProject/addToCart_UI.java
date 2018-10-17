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


public class GUI_addToCart extends JFrame {

	private JMenuBar menuBar;
	private JPanel addToCart_panel;
	private JLabel addToCart_title_label;
	private JButton addToCart_add_button;
	private JButton addToCart_cancel_button;
	private JLabel addToCart_number_label;
	private JTextField addToCart_number_textfield;

	//Constructor 
	public GUI_addToCart(){

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
		addToCart_panel.add(addToCart_title);
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



	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI_addToCart();
			}
		});
	}

}