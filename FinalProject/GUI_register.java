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


public class GUI_register extends JFrame {

	private JMenuBar menuBar;
	private JPanel registerPanel;
	private JLabel addressLabel;
	private JTextField addressTextfield;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel label5;
	private JLabel passwordLabel;
	private JTextField passwordTextfield;
	private JLabel phoneLabel;
	private JTextField phoneTextfield;
	private JButton registerButton;
	private JButton returnButton;

	//Constructor 
	public GUI_register(){

		this.setTitle("GUI_register");
		this.setSize(400,500);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(400,500));
		contentPane.setBackground(new Color(192,192,192));


		registerPanel = new JPanel(null);
		registerPanel.setBorder(BorderFactory.createEtchedBorder(1));
		registerPanel.setBounds(-5,-5,400,500);
		registerPanel.setBackground(new Color(214,217,223));
		registerPanel.setForeground(new Color(0,0,0));
		registerPanel.setEnabled(true);
		registerPanel.setFont(new Font("sansserif",0,12));
		registerPanel.setVisible(true);

		addressLabel = new JLabel();
		addressLabel.setBounds(40,240,90,35);
		addressLabel.setBackground(new Color(214,217,223));
		addressLabel.setForeground(new Color(0,0,0));
		addressLabel.setEnabled(true);
		addressLabel.setFont(new Font("sansserif",0,12));
		addressLabel.setText("Address:");
		addressLabel.setVisible(true);

		addressTextfield = new JTextField();
		addressTextfield.setBounds(140,240,200,40);
		addressTextfield.setBackground(new Color(255,255,255));
		addressTextfield.setForeground(new Color(0,0,0));
		addressTextfield.setEnabled(true);
		addressTextfield.setFont(new Font("sansserif",0,12));
		addressTextfield.setText("");
		addressTextfield.setVisible(true);

		emailLabel = new JLabel();
		emailLabel.setBounds(40,80,90,35);
		emailLabel.setBackground(new Color(214,217,223));
		emailLabel.setForeground(new Color(0,0,0));
		emailLabel.setEnabled(true);
		emailLabel.setFont(new Font("sansserif",0,12));
		emailLabel.setText("Email:");
		emailLabel.setVisible(true);

		emailTextField = new JTextField();
		emailTextField.setBounds(140,80,200,40);
		emailTextField.setBackground(new Color(255,255,255));
		emailTextField.setForeground(new Color(0,0,0));
		emailTextField.setEnabled(true);
		emailTextField.setFont(new Font("sansserif",0,12));
		emailTextField.setText("");
		emailTextField.setVisible(true);

		label5 = new JLabel();
		label5.setBounds(115,20,170,40);
		label5.setBackground(new Color(214,217,223));
		label5.setForeground(new Color(0,0,0));
		label5.setEnabled(true);
		label5.setFont(new Font("SansSerif",0,20));
		label5.setText("Register Interface");
		label5.setVisible(true);

		passwordLabel = new JLabel();
		passwordLabel.setBounds(40,160,90,35);
		passwordLabel.setBackground(new Color(214,217,223));
		passwordLabel.setForeground(new Color(0,0,0));
		passwordLabel.setEnabled(true);
		passwordLabel.setFont(new Font("sansserif",0,12));
		passwordLabel.setText("Password:");
		passwordLabel.setVisible(true);

		passwordTextfield = new JTextField();
		passwordTextfield.setBounds(140,160,200,40);
		passwordTextfield.setBackground(new Color(255,255,255));
		passwordTextfield.setForeground(new Color(0,0,0));
		passwordTextfield.setEnabled(true);
		passwordTextfield.setFont(new Font("sansserif",0,12));
		passwordTextfield.setText("");
		passwordTextfield.setVisible(true);

		phoneLabel = new JLabel();
		phoneLabel.setBounds(40,320,90,35);
		phoneLabel.setBackground(new Color(214,217,223));
		phoneLabel.setForeground(new Color(0,0,0));
		phoneLabel.setEnabled(true);
		phoneLabel.setFont(new Font("sansserif",0,12));
		phoneLabel.setText("Phone:");
		phoneLabel.setVisible(true);

		phoneTextfield = new JTextField();
		phoneTextfield.setBounds(140,320,200,40);
		phoneTextfield.setBackground(new Color(255,255,255));
		phoneTextfield.setForeground(new Color(0,0,0));
		phoneTextfield.setEnabled(true);
		phoneTextfield.setFont(new Font("sansserif",0,12));
		phoneTextfield.setText("");
		phoneTextfield.setVisible(true);

		registerButton = new JButton();
		registerButton.setBounds(245,400,90,35);
		registerButton.setBackground(new Color(214,217,223));
		registerButton.setForeground(new Color(0,0,0));
		registerButton.setEnabled(true);
		registerButton.setFont(new Font("sansserif",0,12));
		registerButton.setText("Register");
		registerButton.setVisible(true);
		registerButton.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				
						String address = addressTextfield.getText();
						String phone = phoneTextfield.getText();
						String email = emailTextField.getText();
						String password = passwordTextfield.getText();
						Customer customer = new Customer(address, 99999, phone, email, password);
						if (RegisteredController.addCustomer(customer)) {
							new GUI_login();
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Sorry, register failed!");
						}
			
		}
	});

		returnButton = new JButton();
		returnButton.setBounds(65,400,90,35);
		returnButton.setBackground(new Color(214,217,223));
		returnButton.setForeground(new Color(0,0,0));
		returnButton.setEnabled(true);
		returnButton.setFont(new Font("sansserif",0,12));
		returnButton.setText("Return");
		returnButton.setVisible(true);
		returnButton.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
					new GUI_login();
					dispose();
				}
			});
		}
	});

		//adding components to contentPane panel
		contentPane.add(registerPanel);
		registerPanel.add(addressLabel);
		registerPanel.add(addressTextfield);
		registerPanel.add(emailLabel);
		registerPanel.add(emailTextField);
		registerPanel.add(label5);
		registerPanel.add(passwordLabel);
		registerPanel.add(passwordTextfield);
		registerPanel.add(phoneLabel);
		registerPanel.add(phoneTextfield);
		registerPanel.add(registerButton);
		registerPanel.add(returnButton);

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
				new GUI_register();
			}
		});
	}

}