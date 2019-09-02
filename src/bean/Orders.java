package bean;

public class Orders {
	public static int PAGE_SIZE=10;
	private String oId;
	private String carId;
	private String name;
	private String oType;
	private String workId;
	private String oDate;
	private double sum;
	private String ifOk;
	private String oMark;
	public Orders(String oId,String carId,String name,String oType,String workId,String oDate,String ifOk,String oMark,double sum){
		this.carId=carId;
		this.ifOk=ifOk;
		this.name=name;
		this.oDate=oDate;
		this.oId=oId;
		this.oMark=oMark;
		this.oType=oType;
		this.sum=sum;
		this.workId=workId;
	}
	public Orders(){
		oId=null;
		carId=null;
		name=null;
		name=null;
		oType=null;
		workId=null;
		oDate=null;
		sum=0;
		ifOk=null;
		oMark=null;
	}
	public void setOId(String oId){
		this.oId=oId;
	}
	public void setCarId(String carId){
		this.carId=carId;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setOType(String oType){
		this.oType=oType;
	}
	public void setWorkId(String workId){
		this.workId=workId;
	}
	public void setODate(String oDate){
		this.oDate=oDate;
	}
	public void setSum(double sum){
		this.sum=sum;
	}
	public void setIfOk(String ifOk){
		this.ifOk=ifOk;
	}
	public void setOMark(String oMark){
		this.oMark=oMark;
	}
	public String getOId(){
		return oId;
	}
	public String getCarId(){
		return carId;
	}
	public String getName(){
		return name;
	}
	public String getOType(){
		return oType;
	}
	public String getODate(){
		return oDate;
	}
	public double getSum(){
		return sum;
	}
	public String getIfOk(){
		return ifOk;
	}
	public String getOMark(){
		return oMark;
	}
	public String getWorkId(){
		return workId;
	}

}
