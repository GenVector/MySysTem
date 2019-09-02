package bean;

public class Parts {
	public static int PAGE_SIZE=10;
	private String pName;
	private String partId;
	private double price;
	private String provider;
	private int pNum;
	public void setPNum(int pNum){
		this.pNum=pNum;
	}
	public int getPNum(){
		return pNum;
	}
	public String getPName(){
		return pName;
	}
	public String getPartId(){
		return partId;
	}
	public double getPrice(){
		return price;
	}
	public String getProvider(){
		return provider;
	}
	public void setPName(String pName){
		this.pName=pName;
	}
	public void setPartId(String partId){
		this.partId=partId;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public void setProvider(String provider){
		this.provider=provider;
	}
	
}
