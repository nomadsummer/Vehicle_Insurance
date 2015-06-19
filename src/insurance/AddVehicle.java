package insurance;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.*;


public class AddVehicle extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField vinField;
		private JComboBox <String> year;
		private JComboBox make;
		private JComboBox model;
		private JComboBox bodyStyle;
		//JComboBoxDemo example=new JComboBoxDemo();
		

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AddVehicle frame = new AddVehicle();
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
		public AddVehicle() {
			setTitle("Add a vehicle! ");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 500, 500);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			this.getContentPane().setLayout(null);
			
			JLabel yearLabel = new JLabel("Year");
			yearLabel.setBounds(30, 120, 68, 16);
			
			year=new JComboBox <String>();
			year.setBounds(280, 80, 180, 100);
		    year.addItem("2015");
		    year.addItem("2014");
		    year.addItem("2013");
		    year.addItem("2012");
		    year.addItem("2011");
		    year.addItem("2010");
		    year.addItem("2009");
		    year.addItem("2008");
		    year.addItem("2007");
		    year.addItem("2006");
		    year.addItem("2005");
		    year.addItem("2004");
		    year.addItem("2003");
		    year.addItem("2002");
		    year.addItem("2001");
		    year.addItem("2000");
		    year.addItem("1999");
		    year.addItem("1998");
		    year.addItem("1997");
		    year.addItem("1996");
		    year.addItem("1995");
		    year.addItem("1994");
		    year.addItem("1993");
		    year.addItem("1992");
		    year.addItem("1991");
		    contentPane.add(year);
		    
		    
		    make=new JComboBox <String>();
			make.setBounds(280, 130, 180, 100);
			make.addItem(null);
			make.addItem("Acura");
			make.addItem("BMW");
			make.addItem("Chevrolet");
			make.addItem("Dodge");
			make.addItem("Ford");
			make.addItem("Honda");
			make.addItem("Infiniti");
			make.addItem("Lexus");
			make.addItem("Mazda");
			make.addItem("Mercedes-Benz");		
			make.addItem("Nissan");		
			make.addItem("Toyota");		
		    contentPane.add(make);
		    
		    model=new JComboBox <String>();
			model.setBounds(280, 180, 180, 100);
		    make.addItemListener(new ItemListener(){
		    	public void itemStateChanged(ItemEvent ie){
		    		 if(ie.getItem().equals("Acura")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("NSX");
		    			 model.addItem("TL");
		    			 model.addItem("TSX");
		    			 model.addItem("RDX");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Audi")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("A4");
		    			 model.addItem("A6");
		    			 model.addItem("A7");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("BMW")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("M3");
		    			 model.addItem("M5");
		    			 model.addItem("M7");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Chevrolet")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("Malibu");
		    			 model.addItem("Spark");
		    			 model.addItem("Volt");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Dodge")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("Caravan");
		    			 model.addItem("Grand Caravan Blacktop");
		    			 model.addItem("SRT Viper");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Ford")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("Falvon");
		    			 model.addItem("Ka");
		    			 model.addItem("Territory");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Honda")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("N-One");
		    			 model.addItem("Ridgeline");
		    			 model.addItem("ZEST");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Infiniti")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("RB10");
		    			 model.addItem("Q40");
		    			 model.addItem("G20");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Lexus")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("ES");
		    			 model.addItem("GSh");
		    			 model.addItem("RCF");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Mazda")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("RX-8");
		    			 model.addItem("MX-5");
		    			 model.addItem("CX-9");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Mercedes-Benz")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("E Class Wagon");
		    			 model.addItem("GL Class SUV");
		    			 model.addItem("S Class Coupe");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Nissan")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("GT-R");
		    			 model.addItem("NPT-90");
		    			 model.addItem("Skyline");
		    			 model.addItem("Others");
		    		 }
		    		 else if(ie.getItem().equals("Toyota")&&(ie.getStateChange()==1)){
		    			 clearcombo(model);
		    			 model.addItem("Aygo");
		    			 model.addItem("Belta");
		    			 model.addItem("Mark X");
		    			 model.addItem("Others");
		    		 }
		    		 else{
		    			 clearcombo(model);
		    		 }
		    	}
		    });
		    contentPane.add(model);
		    
		    
		    
		    
		    bodyStyle=new JComboBox <String>();
		    bodyStyle.setBounds(280, 230, 180, 100);
		    bodyStyle.addItem("Convertible");
		    bodyStyle.addItem("Coupe");
		    bodyStyle.addItem("Crossover");
		    bodyStyle.addItem("Hatchback");
		    bodyStyle.addItem("Sedan");
		    bodyStyle.addItem("SUV");
		    bodyStyle.addItem("Truck");
		    bodyStyle.addItem("Van/Minivan");
		    bodyStyle.addItem("Wagon");
		    contentPane.add(bodyStyle);
		    
			
			JLabel makeLabel = new JLabel("Make");
			makeLabel.setBounds(30, 170, 66, 16);
			
			JLabel modelLabel = new JLabel("Model");
			modelLabel.setBounds(30, 220, 66, 16);
			
			JLabel bodyStyleLabel = new JLabel("Body Style");
			bodyStyleLabel.setBounds(30, 270, 66, 16);
			
			JLabel vinLabel = new JLabel("Vehicle Identification Number (VIN)");
			vinLabel.setBounds(30, 320, 250, 16);
			
			JLabel apply = new JLabel("(Applies only to 1991 and newer vehicles)");
			apply.setBounds(280, 340, 250, 16);
			apply.setForeground(Color.red);
			apply.setFont(new   java.awt.Font("Dialog",   0,   10));   
			
			
			vinField = new JTextField();
			vinField.setBounds(280, 315, 180, 28);
			vinField.setColumns(10);
			
			JLabel label = new JLabel("");
			label.setBounds(141, 221, 0, 0);
			
			JButton addVehicle = new JButton("Add this vehicle");
 			addVehicle.addActionListener(new ActionListener(){

 				//@Override
 				public void actionPerformed(ActionEvent e) {
 					AddVehicle addVehicle = new AddVehicle();
					AddVehicle.this.setVisible(true);
					//AddVehicle.this.setVisible(true);
					System.out.println(year.getSelectedItem());
					System.out.println(make.getSelectedItem());
                                        System.out.println(model.getSelectedItem());
                                        
					try {
						PrintWriter writer;
						writer = new PrintWriter("file.txt", "UTF-8");
						writer.print(year.getSelectedItem()+" "+make.getSelectedItem()+" "+model.getSelectedItem()+" "+bodyStyle.getSelectedItem());
	                                        writer.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						FileWriter filewriter=new FileWriter("file1.txt",true);
						filewriter.write(year.getSelectedItem()+" "+make.getSelectedItem()+" "+model.getSelectedItem()+" "+bodyStyle.getSelectedItem());
						filewriter.write(System.lineSeparator());
						filewriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
					addVehicle.setVisible(true);
 					
 				}
 				
 			});
 			
 			addVehicle.setBounds(270, 380, 200, 29);
			
			contentPane.setLayout(null);
			contentPane.add(label);
			contentPane.add(yearLabel);
			contentPane.add(makeLabel);
			contentPane.add(modelLabel);
			contentPane.add(bodyStyleLabel);
			contentPane.add(vinLabel);
			contentPane.add(apply);
			
			
			contentPane.add(vinField);
			
			contentPane.add(addVehicle);
			
			JButton cancel = new JButton("cancel");
			cancel.setBounds(60, 380, 117, 29);
			cancel.addActionListener(new ActionListener(){

				//@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AddVehicle.this.setVisible(false);
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
		public void clearcombo(JComboBox model){
			int itemCount = model.getItemCount();
		    for(int i=0;i<itemCount;i++){
		        model.removeItemAt(0);
		     }
		}
		
		
	}
