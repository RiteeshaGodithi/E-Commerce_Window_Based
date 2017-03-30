/******************************************************************************
*	Program Author: Riteesha Godithi for CSCI 6810 Java and the Internet	  *
*	Date: September, 2016													  *
*******************************************************************************/

package fdu.student.godithi;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;

public class Email
{

	private String MsgTo, MsgFrom, Subject, Body;



	public Email(String msgTo, String msgFrom, String subject, String body) {
		super();
		MsgTo = msgTo;
		MsgFrom = msgFrom;
		Subject = subject;
		Body = body;

	}

	public Email() {

	}



public boolean showEmails(String MsgFrom) {
		boolean done = !MsgFrom.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Body FROM Message WHERE MessageFrom ='"+MsgFrom+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
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

/*public int addProd(){
	System.out.println("www");
		DBConnection ToDB = new DBConnection();
		Connection con = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String query = "insert into Product values (?, ?, ?, ?, ?)";
		try {
			con = ToDB.openConn();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ProductID);
			pstmt.setString(2, ProductName);
			pstmt.setString(3, ProductQuantity);
			pstmt.setString(4, ProductPrice);
			pstmt.setString(5, ProductDescription);

			res = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}*/


    public boolean addEmail() {
		boolean done = !MsgFrom.equals("") && !MsgTo.equals("") && !Subject.equals("") && !Body.equals("");
		System.out.println("done1" +done);
		try {
		    if (done) {
				System.out.println("done" +done);
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Subject, Body FROM Message WHERE MessageFrom ='"+MsgFrom+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		       // done = done && !Rslt.next();
		        System.out.println("SQL_Command" +SQL_Command);
		        System.out.println("done2" +done);
		        if (done) {
				    SQL_Command = "INSERT INTO Message(MessageTo, MessageFrom, Subject, Body) VALUES ('"+MsgTo+ "','"+MsgFrom+"','"+Subject+"','"+Body+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
				    System.out.println("Query" +SQL_Command);
				    JOptionPane.showMessageDialog(null, "Email Sent", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			    }
			    else{
					JOptionPane.showMessageDialog(null, "Email not sent Failed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
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

    public boolean deleteEmail() {
		boolean done = !MsgTo.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "DELETE Message WHERE MessageTo = '"+MsgTo+"'"; //Save the username, password and Name
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