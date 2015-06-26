package resource;

import insurance.AddVehicle;
import insurance.User;
import insurance.UserInfo;

public class Quota {
	private String userName;
	private double quota = 400;
	private String[] carType = {"Aucra","Audi","BMW"
			,"Chevorlet","Dodge","Ford","Honda","Infiniti","Lexus","Mazda",
			"Nissan","Toyota"};
	private int year;
	public double violationFactor;
	public double carTypeFactor;
	
	User user = new User();
	UserInfo ui;
	
	AddVehicle av = new AddVehicle();
	
	public Quota(String userName, String carType, double carTypeFactor, int year, double violationFactor){
		this.userName = userName;
		this.setCarType(carType);
		this.carTypeFactor = carTypeFactor;
		this.year = year;
		this.violationFactor = violationFactor;
	}

	private void setCarType(String carType2) {
		// TODO Auto-generated method stub
		
	}

	public double getViolationFactor() {
		if(ui.violationBox.getSelectedItem() == 
				"No violation during last 3 years"){
			violationFactor = 1.0; 
		}
		else if(ui.violationBox.getSelectedItem() == ""
				+ "1-3 violations during last 3 years"){
			violationFactor = 1.15;
		}
		else if(ui.violationBox.getSelectedItem() == ""
				+ "3-5 violations during last 3 years"){
			violationFactor = 1.23;
		}
		else if(ui.violationBox.getSelectedItem() == ""
				+ "5-10 violations during last 3 years"){
			violationFactor = 1.28;
		}
		else if(ui.violationBox.getSelectedItem() == ""
				+ "3-5 violations during last 3 years"){
			violationFactor = 1.35;
		}
		return violationFactor;
	}
	public void setViolationFactor(double violationFactor) {
		this.violationFactor = violationFactor;
	}

	public double getCarTypeFactor() {
		if(av.make.getSelectedItem() == "Acura"){
			carTypeFactor = 2.3;
		}
		else if(av.make.getSelectedItem() == "BMW"){
			carTypeFactor = 2.45;
		}
		else if(av.make.getSelectedItem() == "Chevrolet"){
			carTypeFactor = 1.22;
		}
		else if(av.make.getSelectedItem() == "Dodge"){
			carTypeFactor = 1.32;
		}
		else if(av.make.getSelectedItem() == "Ford"){
			carTypeFactor = 1.14;
		}
		else if(av.make.getSelectedItem() == "Honda"){
			carTypeFactor = 1.36;
		}
		else if(av.make.getSelectedItem() == "Infinity"){
			carTypeFactor = 2.10;
		}
		else if(av.make.getSelectedItem() == "Lexus"){
			carTypeFactor = 2.03;
		}
		else if(av.make.getSelectedItem() == "Mazda"){
			carTypeFactor = 1.05;
		}
		else if(av.make.getSelectedItem() == "Mercedes-Benz"){
			carTypeFactor = 2.31;
		}
		else if(av.make.getSelectedItem() == "Nissan"){
			carTypeFactor = 1.24;
		}
		else if(av.make.getSelectedItem() == "Toyota"){
			carTypeFactor = 1.48;
		}
		else{
			carTypeFactor = 1.3;
		}
		return carTypeFactor;
	}

	public void setCarTypeFactor(double carTypeFactor) {
		this.carTypeFactor = carTypeFactor;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getQuota() {
		return quota + (quota * violationFactor) + (quota * carTypeFactor);
	}

	public void setQuota(double quota) {
		this.quota = quota;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public String[] getCarType() {
		return carType;
	
	}
	
}
