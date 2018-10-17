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


public class GUI_editCart extends JFrame {

	private JMenuBar menuBar;
	private JButton editCart_add_button;
	private JButton editCart_cancel_button;
	private JButton editCart_delete_button;
	private JLabel editCart_number_label;
	private JTextField editCart_number_textfield;
	private JPanel editCart_panel;
	private JLabel editCart_title;

	//Constructor 
	public GUI_editCart(){

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
		editCart_add_button.setText("Add");
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
		editCart_number_textfield.setText("");
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



	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI_editCart();
			}
		});
	}

}