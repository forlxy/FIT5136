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


public class AddproductDialog extends JFrame {

	private JMenuBar menuBar;
	private JButton button1;
	private JButton button2;
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
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;
	private JTextField textfield6;
	private JTextField textfield7;
	private JTextField textfield8;
	private JTextField textfield9;

	//Constructor 
	public AddproductDialog(){

		this.setTitle("GUI_project");
		this.setSize(928,642);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(928,642));
		contentPane.setBackground(new Color(192,192,192));


		button1 = new JButton();
		button1.setBounds(205,277,90,35);
		button1.setBackground(new Color(214,217,223));
		button1.setForeground(new Color(0,0,0));
		button1.setEnabled(true);
		button1.setFont(new Font("sansserif",0,12));
		button1.setText("Confirm");
		button1.setVisible(true);

		button2 = new JButton();
		button2.setBounds(393,278,90,35);
		button2.setBackground(new Color(214,217,223));
		button2.setForeground(new Color(0,0,0));
		button2.setEnabled(true);
		button2.setFont(new Font("sansserif",0,12));
		button2.setText("Cancel");
		button2.setVisible(true);

		label1 = new JLabel();
		label1.setBounds(52,30,90,35);
		label1.setBackground(new Color(214,217,223));
		label1.setForeground(new Color(0,0,0));
		label1.setEnabled(true);
		label1.setFont(new Font("sansserif",0,12));
		label1.setText("ID");
		label1.setVisible(true);

		label2 = new JLabel();
		label2.setBounds(52,75,90,35);
		label2.setBackground(new Color(214,217,223));
		label2.setForeground(new Color(0,0,0));
		label2.setEnabled(true);
		label2.setFont(new Font("sansserif",0,12));
		label2.setText("Name");
		label2.setVisible(true);

		label3 = new JLabel();
		label3.setBounds(302,162,100,35);
		label3.setBackground(new Color(214,217,223));
		label3.setForeground(new Color(0,0,0));
		label3.setEnabled(true);
		label3.setFont(new Font("sansserif",0,12));
		label3.setText("Num of product");
		label3.setVisible(true);

		label4 = new JLabel();
		label4.setBounds(51,117,90,35);
		label4.setBackground(new Color(214,217,223));
		label4.setForeground(new Color(0,0,0));
		label4.setEnabled(true);
		label4.setFont(new Font("sansserif",0,12));
		label4.setText("Type");
		label4.setVisible(true);

		label5 = new JLabel();
		label5.setBounds(49,163,90,35);
		label5.setBackground(new Color(214,217,223));
		label5.setForeground(new Color(0,0,0));
		label5.setEnabled(true);
		label5.setFont(new Font("sansserif",0,12));
		label5.setText("Price");
		label5.setVisible(true);

		label6 = new JLabel();
		label6.setBounds(49,212,90,35);
		label6.setBackground(new Color(214,217,223));
		label6.setForeground(new Color(0,0,0));
		label6.setEnabled(true);
		label6.setFont(new Font("sansserif",0,12));
		label6.setText("ShelfLife");
		label6.setVisible(true);

		label7 = new JLabel();
		label7.setBounds(305,28,90,35);
		label7.setBackground(new Color(214,217,223));
		label7.setForeground(new Color(0,0,0));
		label7.setEnabled(true);
		label7.setFont(new Font("sansserif",0,12));
		label7.setText("StartDate");
		label7.setVisible(true);

		label8 = new JLabel();
		label8.setBounds(305,74,90,35);
		label8.setBackground(new Color(214,217,223));
		label8.setForeground(new Color(0,0,0));
		label8.setEnabled(true);
		label8.setFont(new Font("sansserif",0,12));
		label8.setText("DiscountRate");
		label8.setVisible(true);

		label9 = new JLabel();
		label9.setBounds(305,119,90,35);
		label9.setBackground(new Color(214,217,223));
		label9.setForeground(new Color(0,0,0));
		label9.setEnabled(true);
		label9.setFont(new Font("sansserif",0,12));
		label9.setText("SellType");
		label9.setVisible(true);

		panel1 = new JPanel(null);
		panel1.setBorder(BorderFactory.createEtchedBorder(1));
		panel1.setBounds(86,50,687,369);
		panel1.setBackground(new Color(214,217,223));
		panel1.setForeground(new Color(0,0,0));
		panel1.setEnabled(true);
		panel1.setFont(new Font("sansserif",0,12));
		panel1.setVisible(true);

		textfield1 = new JTextField();
		textfield1.setBounds(126,32,143,33);
		textfield1.setBackground(new Color(255,255,255));
		textfield1.setForeground(new Color(0,0,0));
		textfield1.setEnabled(true);
		textfield1.setFont(new Font("sansserif",0,12));
		textfield1.setText("");
		textfield1.setVisible(true);

		textfield2 = new JTextField();
		textfield2.setBounds(409,27,159,37);
		textfield2.setBackground(new Color(255,255,255));
		textfield2.setForeground(new Color(0,0,0));
		textfield2.setEnabled(true);
		textfield2.setFont(new Font("sansserif",0,12));
		textfield2.setText("JTextField");
		textfield2.setVisible(true);

		textfield3 = new JTextField();
		textfield3.setBounds(125,78,143,34);
		textfield3.setBackground(new Color(255,255,255));
		textfield3.setForeground(new Color(0,0,0));
		textfield3.setEnabled(true);
		textfield3.setFont(new Font("sansserif",0,12));
		textfield3.setText("");
		textfield3.setVisible(true);

		textfield4 = new JTextField();
		textfield4.setBounds(408,72,157,36);
		textfield4.setBackground(new Color(255,255,255));
		textfield4.setForeground(new Color(0,0,0));
		textfield4.setEnabled(true);
		textfield4.setFont(new Font("sansserif",0,12));
		textfield4.setText("JTextField");
		textfield4.setVisible(true);

		textfield5 = new JTextField();
		textfield5.setBounds(125,123,142,34);
		textfield5.setBackground(new Color(255,255,255));
		textfield5.setForeground(new Color(0,0,0));
		textfield5.setEnabled(true);
		textfield5.setFont(new Font("sansserif",0,12));
		textfield5.setText("");
		textfield5.setVisible(true);

		textfield6 = new JTextField();
		textfield6.setBounds(408,120,156,37);
		textfield6.setBackground(new Color(255,255,255));
		textfield6.setForeground(new Color(0,0,0));
		textfield6.setEnabled(true);
		textfield6.setFont(new Font("sansserif",0,12));
		textfield6.setText("JTextField");
		textfield6.setVisible(true);

		textfield7 = new JTextField();
		textfield7.setBounds(125,165,140,33);
		textfield7.setBackground(new Color(255,255,255));
		textfield7.setForeground(new Color(0,0,0));
		textfield7.setEnabled(true);
		textfield7.setFont(new Font("sansserif",0,12));
		textfield7.setText("");
		textfield7.setVisible(true);

		textfield8 = new JTextField();
		textfield8.setBounds(408,165,157,35);
		textfield8.setBackground(new Color(255,255,255));
		textfield8.setForeground(new Color(0,0,0));
		textfield8.setEnabled(true);
		textfield8.setFont(new Font("sansserif",0,12));
		textfield8.setText("JTextField");
		textfield8.setVisible(true);

		textfield9 = new JTextField();
		textfield9.setBounds(126,211,139,37);
		textfield9.setBackground(new Color(255,255,255));
		textfield9.setForeground(new Color(0,0,0));
		textfield9.setEnabled(true);
		textfield9.setFont(new Font("sansserif",0,12));
		textfield9.setText("JTextField");
		textfield9.setVisible(true);

		//adding components to contentPane panel
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel1.add(label7);
		panel1.add(label8);
		panel1.add(label9);
		contentPane.add(panel1);
		panel1.add(textfield1);
		panel1.add(textfield2);
		panel1.add(textfield3);
		panel1.add(textfield4);
		panel1.add(textfield5);
		panel1.add(textfield6);
		panel1.add(textfield7);
		panel1.add(textfield8);
		panel1.add(textfield9);

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