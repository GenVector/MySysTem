package bean;

public class Provider {
	private String prName;
	private String address;
	private String pPhone;
	public void setPrName(String name){
		prName=name;
	}
	public String getPrName(){
		return prName;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setPPhone(String phone){
		pPhone=phone;
	}
	public String getPPhone(){
		return pPhone;
	}
}
