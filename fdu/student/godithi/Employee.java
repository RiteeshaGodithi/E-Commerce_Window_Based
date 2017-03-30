/******************************************************************************
*	Program Author: Riteesha Godithi for CSCI 6810 Java and the Internet	  *
*	Date: September, 2016													  *
*******************************************************************************/

package fdu.student.godithi;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import fdu.student.godithi.*;


public class Employee
{
	private String ID, FName, LName, Desig, Mobile, Address, Username, Password, Password1, Status;

	public Employee(String id, String UN, String PassW, String PassW1, String FN, String LN, String Mob, String Add, String Sts) {
		ID = id;
		FName = FN;
		LName = LN;
		Mobile = Mob;
		Address = Add;
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Status = Sts;
	}

	public Employee(String UN, String PassW) {
			Username = UN;
			Password = PassW;
		}

public boolean signUp() {
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Employee WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Employee(Emp_ID, Username, Password, FName, LName, Mobile, Address, Status) VALUES ('"+ID+ "','"+Username+ "','"+Password+"','"+FName+"','"+LName+"','"+Mobile+"','"+Address+"','AVAILABLE')"; //Save the username, password and Name
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


public boolean searchEmployee(String Nme) {
		boolean done = !FName.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT FName, LName, Mobile, Address, Status FROM Employee WHERE ID ='"+ID+"'"; //SQL query command
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


    public boolean addEmployee() {
		boolean done = !ID.equals("") && !FName.equals("") && !Mobile.equals("") && Address.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT FName, Mobile, Address FROM Employee WHERE ID ='"+ID+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Employee(ID, Username, Password, FName, LName, Mobile, Address, Status) VALUES ('"+ID+ "','"+Username+"','"+Password+"','"+FName+"','"+LName+"','"+Mobile+"','"+Address+"', 'AVAILABLE')"; //Save the username, password and Name
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

    public boolean deleteEmployee() {
		boolean done = !ID.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "UPDATE Employee SET Status = 'NOT_AVAILABLE' WHERE ID = '"+ID+"'"; //Save the username, password and Name
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

public boolean updateProduct() {
		boolean done = !ID.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "UPDATE Employee SET FName = '"+FName+"', Mobile = '"+Mobile+"', Address = '"+Address+"', Status = '"+Status+"' WHERE ID = '"+ID+"'"; //Save the username, password and Name
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