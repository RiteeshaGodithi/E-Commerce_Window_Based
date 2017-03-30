/******************************************************************************
*	Program Author: Riteesha Godithi for CSCI 6810 Java and the Internet	  *
*	Date: September, 2016													  *
*******************************************************************************/

package fdu.student.godithi;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
//import fdu.student.godithi.*;

public class PublicReviews
{
	private String ID, Cust_ID, Review, Comments, Prod_ID, UName, PName, rating, review;;


	public PublicReviews(String Id, String CustID, String Rev, String Cmts, String ProdID) {
		ID = Id;
		Cust_ID = CustID;
		Review = Rev;
		Comments = Cmts;
		Prod_ID = ProdID;

	}

	public PublicReviews() {

	}

	public PublicReviews(String uname, String pname, String rat, String rev){
		UName = uname;
		PName = pname;
		rating = rat;
		review = rev;
	}



    public boolean addProduct() {

		boolean done = !ID.equals("") && !Cust_ID.equals("") && !Review.equals("") && !Comments.equals("") && !Prod_ID.equals("");
		System.out.println("done1" +done);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = new Date();

		String frmtdDate = dateFormat.format(date);

System.out.println("frmtdDate: " + frmtdDate);
		try {
		    if (done) {
				System.out.println("done" +done);
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT ID, Cust_ID, Review, Comments, Prod_ID FROM Prod_Cust_Reln WHERE Prod_ID ='"+Prod_ID+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Prod_Cust_Reln(ID, Cust_ID, Review, Comments, Date, Prod_ID) VALUES ('"+ID+ "','"+Cust_ID+"','"+Review+"','"+Comments+"','"+frmtdDate+"','"+Prod_ID+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
				    System.out.println("Query" +SQL_Command);
				    JOptionPane.showMessageDialog(null, "Thank you for your Review", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			    }
			    else{
					JOptionPane.showMessageDialog(null, "Insertion Failed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
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




public boolean addReview() {

		boolean done = !UName.equals("") && !PName.equals("") && !review.equals("") && !rating.equals("");
		System.out.println("done1" +done);

		try {
		    if (done) {
				System.out.println("done" +done);
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT UserName, ProductName, Rating, Review FROM Review WHERE ProductName ='"+PName+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Review(UserName, ProductName, Rating, Review) VALUES ('"+UName+ "','"+PName+"','"+rating+"','"+review+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
				    System.out.println("Query" +SQL_Command);
				    JOptionPane.showMessageDialog(null, "Thank you for your Review", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			    }
			    else{
					JOptionPane.showMessageDialog(null, "Insertion Failed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
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


}