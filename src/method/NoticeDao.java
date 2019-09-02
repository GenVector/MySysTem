package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Notice;

public class NoticeDao {
	public Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carsystem?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String username="root";
			String password="gsy231514";
			conn=DriverManager.getConnection(url,username,password);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	public void updateNotice(String weather,String road,String oil90,String oil93,String oil97,String benefit,String city){
		try{
			Connection conn=getConnection();
			String sql="update Notice set weather=?,road=?,oil90=?,oil93=?,oil97=?,benefit=? where city=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, weather);
			ps.setString(2, road);
			ps.setString(3, oil90);
			ps.setString(4, oil93);
			ps.setString(5, oil97);
			ps.setString(6, benefit);
			ps.setString(7, city);
			ps.executeUpdate();
			ps.close();
			conn.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	}
	public Notice getNotic(String city){
		Notice n=new Notice();
		Connection conn=getConnection();
		String sql="select * from Notice where city=?";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, city);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
		   	n.setRoad(rs.getString("road"));;
		   	n.setOil90(rs.getString("oil90"));
		   	n.setWeather(rs.getString("weather"));
		   	n.setOil93(rs.getString("oil93"));
		   	n.setOil97(rs.getString("oil97"));
		   	n.setBenefit(rs.getString("benefit"));
		   	n.setCity(rs.getString("city"));
		                }
		
		ps.close();
		conn.close();
		} 
	catch (SQLException e) {
		e.printStackTrace();
	
}
	return n;
	}


   public static void main(String args[]){
	   NoticeDao nd=new NoticeDao();
	   Notice n=nd.getNotic("西安");
	   nd.updateNotice(n.getWeather(), n.getRoad(), n.getOil90(), n.getOil93(), n.getOil97(),"今日双号车洗车免费","西安");
	   System.out.print(n.getCity());
	   
   }
}