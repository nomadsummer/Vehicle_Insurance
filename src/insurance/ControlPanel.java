package insurance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javafx.scene.control.DatePicker;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ControlPanel extends JFrame implements ItemListener {
	private static final String STATIC_ACCESS = "static-access";
	
	//initialize the static parameters here
	static VehicleInsurance vehicleInsurance;
	
	
	public static User user;
	public JFrame mainFrame;
	private JPanel contentPane;
	private JPanel contentPaneBirthday;
	private JPanel contentPaneGender;
	private JPanel contentPaneViolationRecord;
	private JPanel contentPaneVeteranStatus;
	
	//address field
	private JTextField streetAddressField;
	private JTextField aptNoField;
	private JTextField cityNameField;
	private JComboBox<String> stateNameBox;
	private JTextField zipCodeField;
	private final String[] stateName = new String[]{"AK","AL","AZ","CO","CT","DE","GA","IL","IN","KS","LA","MD",
			"MA","MS","MO","NV","NM","NY","NC","OH","OK","SC","TN","TX","WA","WY"};
	
	
	//birthday field
	private DatePicker birthday;
	
	//gender field
	private JCheckBox female;
	private JCheckBox male;
	
	//violation during the last 3 years field
	private JTextField violationRecord;
	//veteran status field
	private JList veteranStatus;
	
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ControlPanel(User user) throws Exception {
		// TODO Auto-generated constructor stub
		setTitle("your basic information.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		setBackground(Color.gray);
		getContentPane().setLayout(new BorderLayout());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel addressFirstLine= new JLabel("Address");
		addressFirstLine.setBounds(25, 67, 68, 16);
		
		JLabel aptNo = new JLabel("Apt/Suite");
		aptNo.setBounds(25, 27, 66, 16);
		
		@SuppressWarnings("unused")
		JLabel zipCode = new JLabel("Zip");
		aptNo.setBounds(25, 107, 66, 16);
		
		streetAddressField = new JTextField();
		streetAddressField.setBounds(147, 21, 156, 28);
		streetAddressField.setColumns(10);
		
		aptNoField = new JTextField();
		aptNoField.setBounds(147, 61, 156, 28);
		aptNoField.setColumns(10);
		
		stateNameBox = new JComboBox<String>(stateName);
		stateNameBox.setBounds(147,101,158,28);
		//allow edits
		stateNameBox.setEditable(true);
		//watch for actions
		stateNameBox.addItemListener(this);
		
		
		
		
		setZipCodeField(new JTextField());
		aptNoField.setBounds(147, 161, 156, 28);
		aptNoField.setColumns(10);
		
	}
	public Object itemStateChanged1(ItemEvent e){
		Object o = new Object();;
		if(e.getSource() == stateNameBox && e.getStateChange() == ItemEvent.SELECTED){
			o=stateNameBox.getSelectedItem();	
		}
		return o;
	}

	/*public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}*/
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel frame = new ControlPanel(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	public JTextField getCityNameField() {
		return cityNameField;
	}
	public void setCityNameField(JTextField cityNameField) {
		this.cityNameField = cityNameField;
	}
	public JTextField getZipCodeField() {
		return zipCodeField;
	}
	public void setZipCodeField(JTextField zipCodeField) {
		this.zipCodeField = zipCodeField;
	}
	public JCheckBox getFemale() {
		return female;
	}
	public void setFemale(JCheckBox female) {
		this.female = female;
	}
	public JCheckBox getMale() {
		return male;
	}
	public void setMale(JCheckBox male) {
		this.male = male;
	}
	public JTextField getViolationRecord() {
		return violationRecord;
	}
	public void setViolationRecord(JTextField violationRecord) {
		this.violationRecord = violationRecord;
	}

	

}
