package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class RegisterDialog {

	private JDialog registerDialog;
	
	private JButton confirmButton;
	private JButton cancleButton;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	
	private JTextField nameInput;
	private JTextField passwordInput;
	private JTextField phoneInput;
	private JTextField emailInput;
	
	private JPanel panel;
	
	public RegisterDialog() 
	{
		registerDialog = new JDialog();
		
		panel = new JPanel();
		
		confirmButton = new JButton("Confirm");
		cancleButton = new JButton("Cancle");
		
		nameLabel = new JLabel("Name: ");
		passwordLabel = new JLabel("Password:");
		phoneLabel = new JLabel("Phone:");
		emailLabel = new JLabel("Email:");
		
		nameInput = new JTextField();
		passwordInput = new JTextField();
		phoneInput = new JTextField();
		emailInput = new JTextField();
		
		nameLabel.setBounds(130, 20,70, 60);
		emailLabel.setBounds(130, 50, 70, 60);
		phoneLabel.setBounds(130, 80, 70, 60);
		passwordLabel.setBounds(130, 110, 70, 60);
		
		nameInput.setBounds(160, 20,150, 30);
		emailInput.setBounds(160, 50,150, 30);
		phoneInput.setBounds(160, 80, 150, 30);
		passwordInput.setBounds(160, 110, 150, 30);
		
		panel.add(nameLabel);
		panel.add(nameInput);
		panel.add(passwordLabel);
		panel.add(passwordInput);
		panel.add(phoneLabel);
		panel.add(phoneInput);
		panel.add(emailLabel);
		panel.add(emailInput);
		panel.add(confirmButton);
		panel.add(cancleButton);
		
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Registration Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		registerDialog.setSize(490, 300);
		registerDialog.add(panel);
		registerDialog.setLocationRelativeTo(null);
	}
	
	public Dialog getRegisterDialog() {
		return registerDialog;
	}

	public void setRegisterDialog(JDialog registerDialog) {
		this.registerDialog = registerDialog;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}

	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}

	public JButton getCancleButton() {
		return cancleButton;
	}

	public void setCancleButton(JButton cancleButton) {
		this.cancleButton = cancleButton;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JLabel getPhoneLabel() {
		return phoneLabel;
	}

	public void setPhoneLabel(JLabel phoneLabel) {
		this.phoneLabel = phoneLabel;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}

	public JTextField getNameInput() {
		return nameInput;
	}

	public void setNameInput(JTextField nameInput) {
		this.nameInput = nameInput;
	}

	public JTextField getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(JTextField passwordInput) {
		this.passwordInput = passwordInput;
	}

	public JTextField getPhoneInput() {
		return phoneInput;
	}

	public void setPhoneInput(JTextField phoneInput) {
		this.phoneInput = phoneInput;
	}

	public JTextField getEmailInput() {
		return emailInput;
	}

	public void setEmailInput(JTextField emailInput) {
		this.emailInput = emailInput;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
