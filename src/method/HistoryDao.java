package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Orders;

public class HistoryDao {
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
	public int AddHistory(Orders o){
		try{
		  Connection conn=getConnection();
		  String sql="insert into history(oId,carId,name,oType,workId,oDate,sum,ifOk,oMark)values(?,?,?,?,?,?,?,?,?)";
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
	public List<Orders> findHistoryList(){
		List<Orders> list=new ArrayList<Orders>();
		Connection conn=getConnection();
		  String sql="select * from history";
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
	public List<Orders> findHistoryList(String name){
		List<Orders> list=new ArrayList<Orders>();
		Connection conn=getConnection();
		  String sql="select * from history where name=?";
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
	public static void main(String args[]){
		HistoryDao hd=new HistoryDao();
		List<Orders> list=hd.findHistoryList();
		for(Orders o:list){
			System.out.println(o.getName()+o.getCarId());
		}
	}
}
