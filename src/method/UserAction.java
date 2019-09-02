package method;

import bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserAction {
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
		String sql="select count(*) from user";
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
	public List<User> getUserList(String key){
		Connection conn=getConnection();
		List<User> list=new ArrayList<User>();
		String sql="select * from user where name like '%"+key+"%'";
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				    User u=new User();	
					u.setIDCard(rs.getString("IDCard"));
					u.setName(rs.getString("name"));
					u.setPassword(rs.getString("password"));
					u.setPhone(rs.getString("phone"));
					u.setSex(rs.getString("sex"));
					list.add(u);
			  }
			  ps.close();
			  conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return list;
		
	}
	public List<User> getUserList(int page){
		List<User> list=new ArrayList<User>();
		Connection conn=getConnection();
		String sql="select * from user";
		try{
			int beg=(page-1)*User.PAGE_SIZE;
			int end=page*User.PAGE_SIZE+1;
			int i=1;
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(i>beg&&i<end){
				User u=new User();	
				u.setIDCard(rs.getString("IDCard"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setSex(rs.getString("sex"));
				list.add(u);
				}
				i++;
			}
		   rs.close();
		   ps.close();
		   conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	public List<User> getUserList(){
		List<User> list=new ArrayList<User>();
		Connection conn=getConnection();
		String sql="select * from user";
		try{
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();	
				u.setIDCard(rs.getString("IDCard"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setSex(rs.getString("sex"));
				list.add(u);
				
			}
		   rs.close();
		   ps.close();
		   conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	public int AddNewUser(User u){
		try{
		  Connection conn=getConnection();
		  String sql="insert into user(idcard,name,sex,phone,password)values(?,?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, u.getIDCard());
		  ps.setString(2, u.getName());
		  ps.setString(3, u.getSex());
		  ps.setString(4, u.getPhone());
		  ps.setString(5, u.getPassword());
		  int row=ps.executeUpdate();
		  ps.close();
		  conn.close();
		  return row;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public void updatePassword(String password,String newpassword){
		   try{
			Connection conn=getConnection();
			String sql="update user set password=? where password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, newpassword);
			ps.setString(2, password);
			ps.executeUpdate();
			ps.close();
			conn.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		}
	public void updatePasswords(String name,String newpassword){
		   try{
			Connection conn=getConnection();
			String sql="update user set password=? where name=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, newpassword);
			ps.setString(2, name);
			ps.executeUpdate();
			ps.close();
			conn.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		}
	public void updateUser(String IDCard,String name,String sex,String phone){
		try{
			Connection conn=getConnection();
			String sql="update user set name=?,sex=?,phone=? where IDCard=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, sex);
			ps.setString(3, phone);
			ps.setString(4, IDCard);
			ps.executeUpdate();
			ps.close();
			conn.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	}
	public int deleteUser(String IDCard){
		Connection conn=getConnection();
		String sql="delete from user where IDCard=?";
		int i=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, IDCard);
			i=ps.executeUpdate();
			ps.close();
			conn.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public User checkUser(String name,String password){
		User u=new User();
		try {
			Connection conn=getConnection();
			String sql="select * from user where name=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			   	u.setIDCard(rs.getString("IDCard"));
			   	u.setName(rs.getString("name"));
			   	u.setPassword(rs.getString("password"));
			   	u.setPhone(rs.getString("phone"));
			   	u.setSex(rs.getString("sex"));
			                }
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		
	}
		if(u.getName()!=null){
			if(u.getPassword().equals(password)){
			  return u;
			  }
		}
	          return null;
		}
	public User findUser(String IDCard){
		User u=new User();
		try {
			Connection conn=getConnection();
			String sql="select * from user where IDCard=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, IDCard);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			   	u.setIDCard(rs.getString("IDCard"));
			   	u.setName(rs.getString("name"));
			   	u.setPassword(rs.getString("password"));
			   	u.setPhone(rs.getString("phone"));
			   	u.setSex(rs.getString("sex"));
			                }
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		
	}
		return u;
	}
	
	public static void main(String args[]){
		UserAction ua=new UserAction();
		User u=new User();
		u.setIDCard("140121199504287816");
		u.setPassword("940715");
		u.setName("liu");
		u.setPhone("18829236368");
		u.setSex("female");
		String s="";
		int a=Integer.parseInt(s);
		List<User> l=ua.getUserList(a);
		System.out.println(l.get(0).getName());
	}

}
