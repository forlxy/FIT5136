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
	

	//Constructor 
	public GUI_userInfo(){

		this.setTitle("GUI_userInfo");
		this.setSize(400,300);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(400,300));
		contentPane.setBackground(new Color(192,192,192));


		label1 = new JLabel();
		label1.setBounds(40,60,90,40);
		label1.setBackground(new Color(214,217,223));
		label1.setForeground(new Color(0,0,0));
		label1.setEnabled(true);
		label1.setFont(new Font("sansserif",0,12));
		label1.setText("User emai: ");
		label1.setVisible(true);

		label2 = new JLabel();
		label2.setBounds(40,100,120,40);
		label2.setBackground(new Color(214,217,223));
		label2.setForeground(new Color(0,0,0));
		label2.setEnabled(true);
		label2.setFont(new Font("sansserif",0,12));
		label2.setText("Current balance: ");
		label2.setVisible(true);

		label3 = new JLabel();
		label3.setBounds(40,140,90,40);
		label3.setBackground(new Color(214,217,223));
		label3.setForeground(new Color(0,0,0));
		label3.setEnabled(true);
		label3.setFont(new Font("sansserif",0,12));
		label3.setText("Address:");
		label3.setVisible(true);

		label4 = new JLabel();
		label4.setBounds(40,180,90,40);
		label4.setBackground(new Color(214,217,223));
		label4.setForeground(new Color(0,0,0));
		label4.setEnabled(true);
		label4.setFont(new Font("sansserif",0,12));
		label4.setText("Phone:");
		label4.setVisible(true);

		label5 = new JLabel();
		label5.setBounds(125,12,169,33);
		label5.setBackground(new Color(214,217,223));
		label5.setForeground(new Color(0,0,0));
		label5.setEnabled(true);
		label5.setFont(new Font("SansSerif",0,20));
		label5.setText("User information");
		label5.setVisible(true);

		label6 = new JLabel();
		label6.setBounds(180,60,180,40);
		label6.setBackground(new Color(214,217,223));
		label6.setForeground(new Color(0,0,0));
		label6.setEnabled(true);
		label6.setFont(new Font("sansserif",0,12));
		label6.setText("null");
		label6.setVisible(true);

		label7 = new JLabel();
		label7.setBounds(180,100,180,40);
		label7.setBackground(new Color(214,217,223));
		label7.setForeground(new Color(0,0,0));
		label7.setEnabled(true);
		label7.setFont(new Font("sansserif",0,12));
		label7.setText("null");
		label7.setVisible(true);

		label8 = new JLabel();
		label8.setBounds(180,140,180,40);
		label8.setBackground(new Color(214,217,223));
		label8.setForeground(new Color(0,0,0));
		label8.setEnabled(true);
		label8.setFont(new Font("sansserif",0,12));
		label8.setText("null");
		label8.setVisible(true);

		label9 = new JLabel();
		label9.setBounds(180,180,180,40);
		label9.setBackground(new Color(214,217,223));
		label9.setForeground(new Color(0,0,0));
		label9.setEnabled(true);
		label9.setFont(new Font("sansserif",0,12));
		label9.setText("null");
		label9.setVisible(true);

		panel1 = new JPanel(null);
		panel1.setBorder(BorderFactory.createEtchedBorder(1));
		panel1.setBounds(-5,-5,400,300);
		panel1.setBackground(new Color(214,217,223));
		panel1.setForeground(new Color(0,0,0));
		panel1.setEnabled(true);
		panel1.setFont(new Font("sansserif",0,12));
		panel1.setVisible(true);
		
		closeButton = new JButton();
		closeButton.setBounds(170,250,90,35);
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
				new GUI_userInfo();
			}
		});
	}

}