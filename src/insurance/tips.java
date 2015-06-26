package insurance;



//This class is to show a few dialog window of pop out message
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Tips extends JDialog {
	
	private final JPanel contentPane = new JPanel();
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		try {
			Tips dialog = new Tips();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	//create the dialogs
	public Tips() {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 407, 126);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setText("System Message ");
		txtArea.setBackground(UIManager.getColor("Label.background"));
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setBounds(6, 6, 395, 53);
		contentPane.add(txtArea);
		{
			JPanel button = new JPanel();
			button.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(button,BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Tips.this.setVisible(false);	
					}
				});
				okButton.setActionCommand("OK");
				button.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public Tips(String string) {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 407, 140);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBackground(UIManager.getColor("Label.background"));
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setFont(new Font("Cambria", Font.BOLD|Font.ITALIC,15));
		txtArea.setBounds(6, 6, 395, 70);
		contentPane.add(txtArea);
		{
			JPanel button = new JPanel();
			button.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(button,BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Tips.this.setVisible(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				button.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}	
	}
}
