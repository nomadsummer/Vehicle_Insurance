package insurance;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
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

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField password;
	public User user;
	static VehicleInsurance vehicleInsurance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//download insurance information from stored files
		VehicleInsurance.downloadFile();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		
		setTitle("Vehicle Insurance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.getContentPane().setLayout(null);
		
		
		//user password field
		password = new JPasswordField();
		password.setBounds(220, 320, 141, 28);
		contentPane.add(password);
		
		//user id field
		userid = new JTextField();
		userid.setBounds(220,270,141,28);
		contentPane.add(userid);
		userid.setColumns(20);
		
		JLabel userLabel = new JLabel("User Id:");
		userLabel.setFont(new Font("Constantia", Font.BOLD,15));
		userLabel.setBounds(120,275, 61, 16);
		contentPane.add(userLabel);
		
		JLabel pwdLabel = new JLabel("Password:");
		pwdLabel.setFont(new Font("Constantia", Font.BOLD, 15));
		pwdLabel.setBounds(120, 325, 81, 16);
		contentPane.add(pwdLabel);
		
		//log in
		JButton login = new JButton("Log In");
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				String id = userid.getText().trim();
				char[] tmpPwd = password.getPassword();
				String password = String.valueOf(tmpPwd).trim();
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.DownloadFile();
				
				try{
					if(user.checkUser() && user.checkPassword()){
						ControlPanel cp = new ControlPanel(user);
						cp.setVisible(true);
						Login.this.dispose();
					}
					if(!user.checkUser()){
						tips noUser = new tips("This user does not exist! Please try another! ");
						noUser.setVisible(true);
					}
					if(user.checkUser() && !user.checkPassword()){
						tips wrongPwd = new tips("The password does not match existing user name, please try again! ");
						wrongPwd.setVisible(true);
					}		
				} catch(Exception e){
					e.printStackTrace();
				}	
			}
		});
		
		login.setBounds(80, 400, 71, 29);
		contentPane.add(login);
		
		//exit the desktop application
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		exit.setBounds(350, 400, 71, 29);
		contentPane.add(exit);
		
		//register for the application
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Register register = new Register();
				register.setVisible(true);
				Login.this.dispose();
			}
		});
		
		register.setBounds(210, 400, 83, 29);
		contentPane.add(register);
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon("images.jpeg"));
		imgLabel.setBounds(120, 0, 300, 300);
		//imgLabel.setLocation(50, 50);
		//imgLabel.setHorizontalAlignment(JLabel.CENTER);
		
		contentPane.add(imgLabel);
	}

}

