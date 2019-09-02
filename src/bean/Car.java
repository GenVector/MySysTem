package bean;

public class Car {
	private String carId;
	private String carType;
	private String color;
	private String IDCard;
	private String Date;
	private String cMark;
	public static int PAGE_SIZE=10;
	public Car(String carId,String carType,String color,String IDCard,String Date,String cMark){
		this.carId=carId;
		this.carType=carType;
		this.color=color;
		this.IDCard=IDCard;
		this.Date=Date;
		this.cMark=cMark;
	}
	public Car(){
		this.carId=null;
		this.carType=null;
		this.cMark=null;
		this.color=null;
		this.Date=null;
		this.IDCard=null;
	}
	public String getDate(){
		return Date;
	}
	public void setDate(String startDate){
		this.Date=startDate;
	}
	public String getCMark(){
		return cMark;
	}
	public void setCMark(String cMark){
		this.cMark=cMark;
	}
	public String getCarId(){
		return carId;
	}
	public void setCarId(String carId){
		this.carId=carId;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getCarType(){
		return carType;
	}
	public void setCarType(String carType){
		this.carType=carType;
	}
	public String getIDCard(){
		return IDCard;
	}
	public void setIDCard(String IDCard){
		this.IDCard=IDCard;
	}

}
