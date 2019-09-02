package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.*;

public class OrderDao {
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
	public int AddNewOrder(Orders o){
		try{
		  Connection conn=getConnection();
		  String sql="insert into orders(oId,carId,name,oType,workId,oDate,sum,ifOk,oMark)values(?,?,?,?,?,?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1,o.getOId());
		  ps.setString(2,o.getCarId());
		  ps.setString(3,o.getName());
		  ps.setString(4,o.getOType());
		  ps.setString(5,o.getWorkId());
		  ps.setString(6,o.getODate());
		  ps.setDouble(7,o.getSum());
		  ps.setString(8,o.getIfOk());
		  ps.setString(9,o.getOMark());
		  int row=ps.executeUpdate();
		  ps.close();
		  conn.close();
		  return row;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public List<Orders> findOrderList(String ifOk){
		List<Orders> list=new ArrayList<Orders>();
		Connection conn=getConnection();
		  String sql="select * from orders where ifOk=?";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, ifOk);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			  Orders o=new Orders();
			  o.setCarId(rs.getString("carId"));
			  o.setIfOk(rs.getString("ifOk"));
			  o.setName(rs.getString("name"));
			  o.setODate(rs.getString("oDate"));
			  o.setOId(rs.getString("oId"));
			  o.setOMark(rs.getString("oMark"));
			  o.setOType(rs.getString("oType"));
			  o.setSum(rs.getDouble("sum"));
			  o.setWorkId(rs.getString("workId"));
			  list.add(o);
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Orders> findOrderList(){
		List<Orders> list=new ArrayList<Orders>();
		Connection conn=getConnection();
		  String sql="select * from orders";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			  Orders o=new Orders();
			  o.setCarId(rs.getString("carId"));
			  o.setIfOk(rs.getString("ifOk"));
			  o.setName(rs.getString("name"));
			  o.setODate(rs.getString("oDate"));
			  o.setOId(rs.getString("oId"));
			  o.setOMark(rs.getString("oMark"));
			  o.setOType(rs.getString("oType"));
			  o.setSum(rs.getDouble("sum"));
			  o.setWorkId(rs.getString("workId"));
			  list.add(o);
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public Orders getOrder(String oId){
		Orders o=new Orders();
		Connection conn=getConnection();
		  String sql="select * from orders where oId=?";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, oId);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			  o.setCarId(rs.getString("carId"));
			  o.setIfOk(rs.getString("ifOk"));
			  o.setName(rs.getString("name"));
			  o.setODate(rs.getString("oDate"));
			  o.setOId(rs.getString("oId"));
			  o.setOMark(rs.getString("oMark"));
			  o.setOType(rs.getString("oType"));
			  o.setSum(rs.getDouble("sum"));
			  o.setWorkId(rs.getString("workId"));
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return o;
	}
	public int findCount(){
		int count=0;		
		String sql="select count(*) from orders";
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
	public int deleteOrder(String oId){
		Connection conn=getConnection();
		String sql="delete from orders where oId=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oId);
			int row=ps.executeUpdate();
			ps.close();
			conn.close();
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public void deleteOrder(String name,String carId){
		Connection conn=getConnection();
		String sql="delete from orders where carId=?";
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
	public List<Orders> findOrders(String name){
		List<Orders> list=new ArrayList<Orders>();
		Connection conn=getConnection();
		  String sql="select * from orders where name=?";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, name);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			  Orders o=new Orders();
			  o.setCarId(rs.getString("carId"));
			  o.setIfOk(rs.getString("ifOk"));
			  o.setName(rs.getString("name"));
			  o.setODate(rs.getString("oDate"));
			  o.setOId(rs.getString("oId"));
			  o.setOMark(rs.getString("oMark"));
			  o.setOType(rs.getString("oType"));
			  o.setSum(rs.getDouble("sum"));
			  o.setWorkId(rs.getString("workId"));
			  list.add(o);
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public Orders findOrder(String carId){
		Orders o=new Orders();
		Connection conn=getConnection();
		  String sql="select * from orders where carId=?";
		try{
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, carId);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			  o.setCarId(rs.getString("carId"));
			  o.setIfOk(rs.getString("ifOk"));
			  o.setName(rs.getString("name"));
			  o.setODate(rs.getString("oDate"));
			  o.setOId(rs.getString("oId"));
			  o.setOMark(rs.getString("oMark"));
			  o.setOType(rs.getString("oType"));
			  o.setSum(rs.getDouble("sum"));
			  o.setWorkId(rs.getString("workId"));
		  }
		  ps.close();
		  conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return o;
	}
	public String newOId(){
		Date time=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyMMddHHmmss");
		String date=df.format(time);
			return date;

	}
	public static void main(String args[]){
		Orders o=new Orders("oId2","carId","name","oType","workId","oDate","ifOk","oMark",20);
		OrderDao od=new OrderDao();
		od.AddNewOrder(o);
	}
}
