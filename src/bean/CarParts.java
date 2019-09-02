package bean;
public class CarParts {
	public static int PAGE_SIZE=10;
	private String carId;
	private String partId;
	private int number;
	private double price;
	private double lineSum;
	private String pName;
	public String getPName(){
		return pName;
	}
	public void setPName(String pName){
		this.pName=pName;
	}
	public double getLineSum(){
		return lineSum;
	}
	public void setLineSum(double lineSum){
		this.lineSum=lineSum;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public String getCarId(){
		return carId;
	}
	public String getPartId(){
		return partId;
	}
	public int getNumber(){
		return number;
	}
	public void setCarId(String carId){
		this.carId=carId;
	}
	public void setPartId(String partId){
		this.partId=partId;
	}
	public void setNumber(int number){
		this.number=number;
	}

}
