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


public class GUI_login extends JFrame {

    private JMenuBar menuBar;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel1;
    private JPasswordField passwordField;
    private JTextField emailTextfield;

    //Constructor 
    public GUI_login(){

        this.setTitle("GUI_login");
        this.setSize(400,300);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,300));
        contentPane.setBackground(new Color(192,192,192));

        loginButton = new JButton();
        loginButton.setBounds(60,200,90,35);
        loginButton.setBackground(new Color(214,217,223));
        loginButton.setForeground(new Color(0,0,0));
        loginButton.setEnabled(true);
        loginButton.setFont(new Font("sansserif",0,12));
        loginButton.setText("Login");
        loginButton.setVisible(true);
        loginButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {                  
                        int loginState = RegisteredController.login(emailTextfield.getText(), new String(passwordField.getPassword()));
                        if (loginState == 0 || loginState == 1) {
                            new MainInterface(RegisteredController.getByEmail(emailTextfield.getText()), loginState);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry, The email or password is not matched");
                        }
                    
                    }
                });
            }
        });

        registerButton = new JButton();
        registerButton.setBounds(238,200,90,35);
        registerButton.setBackground(new Color(214,217,223));
        registerButton.setForeground(new Color(0,0,0));
        registerButton.setEnabled(true);
        registerButton.setFont(new Font("sansserif",0,12));
        registerButton.setText("Reigster");
        registerButton.setVisible(true);
        registerButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    new GUI_register();
                    dispose();
                }
           });
        }
    });

        label1 = new JLabel();
        label1.setBounds(35,85,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("Email: ");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(35,140,90,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("sansserif",0,12));
        label2.setText("Password:");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(148,18,122,28);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,20));
        label3.setText("MFV System");
        label3.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(-5,-5,400,300);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        passwordField = new JPasswordField();
        passwordField.setBounds(130,140,200,40);
        passwordField.setBackground(new Color(214,217,223));
        passwordField.setForeground(new Color(0,0,0));
        passwordField.setEnabled(true);
        passwordField.setFont(new Font("sansserif",0,12));
        passwordField.setVisible(true);

        emailTextfield = new JTextField();
        emailTextfield.setBounds(130,85,200,40);
        emailTextfield.setBackground(new Color(255,255,255));
        emailTextfield.setForeground(new Color(0,0,0));
        emailTextfield.setEnabled(true);
        emailTextfield.setFont(new Font("sansserif",0,12));
        emailTextfield.setText("");
        emailTextfield.setVisible(true);

        //adding components to contentPane panel
        panel1.add(loginButton);
        panel1.add(registerButton);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        contentPane.add(panel1);
        panel1.add(passwordField);
        panel1.add(emailTextfield);

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
                new GUI_login();
            }
        });
    }

}