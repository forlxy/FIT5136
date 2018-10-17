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


public class GUI_changePassword extends JFrame {

	private JMenuBar menuBar;
	private JButton closeButton;
	private JButton confirmButton;
	private JLabel label2;
	private JLabel newPasswordLabel;
	private JTextField newPasswordTextfield;
	private JPanel panel1;

	//Constructor 
	public GUI_changePassword(){

		this.setTitle("GUI_changePassword");
		this.setSize(300,200);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(300,200));
		contentPane.setBackground(new Color(192,192,192));


		closeButton = new JButton();
		closeButton.setBounds(40,130,90,35);
		closeButton.setBackground(new Color(214,217,223));
		closeButton.setForeground(new Color(0,0,0));
		closeButton.setEnabled(true);
		closeButton.setFont(new Font("sansserif",0,12));
		closeButton.setText("Close");
		closeButton.setVisible(true);
		closeButton.addActionListener(new ActionListener(){
		
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
		

		confirmButton = new JButton();
		confirmButton.setBounds(190,130,90,35);
		confirmButton.setBackground(new Color(214,217,223));
		confirmButton.setForeground(new Color(0,0,0));
		confirmButton.setEnabled(true);
		confirmButton.setFont(new Font("sansserif",0,12));
		confirmButton.setText("Confirm");
		confirmButton.setVisible(true);

		label2 = new JLabel();
		label2.setBounds(58,15,184,28);
		label2.setBackground(new Color(214,217,223));
		label2.setForeground(new Color(0,0,0));
		label2.setEnabled(true);
		label2.setFont(new Font("SansSerif",0,20));
		label2.setText("Change password");
		label2.setVisible(true);

		newPasswordLabel = new JLabel();
		newPasswordLabel.setBounds(30,60,90,40);
		newPasswordLabel.setBackground(new Color(214,217,223));
		newPasswordLabel.setForeground(new Color(0,0,0));
		newPasswordLabel.setEnabled(true);
		newPasswordLabel.setFont(new Font("sansserif",0,12));
		newPasswordLabel.setText("New password:");
		newPasswordLabel.setVisible(true);

		newPasswordTextfield = new JTextField();
		newPasswordTextfield.setBounds(140,60,140,40);
		newPasswordTextfield.setBackground(new Color(255,255,255));
		newPasswordTextfield.setForeground(new Color(0,0,0));
		newPasswordTextfield.setEnabled(true);
		newPasswordTextfield.setFont(new Font("sansserif",0,12));
		newPasswordTextfield.setText("");
		newPasswordTextfield.setVisible(true);

		panel1 = new JPanel(null);
		panel1.setBorder(BorderFactory.createEtchedBorder(1));
		panel1.setBounds(-5,-5,300,200);
		panel1.setBackground(new Color(214,217,223));
		panel1.setForeground(new Color(0,0,0));
		panel1.setEnabled(true);
		panel1.setFont(new Font("sansserif",0,12));
		panel1.setVisible(true);

		//adding components to contentPane panel
		panel1.add(closeButton);
		panel1.add(confirmButton);
		panel1.add(label2);
		panel1.add(newPasswordLabel);
		panel1.add(newPasswordTextfield);
		contentPane.add(panel1);

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
				new GUI_changePassword();
			}
		});
	}

}