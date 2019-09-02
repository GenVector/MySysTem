package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import bean.Car;
import bean.User;

public class CarDao {
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
	public List<Car> getCarList(int cPage){
		List<Car> list=new ArrayList<Car>();
		Connection conn=getConnection();
		  String sql="select * from car";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  int beg=(cPage-1)*User.PAGE_SIZE;
		  int end=cPage*User.PAGE_SIZE+1;
		  int i=1;
		  while(rs.next()){
			  if(i>beg&&i<end){
			  Car c=new Car();
			    c.setCarId(rs.getString("carId"));
			    c.setCarType(rs.getString("carType"));
			    c.setCMark(rs.getString("cMark"));
			    c.setColor(rs.getString("color"));
			    c.setIDCard(rs.getString("IDCard"));
			    c.setDate(rs.getString("Date"));
			    list.add(c);
			  }
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Car> getCarList(){
		List<Car> list=new ArrayList<Car>();
		Connection conn=getConnection();
		  String sql="select * from car";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			    Car c=new Car();
			    c.setCarId(rs.getString("carId"));
			    c.setCarType(rs.getString("carType"));
			    c.setCMark(rs.getString("cMark"));
			    c.setColor(rs.getString("color"));
			    c.setIDCard(rs.getString("IDCard"));
			    c.setDate(rs.getString("Date"));
			    list.add(c);
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int findCount(){
		int count=0;		
		String sql="select count(*) from car";
		try{		
			Connection conn = getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	public int AddNewCar(Car c){
		try{
		  Connection conn=getConnection();
		  String sql="insert into car(carId,carType,color,IDCard,Date,cMark)values(?,?,?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, c.getCarId());
		  ps.setString(2, c.getCarType());
		  ps.setString(3, c.getColor());
		  ps.setString(4, c.getIDCard());
		  ps.setString(5, c.getDate());
		  ps.setString(6, c.getCMark());
		  int row=ps.executeUpdate();
		  ps.close();
		  conn.close();
		  return row;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public void deleteCar(String carId){
		Connection conn=getConnection();
		String sql="delete from car where CarId=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, carId);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delCar(String IDCard){
		Connection conn=getConnection();
		String sql="delete from car where IDCard=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, IDCard);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Car> findCars(String IDCard){
		List<Car> list=new ArrayList<Car>();
		Connection conn=getConnection();
		  String sql="select * from car where IDCard=?";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, IDCard);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			  Car c=new Car();
			  c.setCarId(rs.getString("carId"));
			  c.setCarType(rs.getString("carType"));
			  c.setCMark(rs.getString("cMark"));
			  c.setColor(rs.getString("color"));
			  c.setIDCard(IDCard);
			  c.setDate(rs.getString("Date"));
			  list.add(c);
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public Car findCar(String carId){
		Car c=new Car();
		Connection conn=getConnection();
		String sql="select * from car where carId=?";
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, carId);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  c.setCarId(rs.getString("carId"));
				  c.setCarType(rs.getString("carType"));
				  c.setCMark(rs.getString("cMark"));
				  c.setColor(rs.getString("color"));
				  c.setIDCard(rs.getString("IDCard"));
				  c.setDate(rs.getString("Date"));
			  }
			  ps.close();
			  conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return c;
	}
	public String returnIDCard(String carId){
		Connection conn=getConnection();
		String sql="select IDCard from car where carId=?";
		String IDCard="";
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, carId);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  IDCard=rs.getString("IDCard");
			  }
			  ps.close();
			  conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return IDCard;
	}
	public int updateCar(String carId,String carType,String color,String cMark,String date,String IDCard){
		try{
			Connection conn=getConnection();
			String sql="update car set carType=?,color=?,cMark=?,IDCard=?,date=? where carId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, carType);
			ps.setString(2, color);
			ps.setString(3, cMark);
			ps.setString(4, IDCard);
			ps.setString(5, date);
			ps.setString(6, carId);
			int i=ps.executeUpdate();
			ps.close();
			conn.close();
			return i;
		   }catch(Exception e){
			   e.printStackTrace();
			   return 0;
		   }
	}
	public static void main(String args[]){
		CarDao cd=new CarDao();
		Car c=new Car();
		c.setCarId("w");
		c.setCarType("q");
		c.setCMark("e");
		c.setColor("r");
		c.setIDCard("s");
		c.setDate("d");
		int a=cd.findCount();
		System.out.print(a);
	}

}
