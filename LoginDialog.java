package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;

public class LoginDialog {

	private JDialog loginDialog;
	
	private JButton loginConfirm;
	private JButton loginCancle;
	private JLabel accountLabel;
	private JLabel passwordLabel;
	private JTextField accountInput;
	private JTextField passwordInput;
	
	public LoginDialog()
	{
		loginDialog = new JDialog();
		loginDialog.setSize(490,230);
		loginDialog.setTitle("Login");
		loginDialog.setLayout(null);
		
		loginConfirm = new JButton("Confirm");
		loginCancle = new JButton("Cancle");
		accountLabel = new JLabel("Account: ");
		passwordLabel = new JLabel("Password: ");
		accountInput = new JTextField();
		passwordInput = new JTextField();
		
		accountLabel.setBounds(130, 15, 70, 60);
		accountInput.setBounds(200, 30, 150, 30);
		passwordLabel.setBounds(130, 65, 70, 60);
		passwordInput.setBounds(200, 80, 150, 30);
		loginConfirm.setBounds(155, 135, 70, 35);
		loginCancle.setBounds(260, 135, 70, 35);
		
		loginDialog.add(accountLabel);
		loginDialog.add(accountInput);
		loginDialog.add(passwordLabel);
		loginDialog.add(passwordInput);
		loginDialog.add(loginConfirm);
		loginDialog.add(loginCancle);
		
		loginDialog.setLocationRelativeTo(null);
	}
	
	public JDialog getLoginDialog() {
		return loginDialog;
	}

	public void setLoginDialog(JDialog loginDialog) {
		this.loginDialog = loginDialog;
	}

	public JButton getLoginConfirm() {
		return loginConfirm;
	}

	public void setLoginConfirm(JButton loginConfirm) {
		this.loginConfirm = loginConfirm;
	}

	public JButton getLoginCancle() {
		return loginCancle;
	}

	public void setLoginCancle(JButton loginCancle) {
		this.loginCancle = loginCancle;
	}

	public JLabel getAccountLabel() {
		return accountLabel;
	}

	public void setAccountLabel(JLabel accountLabel) {
		this.accountLabel = accountLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JTextField getAccountInput() {
		return accountInput;
	}

	public void setAccountInput(JTextField accountInput) {
		this.accountInput = accountInput;
	}

	public JTextField getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(JTextField passwordInput) {
		this.passwordInput = passwordInput;
	}
}
