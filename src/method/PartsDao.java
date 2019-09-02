package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import bean.*;

public class PartsDao {
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
		String sql="select count(*) from parts";
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
	public int updatePart(String partId,int num){
		 try{
				Connection conn=getConnection();
				String sql="update parts set pNum=? where partId=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, num);
				ps.setString(2, partId);
				int i=ps.executeUpdate();
				ps.close();
				conn.close();
				return i;
			   }catch(Exception e){
				   e.printStackTrace();
				   return 0;
			   }
	}
	public int AddNewParts(Parts p){
		try{
		  Connection conn=getConnection();
		  String sql="insert into Parts(pName,partId,price,provider)values(?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, p.getPName());
		  ps.setString(2, p.getPartId());
		  ps.setDouble(3, p.getPrice());
		  ps.setString(4, p.getProvider());
		  int row=ps.executeUpdate();
		  ps.close();
		  conn.close();
		  return row;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public void deletePart(String partId){
		Connection conn=getConnection();
		String sql="delete from parts where partId=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, partId);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Parts getParts(String partId){
		Connection conn=getConnection();
		Parts p=new Parts();
		String sql="select * from parts where partId=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, partId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				p.setPartId(rs.getString("partId"));
				p.setPName(rs.getString("pName"));
				p.setPNum(rs.getInt("pNum"));
				p.setPrice(rs.getDouble("price"));
				p.setProvider(rs.getString("provider"));
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	public List<Parts> getPartList(int page){
		List<Parts> list=new ArrayList<Parts>();
		Connection conn=getConnection();
		String sql="select * from parts";
		try{
			int beg=(page-1)*Parts.PAGE_SIZE;
			int end=page*Parts.PAGE_SIZE+1;
			int i=1;
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			  if(i>beg&&i<end){
				    Parts p=new Parts();
					p.setPartId(rs.getString("partId"));
					p.setPName(rs.getString("pName"));
					p.setPNum(rs.getInt("pNum"));
					p.setPrice(rs.getDouble("price"));
					p.setProvider(rs.getString("provider"));
					list.add(p);
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
	public List<Parts> getPartList(){
		List<Parts> list=new ArrayList<Parts>();
		Connection conn=getConnection();
		String sql="select * from parts";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				    Parts p=new Parts();
					p.setPartId(rs.getString("partId"));
					p.setPName(rs.getString("pName"));
					p.setPNum(rs.getInt("pNum"));
					p.setPrice(rs.getDouble("price"));
					p.setProvider(rs.getString("provider"));
					list.add(p);
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
	public List<Parts> getPartList(String key){
		Connection conn=getConnection();
		List<Parts> list=new ArrayList<Parts>();
		String sql="select * from parts where pName like '%"+key+"%'";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,key);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Parts p=new Parts();
				p.setPartId(rs.getString("partId"));
				p.setPName(rs.getString("pName"));
				p.setPNum(rs.getInt("pNum"));
				p.setPrice(rs.getDouble("price"));
				p.setProvider(rs.getString("provider"));
				list.add(p);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String args[]){
		PartsDao pd=new PartsDao();
		Parts p=new Parts();
		p.setPartId("s");
		p.setPName("s");
		p.setPrice(2);
		p.setProvider("xx");
		pd.deletePart("s");
	}

}
