package method;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Article {
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
		String sql="select count(*) from article";
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
	public StringBuffer getArticle(String artName) throws IOException{
		FileInputStream file=new FileInputStream(artName);
		InputStreamReader reader=new InputStreamReader(file,"UTF-8");
		BufferedReader br=new BufferedReader(reader);
		StringBuffer str=new StringBuffer("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		String s;
		while((s=br.readLine())!=null){
			str=str.append(s+"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		br.close();
		return str;
	}
	public void addArticle(String name){
		Connection conn=getConnection();
		String sql="insert into article(artName)values(?)";
		try{
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.executeUpdate();
		ps.close();
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int deleteArticle(String name){
		Connection conn=getConnection();
		String sql="delete from article where artName=?";
		int i;
		try{
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		i=ps.executeUpdate();
		ps.close();
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return i;
	}
	public List<String> getArtList(){
		Connection conn=getConnection();
		List<String> list=new ArrayList<String>();
		String sql="select * from Article";
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  String name=rs.getString("artName");
				  list.add(name);
			  }
			  ps.close();
			  conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return list;
	}
	public List<String> getList(String key){
		Connection conn=getConnection();
		List<String> list=new ArrayList<String>();
		String sql="select * from Article where artName like '%"+key+"%'";
		try{
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  String name=rs.getString("artName");
				  list.add(name);
			  }
			  ps.close();
			  conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return list;
		
	}
	public static void  main(String args[]) throws IOException{
		Article a=new Article();
		List<String> l=a.getList("°ÂµÏ");
		for(String s:l)
		System.out.println(s);
		int n=a.findCount();
		System.out.print(n);
	
	}
}