package insurance;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static User user;
	
	private JPanel contentPane;
	private JTextField streetAddrField;
	private JTextField aptField;
	private JTextField cityField;
	private JComboBox <String> stateBox;
	private JTextField zipCodeField;
	private JButton save;
	
	
	private final String[] stateName = new String[]{"AK","AL","AZ","CO","CT","DE","GA","IL","IN","KS","LA","MD",
			"MA","MS","MO","NV","NM","NY","NC","OH","OK","SC","TN","TX","WA","WY"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setTitle("Enter your basic information ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.getContentPane().setLayout(null);
		
		//Font f =new Font("Verdana",Font.BOLD,13);
		
		JLabel street = new JLabel("Street");
		street.setBounds(25, 67, 68, 16);
		//street.setFont(f);
		contentPane.add(street);
		
		JLabel apt = new JLabel("Apt/Suite");
		apt.setBounds(70, 67, 66, 16);
		contentPane.add(apt);
	
		JLabel city = new JLabel("City");
		city.setBounds(25, 107, 34, 16);
		contentPane.add(city);
		
		JLabel state = new JLabel("State");
		state.setBounds(70,107,20,16);
		contentPane.add(state);
		
		JLabel zip = new JLabel("Zip");
		zip.setBounds(90,107,20,16);
		contentPane.add(zip);
		
		streetAddrField = new JTextField();
		streetAddrField.setBounds(147, 21, 156, 28);
		streetAddrField.setColumns(20);
		contentPane.add(streetAddrField);
		
		aptField = new JTextField();
		aptField.setBounds(210, 21, 156, 28);
		aptField.setColumns(20);
		contentPane.add(aptField);
		
		cityField=new JTextField();
		cityField.setBounds(147,61,156,28);
		cityField.setColumns(20);
		contentPane.add(cityField);
		
		
		stateBox = new JComboBox<String>(stateName);
		stateBox.setBounds(190,61,158,28);
		contentPane.add(stateBox);
		
		zipCodeField = new JTextField();
		zipCodeField.setBounds(210,61,158,28);
		zipCodeField.setColumns(20);
		contentPane.add(zipCodeField);
		
		stateBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				@SuppressWarnings("unchecked")
				JComboBox<String> jcb = (JComboBox<String>)e.getSource();
				//String stName =(String)jcb.getSelectedItem();
				
			}
			
		});
		//add(stateBox);
		
		save = new JButton("Save and Continue");
		save.setBounds(40,80,60,25);
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserInfo ui = new UserInfo();
				try{
					BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
					bw.newLine();
					bw.write("Address: " + streetAddrField.getText() + '\n'
							+ "Apt/Suite: "+ aptField.getText() + '\n'
							+ "City: "+ cityField.getText() + '\n'
							+ "State: "+ stateBox.getSelectedItem() + '\n'
							+"zip code: " + zipCodeField.getText() + '\n');
					bw.close();
				}catch (FileNotFoundException e1)
				{
					e1.printStackTrace();
				}catch (NullPointerException e1){
					e1.printStackTrace();
				}
				catch (IOException e1){
					e1.printStackTrace();
				}
				ui.setVisible(true);
			}
		});
		contentPane.add(save);
		
		JButton cancel = new JButton("cancel");
		cancel.setBounds(300, 380, 117, 29);
		cancel.addActionListener(new ActionListener(){

			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserInfo.this.setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
		});
		contentPane.add(cancel);
		
	}

}
