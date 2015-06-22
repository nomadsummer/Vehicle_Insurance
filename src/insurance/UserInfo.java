package insurance;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JCheckBox female;
	private JCheckBox male;
	private JComboBox<String> violationBox;
	private JButton save;
	private JButton cancel;
	
	
	private final String[] stateName = new String[]{"AK","AL","AZ","CO","CT","DE","GA","IL","IN","KS","LA","MD",
			"MA","MS","MO","NV","NM","NY","NC","OH","OK","SC","TN","TX","WA","WY"};
	private final String[] violationOption = new String[]{
			"No violation during last 3 years","1-3 violations during last 3 years","3-5 violations during last 3 years",
			"5-10 violations during last 3 years","more than 10 violations during last 3 years"};
	
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
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.getContentPane().setLayout(null);
		
		//Font f =new Font("Verdana",Font.BOLD,13);
		
		
		this.getContentPane().setLayout(null);
		
		JLabel street = new JLabel("Street");
		street.setBounds(50, 120, 68, 16);
		//street.setFont(f);
		contentPane.add(street);
		
		JLabel apt = new JLabel("Apt/Suite");
		apt.setBounds(50, 170, 68, 16);
		contentPane.add(apt);
	
		JLabel city = new JLabel("City");
		city.setBounds(280, 170, 50, 16);
		contentPane.add(city);
		
		JLabel state = new JLabel("State");
		state.setBounds(50,220,40,16);
		contentPane.add(state);
		
		JLabel zip = new JLabel("Zip");
		zip.setBounds(280,220,20,16);
		contentPane.add(zip);
		
		streetAddrField = new JTextField();
		streetAddrField.setBounds(140, 115, 300, 28);
		streetAddrField.setColumns(20);
		contentPane.add(streetAddrField);
		
		aptField = new JTextField();
		aptField.setBounds(140, 165, 120, 28);
		aptField.setColumns(20);
		contentPane.add(aptField);
		
		cityField=new JTextField();
		cityField.setBounds(320, 165, 120, 28);
		cityField.setColumns(20);
		contentPane.add(cityField);
		
		
		stateBox = new JComboBox<String>(stateName);
		stateBox.setBounds(140,215,120,28);
		contentPane.add(stateBox);
		
		zipCodeField = new JTextField();
		zipCodeField.setBounds(320,215,120,28);
		zipCodeField.setColumns(20);
		contentPane.add(zipCodeField);
		
		stateBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				@SuppressWarnings({ "unchecked", "unused" })
				JComboBox<String> jcb = (JComboBox<String>)e.getSource();
				//String stName =(String)jcb.getSelectedItem();
				
			}
			
		});
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(50,270,68,16);
		contentPane.add(gender);
		
		female = new JCheckBox("Female");
		female.setMnemonic(KeyEvent.VK_G);
		female.setSelected(false);
		female.setBounds(150,230,100,100);
		female.setVisible(true);
		
		male = new JCheckBox("Male");
		male.setMnemonic(KeyEvent.VK_G);
		male.setSelected(false);
		male.setBounds(250,230,100,100);
		male.setVisible(true);
		
		contentPane.add(female);
		contentPane.add(male);
		
		/*female.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Object source = e.getItemSelectable();
				int genderIndicator;
				if(e.getStateChange() == ItemEvent.SELECTED){
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter("file.txt"));
					bw.newLine();
					bw.write("Gender: Female" + '\n');
					bw.close();
					genderIndicator = 2;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				UserInfo.this.setVisible(false);
					
				}
			}
			
		});
		male.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Object source = e.getItemSelectable();
				if(e.getStateChange() == ItemEvent.SELECTED){
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter("file.txt"));
					bw.newLine();
					bw.write("Gender: Female" + '\n');
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				UserInfo.this.setVisible(false);
					
				}
			}
			
		});*/
		
		JLabel violation = new JLabel("Violation History");
		violation.setBounds(50, 330, 80, 30);
		contentPane.add(violation);
		
		violationBox = new JComboBox<String>(violationOption);
		violationBox.setBounds(140,200,300,300);
		contentPane.add(violationBox);
		violationBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		save = new JButton("Save and Continue");
		save.setBounds(260, 420, 200, 29);
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
				AddVehicle av = new AddVehicle();
				av.setVisible(true);
				UserInfo.this.setVisible(false);
			}
		});
		contentPane.add(save);
		
		cancel = new JButton("cancel");
		cancel.setBounds(70, 420, 117, 29);
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
		
		
		JLabel imgLabe2 = new JLabel("");
		imgLabe2.setIcon(new ImageIcon("image-header.jpeg"));
		imgLabe2.setBounds(0, 0, 500, 95);
		
		contentPane.add(imgLabe2);
	}
	public void clearcombo(JComboBox<String> model){
		int itemCount = model.getItemCount();
	    for(int i=0;i<itemCount;i++){
	        model.removeItemAt(0);
	     }
	}
	
		
	}
