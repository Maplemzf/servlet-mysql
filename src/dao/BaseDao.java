package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import model.User;

public class BaseDao {
	public static final String url = "jdbc:mysql://127.0.0.1/usermanager";  
	public static final String driver = "com.mysql.jdbc.Driver";  
	public static final String dbuserName = "root";  
	public static final String password = "root";
	public String login(String username,String pass){
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="select * from usertable where username=? and userpass=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				closeAll(conn,ps,rs);
				return "登录成功";
			}else{
				closeAll(conn,ps,rs);
				return "登录失败";
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "登录失败";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "登录失败";
		}
	}
	public String getType(String username){
		String usertype="";
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="select type from usertable where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, username);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				usertype=rs.getString("type");
			}
			closeAll(conn,ps,rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usertype;
	}
	public int reg(User user){
		try {
			int res=0;
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="insert into usertable(username,userpass,usersex,age,type) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpass());
			ps.setString(3, user.getUsersex());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getType());
			res=ps.executeUpdate();
			closeAll(conn,ps,null);
			return res;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int modi(User user){
		try {
			int res=0;
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="update usertable set username=?,userpass=?,usersex=?,age=?,type=? where userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpass());
			ps.setString(3, user.getUsersex());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getType());
			ps.setInt(6, user.getUserid());
			res=ps.executeUpdate();
			closeAll(conn,ps,null);
			return res;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public void delete(int userid){
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="delete from usertable where userid="+userid;
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			closeAll(conn,ps,null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询所有的用户名，用来排重，确保用户名的唯一性
	public List<String> allUserName(){
		List<String> userNames=new LinkedList<String>();
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="select username from usertable";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				userNames.add(rs.getString("username"));
			}
			closeAll(conn,ps,rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userNames;
	}
	public List<User> allUser(){
		List<User> allUser=new LinkedList<User>();
		try {
			allUser = new LinkedList<User>();
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="select * from usertable";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setAge(rs.getInt("age"));
				user.setType(rs.getString("type"));
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setUsersex(rs.getString("usersex"));
				allUser.add(user);
			}
			closeAll(conn,ps,rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allUser;
	}
	public User getUserByName(String name){
		try {
			User user=null;
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,dbuserName,password);
			String sql="select * from usertable where username='"+name+"'";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setAge(rs.getInt("age"));
				user.setType(rs.getString("type"));
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setUsersex(rs.getString("usersex"));
			}
			return user;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
//	public static void main(String[] args) {
//		BaseDao bd=new BaseDao();
//		User user=new User();
//		user.setAge(1);
//		user.setType("普通成员");
//		user.setUsername("sdf");
//		user.setUserpass("sdf");
//		user.setUsersex("女");
//		int s=bd.reg(user);
//		System.out.println(s);
//	}
	public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

