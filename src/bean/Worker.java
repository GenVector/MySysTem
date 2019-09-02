package bean;

public class Worker {
	public static int PAGE_SIZE=10;
	private String wName;
	private String workId;
	private String wPhone;
	private String wClass;
	private String wSex;
	private String wType;
	private String achieve;
	private int wLine;
	public void NewAch(){
		int a=Integer.parseInt(this.achieve);
		a+=1;
		this.achieve=String.valueOf(a);
	}
	public int getWLine(){
		return wLine;
	}
	public void setWLine(int wLine){
		this.wLine=wLine;
	}
	public String getAchieve(){
		return achieve;
	}
	public void setAchieve(String achieve){
		this.achieve=achieve;
	}
	public String getWName(){
		return wName;
	}
	public void setWName(String wName){
		this.wName=wName;
	}
	public String getWType(){
		return wType;
	}
	public void setWType(String wType){
		this.wType=wType;
	}
	public String getWorkId(){
		return workId;
	}
	public void setWorkId(String workId){
		this.workId=workId;
	}
	public String getWPhone(){
		return wPhone;
	}
	public void setWPhone(String wPhone){
		this.wPhone=wPhone;
	}
	public String getWClass(){
		return wClass;
	}
	public void setWClass(String wClass){
		this.wClass=wClass;
	}
	public String getWSex(){
		return wSex;
	}
	public void setWSex(String wSex){
		this.wSex=wSex;
	}

}
