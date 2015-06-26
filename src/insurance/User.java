package insurance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class User {
	public String id;
	public String name;
	public String password;
	// set path to store the user-name and password
	public String userslistPath;
	 // set path to store the insurance detail of each user
	public String insurancelistPath;
	//store vehicle Insurance detail of each user
	public List<String> filelist;
	

	public User(String userid) {
		// TODO Auto-generated constructor stub
		this.id = userid;
		this.name = new String();
		this.password = new String();
		this.userslistPath = "user-password.txt";
		this.insurancelistPath = "/User/Summer/Documents/workspace/Insurance/Insurancefolder";
	}
	public User() {
		// TODO Auto-generated constructor stub
		this.id=new String();
		this.name = new String();
		this.password = new String();
		this.userslistPath  = "/Users/Summer/Documents/workspace/Insurance/user-password.txt";
		this.insurancelistPath = "/User/Summer/Documents/workspace/Insurance/InsuranceFolder";
	}

	public String getId() {
		// TODO Auto-generated method stub
		String userid = new String();
		userid = this.id;
		return userid;
	}
	public void setId(String userid) {
		// TODO Auto-generated method stub
		this.id = userid;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public String getUserListPath(){
		return userslistPath;
	}
	public void setUserListPath(String userslistPath){
		this.userslistPath=userslistPath;
	}

	/*public void DownloadFile() {
		// TODO Auto-generated method stub
		
	}*/
	//check if the password matches the user name
	public boolean checkPassword() throws IOException{
		// TODO Auto-generated method stub
		try{
			FileReader fileReader = new FileReader(this.userslistPath);
			BufferedReader br = new BufferedReader(fileReader);
			String row = br.readLine();
			while(row != null){
				String[] userInfo = row.trim().split("#");
				if(userInfo[0].equals(this.id.trim())){
					if(userInfo[1].trim().equals(this.password.trim()))
					{
						return true;
					}
				}
			}
		}catch (FileNotFoundException fe){
			fe.printStackTrace();
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
		return false;
	}
	// check if user is already exists
	public boolean checkUser() throws IOException {
		// TODO Auto-generated method stub
		try{
			FileReader fileReader = new FileReader(this.userslistPath);
			BufferedReader br = new BufferedReader(fileReader);
			String row = br.readLine();
			while(row != null){
				String[] userInfo =  row.trim().split("#");
				if(userInfo[0].equals(this.id.trim())){
					return true;
				}
			}
			}catch (FileNotFoundException fe){
				fe.printStackTrace();
			}catch (IOException ioe){
				ioe.printStackTrace();
			}
		return false;
	}
	
	public void Register() throws IOException {
		// TODO Auto-generated method stub
		try{
			File userinfo = new File(this.userslistPath);
			if(!userinfo.exists()){
				userinfo.createNewFile();
			}
			//add new user to the user-password file
			RandomAccessFile raf =new RandomAccessFile(this.userslistPath,"rw");
			raf.seek(raf.length());
			raf.writeBytes(this.id.trim()+"#"+this.password.trim()+"\n");
			raf.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}	
	}
	
	/*public static void main(String[] args) throws IOException{
		User user = new User();
		user.setId("1");
		user.setPassword("2");
		System.out.println(user.id);
		if(!user.checkUser()){
			System.out.println(user.id);
		}
		if(!user.checkPassword()){
			System.out.println(user.password);
		}
	}*/
}
