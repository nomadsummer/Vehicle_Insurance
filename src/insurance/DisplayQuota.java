package insurance;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.kie.api.KieServices;
import org.kie.api.KieServices.Factory;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import resource.Quota;

public class DisplayQuota extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Quota quota;
	private JLabel quotaDisplay1;
	private JLabel quotaDisplay2;
	public double violationFactor;
	public double carTypeFactor;
	private double quotaQ = 350.0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//download insurance information from stored files
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayQuota frame = new DisplayQuota();
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
	public DisplayQuota()throws Exception{
		
		setTitle("Display the quota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.getContentPane().setLayout(null);
		
		/*try{
			new KieServices.Factory();
			KieServices kieServices = Factory.get();
			KieContainer kieContainer = kieServices.getKieClasspathContainer();
			KieSession kieSession = kieContainer.newKieSession("ksession-rules");
			quota.setViolationFactor(violationFactor);
			quota.setCarTypeFactor(carTypeFactor);
			quota.setViolationFactor(violationFactor);
			kieSession.insert(quota);
			kieSession.fireAllRules();	
		}catch(Throwable t){
			t.printStackTrace();
		}*/
		
	    quotaQ = quotaQ+ (quotaQ * violationFactor) + (quotaQ * carTypeFactor);
		//quotaQ = quota.getQuota();
	    quotaDisplay1 = new JLabel("the quota for your car insurance is: ");
        quotaDisplay1.setBounds(120,320,300,30);
        contentPane.add(quotaDisplay1);
	    quotaDisplay2 = new JLabel(String.valueOf(quotaQ));
        quotaDisplay2.setBounds(120,340,100,30);
        contentPane.add(quotaDisplay2);
	    //System.out.println(quotaQ);
		
		
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
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon("images.jpeg"));
		imgLabel.setBounds(120, 0, 300, 300);

		contentPane.add(imgLabel);
	}
	

	
	//@SuppressWarnings("unused")
	/*private KnowledgeBase readKnowledgeBase() throws Exception {
	     KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	     kbuilder.add(ResourceFactory.newClassPathResource("insurancerules.drl"), ResourceType.DRL);
	     kbuilder.add(ResourceFactory.newClassPathResource("carType.drl"),ResourceType.DRL);
	     KnowledgeBuilderErrors errors = kbuilder.getErrors();
	        if (errors.size() > 0) {
	             for (KnowledgeBuilderError error : errors) {
	                  System.err.println(error);
	                        }
	     throw new IllegalArgumentException("Could not parse knowledge.");
	       }
	      KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	      kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	      return kbase;
	     }*/
	

}
