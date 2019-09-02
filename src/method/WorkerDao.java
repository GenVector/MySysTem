package method;
import bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class WorkerDao {
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
		String sql="select count(*) from worker";
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
	public List<Worker> getWorkerList(int page){
		List<Worker> list=new ArrayList<Worker>();
		Connection conn=getConnection();
		String sql="select * from worker";
		try{
			int beg=(page-1)*Worker.PAGE_SIZE;
			int end=page*Worker.PAGE_SIZE+1;
			int i=1;
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			  if(i>beg&&i<end){
					Worker w=new Worker();
					w.setAchieve(rs.getString("achieve"));
				    w.setWClass(rs.getString("wClass"));
					w.setWName(rs.getString("wName"));
					w.setWorkId(rs.getString("workId"));
					w.setWPhone(rs.getString("wPhone"));
					w.setWSex(rs.getString("wSex"));
					w.setWType(rs.getString("wType"));
					w.setWLine(rs.getInt("wLine"));
				    list.add(w);
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
	public List<Worker> getWorkerList(){
		List<Worker> list=new ArrayList<Worker>();
		Connection conn=getConnection();
		String sql="select * from worker";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
					Worker w=new Worker();
					w.setAchieve(rs.getString("achieve"));
				    w.setWClass(rs.getString("wClass"));
					w.setWName(rs.getString("wName"));
					w.setWorkId(rs.getString("workId"));
					w.setWPhone(rs.getString("wPhone"));
					w.setWSex(rs.getString("wSex"));
					w.setWType(rs.getString("wType"));
					w.setWLine(rs.getInt("wLine"));
				    list.add(w);
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
	public int AddNewWorker(Worker w){
		try{
		  Connection conn=getConnection();
		  String sql="insert into worker(wName,workId,wPhone,wClass,wSex,wLine,wType,achieve)values(?,?,?,?,?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, w.getWName());
		  ps.setString(2, w.getWorkId());
		  ps.setString(3, w.getWPhone());
		  ps.setString(4, w.getWClass());
		  ps.setString(5, w.getWSex());
		  ps.setInt(6, w.getWLine());
		  ps.setString(7, w.getWType());
		  ps.setString(8, w.getAchieve());
		  int row=ps.executeUpdate();
		  ps.close();
		  conn.close();
		  return row;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public void deleteWorker(String workId){
		Connection conn=getConnection();
		String sql="delete from worker where workId=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, workId);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Worker findWorker(String workId){
		Connection conn=getConnection();
		Worker w=new Worker();
		String sql="select * from worker where workId=?";
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, workId);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  w.setAchieve(rs.getString("achieve"));
				  w.setWClass(rs.getString("wClass"));
				  w.setWName(rs.getString("wName"));
				  w.setWorkId(workId);
				  w.setWPhone(rs.getString("wPhone"));
				  w.setWSex(rs.getString("wSex"));
				  w.setWType(rs.getString("wType"));
				  w.setWLine(rs.getInt("wLine"));
			  }
			  ps.close();
			  conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		return w;
	}
	public List<Worker> returnWList(){
		Connection conn=getConnection();
		String sql="select * from worker";
		List<Worker> l=new ArrayList<Worker>();
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  Worker w=new Worker();
				  w.setAchieve(rs.getString("achieve"));
				  w.setWClass(rs.getString("wClass"));
				  w.setWName(rs.getString("wName"));
				  w.setWorkId(rs.getString("workId"));
				  w.setWPhone(rs.getString("wPhone"));
				  w.setWSex(rs.getString("wSex"));
				  w.setWType(rs.getString("wType"));
				  w.setWLine(rs.getInt("wLine"));
				  l.add(w);
			  }
			  ps.close();
			  conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		return l;
	}
	public static void main(String args[]){
		WorkerDao wd=new WorkerDao();
		Worker w=wd.findWorker("1004");
		System.out.print(w.getWName());
	}

	
}
