package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import bean.*;

public class CarPartsDao {
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
	public int findCount(){
		int count=0;		
		String sql="select count(*) from carparts";
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
	public List<CarParts> getPartList(String carId){
		Connection conn=getConnection();
		String sql="select * from carParts where carId=?";
		List<CarParts> list=new ArrayList<CarParts>();
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, carId);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  CarParts cp=new CarParts();
				  cp.setPName(rs.getString("pName"));
				  cp.setLineSum(rs.getDouble("lineSum"));
				  cp.setCarId(rs.getString("CarId"));
				  cp.setNumber(rs.getInt("number"));
				  cp.setPartId(rs.getString("partId"));
				  cp.setPrice(rs.getDouble("price"));
				  list.add(cp);
			  }
			  ps.close();
			  conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return list;
	}
	public void deleteCarParts(String carId){
		Connection conn=getConnection();
		String sql="delete from carparts where carId=?";
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
	public int AddCarParts(CarParts cp){
		try{
		  Connection conn=getConnection();
		  String sql="insert into CarParts(carId,partId,number,price,lineSum,pName)values(?,?,?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, cp.getCarId());
		  ps.setString(2, cp.getPartId());
		  ps.setInt(3, cp.getNumber());
		  ps.setDouble(4, cp.getPrice());
		  ps.setDouble(5, cp.getLineSum());
		  ps.setString(6, cp.getPName());
		  int row=ps.executeUpdate();
		  ps.close();
		  conn.close();
		  return row;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
}
