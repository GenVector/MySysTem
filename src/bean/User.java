package bean;

public class User {
	public static int PAGE_SIZE=10;
	private String IDCard;
	private String name;
	private String sex;
	private String phone;
	private String password;
	public String getIDCard(){
		return IDCard;
	}
	public String getName(){
		return name;
	}
	public String getSex(){
		return sex;
	}
	public String getPhone(){
		return phone;
	}
	public String getPassword(){
		return password;
	}
	public void setIDCard(String IDCard){
		this.IDCard=IDCard;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setSex(String sex){
		this.sex=sex;
	}

}
