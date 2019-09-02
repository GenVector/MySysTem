package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Manager;

public class ManagerDao {
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
		String sql="select count(*) from manager";
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
	public int AddNewManager(Manager m){
		try{
		  Connection conn=getConnection();
		  String sql="insert into manager(mName,mPassword)values(?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, m.getMName());
		  ps.setString(2, m.getMPassword());
		  int row=ps.executeUpdate();
		  ps.close();
		  conn.close();
		  return row;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public void updateManager(String mName,String mPassword){
		   try{
			Connection conn=getConnection();
			String sql="update manager set password=? where mName=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, mPassword);
			ps.setString(2, mName);
			ps.executeUpdate();
			ps.close();
			conn.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		}
	public void deleteManager(String mName){
		Connection conn=getConnection();
		String sql="delete from manager where mName=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, mName);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String checkManager(String mName,String mPassword){
		Connection conn=getConnection();
		Manager m=new Manager();
		String sql="select * from manager where mName=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, mName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				m.setMName(rs.getString("mName"));
				m.setMPassword(rs.getString("mPassword"));
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(m.getMName()!=null)
		  if(m.getMName().equals(mName)&&m.getMPassword().equals(mPassword)){
			  return mName;
		  }
		return "error";
	}
	public Manager findManager(String mName){
		Connection conn=getConnection();
		Manager m=new Manager();
		String sql="select * from manager where mName=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, mName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				m.setMName(rs.getString("mName"));
				m.setMPassword(rs.getString("mPassword"));
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	public static void main(String args[]){
		Manager m=new Manager();
		m.setMName("daisy");
		m.setMPassword("gaiety");
		ManagerDao md=new ManagerDao();
		String s=md.checkManager(m.getMName(), m.getMPassword());
		System.out.print(s);
	}

}
