package bean;

public class Notice {
	public static int PAGE_SIZE=10;
	private String city;
	private String weather;
	private String road;
	private String oil90;
	private String oil93;
	private String oil97;
	private String benefit;
	public String getBenefit(){
		return benefit;
	}
	public void setBenefit(String benefit){
		this.benefit=benefit;
	}
	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getWeather(){
		return weather;
	}
	public String getRoad(){
		return road;
	}
	public String getOil90(){
		return oil90;
	}
	public String getOil93(){
		return oil93;
	}
	public String getOil97(){
		return oil97;
	}
	public void setWeather(String weather){
		this.weather=weather;
	}
	public void setRoad(String road){
		this.road=road;
	}
	public void setOil90(String oil90){
		this.oil90=oil90;
	}
	public void setOil93(String oil93){
		this.oil93=oil93;
	}
	public void setOil97(String oil97){
		this.oil97=oil97;
	}

}
