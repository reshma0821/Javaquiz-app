package com.web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utility.DBConnection;

import jakarta.servlet.RequestDispatcher;

public class EmployeeDAO implements  EmployeeDAOInterface   {
	
	
	 public  List<Employees> getAll() {
		 
			List<Employees> li =new ArrayList<Employees>();
	 
	    	try {
	    		DBConnection dbc=new DBConnection();
	    		Connection con=dbc.getConnection();
	    		PreparedStatement ps=con.prepareStatement("select * from users");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
	Employees c=new Employees(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
					li.add(c);
				
				}
	    	}catch(Exception e) {	
	    		System.out.println(e);
	        }
			return li;
		   
	 }
public	void save(String Username,String Email,String Password,int Id) {
	DBConnection dbc=new DBConnection();
		Connection con=dbc.getConnection();
		  String sql = "Update users set username=?,email=?,password=? where id=?";
		  System.out.println("=========");
	         try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,Username );
				ps.setString(2,Email);
				ps.setString(3, Password);
				ps.setInt(4, Id);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	 
	public Employees Update(int id) {
		 Employees e1=null;
	 try {
		
		 DBConnection dbc=new DBConnection();
 		Connection con=dbc.getConnection();

         String sql = "select * from users where id=?";
         PreparedStatement ps = con.prepareStatement(sql);
//         ps.setString(1, name);
//         ps.setString(2, email);
//         ps.setString(3, password);
         ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
          if(rs.next()) {
         	e1=new Employees( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
         	 
          }
          
         ps.close();
         con.close();

     } catch (Exception ex) {
         ex.printStackTrace();
        
     }
	
	return e1;
 }
	 public  Employees verify(String username,String pwd) {
		 Employees c=null;
	 
	    	try {
	    		DBConnection dbc=new DBConnection();
	    		Connection con=dbc.getConnection();
	    		PreparedStatement ps=con.prepareStatement("select * from users where username=? and password=?");
	   
				ps.setString(1,username);
				ps.setString(2,pwd);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					c=new Employees(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				}
	    	}catch(Exception e) {	
	    		System.out.println(e);
	        }
			return c;
		   
	 }
	
	 String status="fail";
    public  String insertEmployee(Employees l) {
    	try {
    		DBConnection dbc=new DBConnection();
    		Connection con=dbc.getConnection();
    		PreparedStatement ps=con.prepareStatement("insert into users (username,email,password)values(?,?,?)");
   
			ps.setString(1,l.getUsername());
			ps.setString(2, l.getEmail());
			ps.setString(3,l.getPassword());
			int n=ps.executeUpdate();
			
        if(n>0) {
        	System.out.println(n+"rows insert successfully");
        	status="SUCCESS";
           }else {
        	   
           System.out.println("sorry ");
           }
    	}
    		
          catch(Exception e) {
        	
        System.out.println(e);
        }
		return status;
		
	   }
    public  boolean delete(int id) {
		 boolean b=false;
	 
	    	try {
	    		DBConnection dbc=new DBConnection();
	    		Connection con=dbc.getConnection();
	    		PreparedStatement ps=con.prepareStatement("delete from users where id=?");
				ps.setInt(1, id);
				 int n = ps.executeUpdate();
				if(n>0) {
					b=true;
				}
	    	}catch(Exception e) {	
	    		System.out.println(e);
	        }
			return b;
		
	 }


}
