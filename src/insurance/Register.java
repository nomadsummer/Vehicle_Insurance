package insurance;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lastnameField;
	private JTextField firstnameField;
	private JTextField IdField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	
	public User newUser;
	public static VehicleInsurance vehicleInsurance;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("Register for the vehicle Insurance! ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.getContentPane().setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(95, 120, 68, 16);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(95, 170, 66, 16);
		
		JLabel IdLabel = new JLabel("ID");
		IdLabel.setBounds(95, 220, 34, 16);
		
		//add scroll down panel for birthday
		
		firstnameField = new JTextField();
		firstnameField.setBounds(240, 115, 156, 28);
		firstnameField.setColumns(10);
		
		lastnameField = new JTextField();
		lastnameField.setBounds(240, 165, 156, 28);
		lastnameField.setColumns(10);
		
		
		IdField = new JTextField();
		IdField.setBounds(240, 215, 156, 28);
		IdField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(141, 221, 0, 0);
		
		JButton register = new JButton("register for the insurance");
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// get the register information
				String lastName = lastnameField.getText().trim();
				String firstName = firstnameField.getText().trim();
				String ID = IdField.getText().trim();
				String pwd = String.valueOf(passwordField.getPassword()).trim();
				String confirmPwd = String.valueOf(confirmPasswordField.getPassword()).trim();
				//check if the two password matches
				if(pwd.equals(confirmPwd)){
					newUser = new User(ID);
					newUser.setName(firstName + lastName);
					newUser.setPassword(pwd);
				}
				try{
					if(newUser.checkUser()){
						tips duplicateUser = new tips("the user has already registered! ");
						duplicateUser.setVisible(true);
					}
					if(!newUser.checkUser()){
						newUser.Register();
						tips welcomeInfo = new tips("welcome to our the vehicle insurance! ");
						welcomeInfo.setVisible(true);
						vehicleInsurance.createUser(newUser.getId(),newUser.getPassword());
						ControlPanel cp = new ControlPanel(newUser);
						cp.setVisible(true);
						Register.this.setVisible(false);
					}
				}/*catch(InterruptedException ire){
					ire.printStackTrace();
				}*/catch(Exception ex)
				{	
					ex.printStackTrace();
				}
				if(!pwd.equals(confirmPwd)){
					tips nonMatchPwd = new tips("the password does not match! ");
					nonMatchPwd.setVisible(true);
				}
			}
			
		});
		register.setBounds(250, 380, 230, 29);
		
		JButton cancel = new JButton("cancel");
		cancel.setBounds(60, 380, 117, 29);
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Register.this.setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(firstNameLabel);
		contentPane.add(lastNameLabel);
		contentPane.add(IdLabel);
		contentPane.add(lastnameField);
		contentPane.add(firstnameField);
		contentPane.add(IdField);
		contentPane.add(IdLabel);
		contentPane.add(register);
		contentPane.add(cancel);
		
		JLabel pwdLabel = new JLabel("password: ");
		pwdLabel.setBounds(95, 270, 200, 16);
		contentPane.add(pwdLabel);
		
		JLabel confirmPwdLabel = new JLabel("Confirm Password: ");
		confirmPwdLabel.setBounds(95, 320, 200, 16);
		contentPane.add(confirmPwdLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(240, 265, 156, 28);
		contentPane.add(passwordField);
		
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(240, 315, 156, 28);
		contentPane.add(confirmPasswordField);
		
		
		JLabel imgLabe2 = new JLabel("");
		imgLabe2.setIcon(new ImageIcon("image-header.jpeg"));
		imgLabe2.setBounds(0, 0, 500, 95);
		
		contentPane.add(imgLabe2);
		
	}
	
	
	
	/*public void setVisible(boolean b) {
		// TODO Auto-generated method stub
	}*/

}
