/******************************************************************************
*	Program Author: Riteesha Godithi for CSCI 6810 Java and the Internet	  *
*	Date: September, 2016													  *
*******************************************************************************/

package fdu.student.godithi;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import fdu.student.godithi.*;

public class Customer
{
	private String UserName, Password, FName, LName, Mobile, Address, Password1, u, p;

	public Customer(String UNme, String Pwd, String Pwd1, String Fnme, String Lnme, String Mob, String Add) {
		UserName = UNme;
		Password = Pwd;
		Password1 = Pwd1;
		FName = Fnme;
		LName = Lnme;
		Mobile = Mob;
		Address = Add;

	}

	public Customer(String UN, String PassW) {
				UserName = UN;
				Password = PassW;
			}

public boolean signUp() {
		boolean done = !UserName.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Customer WHERE Username ='"+UserName+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Customer(Username, Password, FName, LName, Mobile, Address) VALUES ('"+UserName+ "','"+Password+"','"+FName+"','"+LName+"','"+Mobile+"','"+Address+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			    }
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}


	public boolean signIn(){
		boolean done = !UserName.equals("") && !Password.equals("");
		try{
			if(done){
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
					        Connection DBConn = ToDB.openConn();
					        Statement Stmt = DBConn.createStatement();
					        String SQL_Command = "SELECT Username, Password FROM Customer WHERE Username ='"+UserName+"' AND Password='"+Password+"' "; //SQL query command
					        System.out.println(SQL_Command);
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        while(Rslt.next()){
		        u = Rslt.getString("Username");
		        p = Rslt.getString("Password");
		        //done = UserName.equals(u) && Password.equals(p);
		        if(UserName == u && Password == p){
					done = true;
				}
				else{done = false;}
			}
		        System.out.println("UserName" +UserName);
		        System.out.println("Password" +Password);
		        System.out.println(u);
		        System.out.println(p);
		        System.out.println(done);
		        Stmt.close();
			    ToDB.closeConn();
		}
	}
		catch(Exception e){
			e.printStackTrace();
		}
		return done;
	}

	public boolean searchCustomer() {
			boolean done = !UserName.equals("") && !Password.equals("") && !FName.equals("") && !LName.equals("") && !Mobile.equals("") && Address.equals("");
			try {
			    if (done) {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT Fname, Lname, Mobile, Address FROM Customer WHERE Username ='"+UserName+"'"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        Stmt.close();
				    ToDB.closeConn();
				}
			}
		    catch(java.sql.SQLException e)
		    {         done = false;
					 System.out.println("SQLException: " + e);
					 while (e != null)
					 {   System.out.println("SQLState: " + e.getSQLState());
						 System.out.println("Message: " + e.getMessage());
						 System.out.println("Vendor: " + e.getErrorCode());
						 e = e.getNextException();
						 System.out.println("");
					 }
		    }
		    catch (java.lang.Exception e)
		    {         done = false;
					 System.out.println("Exception: " + e);
					 e.printStackTrace ();
		    }
		    return done;
		}


    public boolean addCustomer() {
		boolean done = !UserName.equals("") && !Password.equals("") && !FName.equals("") && !LName.equals("") && !Mobile.equals("") && Address.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "INSERT INTO Customer(Username, Password, Fname, Lname, Mobile, Address) VALUES ('"+UserName+"','"+Password+"','"+FName+"','"+LName+"','"+Mobile+"','"+Address+"')"; //Save the username, password and Name
				Stmt.executeUpdate(SQL_Command);
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}

    public boolean deleteCustomer() {
		boolean done = !UserName.equals("") && !Password.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "DELETE FROM Customer WHERE Username = '"+UserName+"'"; //Save the username, password and Name
				Stmt.executeUpdate(SQL_Command);
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}

public boolean updateCustomer() {
		boolean done = !UserName.equals("") && !Password.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "UPDATE Customer SET Fname = '"+FName+"',, Lname = '"+LName+"' Mobile = '"+Mobile+"', Address = '"+Address+"' WHERE Username = '"+UserName+"'"; //Save the username, password and Name
				Stmt.executeUpdate(SQL_Command);
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}
}