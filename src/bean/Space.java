package bean;

public class Space {
	private String spaceId;
	private String carId="spare";
	public String getCarId(){
		return carId;
	}
	public String getSpaceId(){
		return spaceId;
	}
	public void setSpaceId(String spaceId){
		this.spaceId=spaceId;
	}
	public void setCarId(String carId){
		this.carId=carId;                //逻辑上可能存在问题，以后记得回头看看
	}

}
