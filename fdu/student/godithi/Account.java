/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

package fdu.student.godithi;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import fdu.student.godithi.*;

public class Account
{
	private String Username, Password, Password1, Name, u, p,id, EmpID;

	public Account(String UN, String PassW, String PassW1, String NM, String empid) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Name = NM;
		EmpID = empid;
	}

	public Account(String UN, String PassW, String PassW1, String NM) {
			Username = UN;
			Password = PassW;
			Password1 = PassW1;
			Name = NM;
	}


	public Account(String UN, String PassW) {
		Username = UN;
		Password = PassW;
	}

    public boolean signUp() {
		System.out.println("Username: "+Username);
		System.out.println("Password: "+Password);
		System.out.println("Password1: "+Password1);
		System.out.println("Name: "+Name);
		System.out.println("EmpID: "+EmpID);
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Account WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Account(Username, Password, Name, Emp_ID) VALUES ('"+Username+ "','"+Password+"','"+Name+"','"+EmpID+"')"; //Save the username, password and Name
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

	public boolean changePassword(String NewPassword) {	//5
		boolean done = false;
		try {		//20
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        if (Rslt.next()) {
				    SQL_Command = "UPDATE Account SET Password='"+NewPassword+"' WHERE Username ='"+Username+"'"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			        Stmt.close();
			        ToDB.closeConn();
                    done=true;
				}
		}
	    catch(java.sql.SQLException e)		//5
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




	//Log-In
	public String LogIn(){
			boolean done = !Username.equals("") && !Password.equals("");
			boolean chk = false;
			String s="";
			try{
				if(done){
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
						        Connection DBConn = ToDB.openConn();
						        Statement Stmt = DBConn.createStatement();
						        String SQL_Command = "SELECT Username, Password, Emp_ID FROM Account WHERE Username ='"+Username+"' AND Password='"+Password+"' "; //SQL query command
						        System.out.println(SQL_Command);
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        while(Rslt.next()){
			        u = Rslt.getString("Username");
			        p = Rslt.getString("Password");
			        id = Rslt.getString("Emp_ID");

				}
			        System.out.println("u" +u);
			        System.out.println("p" +p);
			        System.out.println("id" +id);

			        //done = UserName.equals(u) && Password.equals(p);
			        //if(Username.equals(u) && Password.equals(p)){
						//chk = true;
						if(id != null && !id.equals("")){
							s = "employee,"+id;
						}
						else{
						s = "customer,"+id;
						}

					//}
					//else{s = "invalid";}

			        System.out.println("UserName" +Username);
			        System.out.println("Password" +Password);
					System.out.println("chk" +chk);
			        System.out.println("done" +done);
			        Stmt.close();
				    ToDB.closeConn();
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
			return s;
		}


public String signIn(){
            String val="";
            try {
                        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Account WHERE Username ='"+Username+"' and password='"+Password+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits
                        if(Rslt.next())
                        {
                            String name=Rslt.getString(3);
                            if(Rslt.getString(4)!=null && !Rslt.getString(4).equals("")){
                            //String name=Rslt.getString(3);
                            //if(!eid.equals(""))
                            //{
                                //Employee e=new Employee();
                                //e.setVisible(true);
                                val="employee,"+name;
                            }
                            else
                            {
                                //Customer c=new Customer();
                                //c.setVisible(true);
                                val="customer,"+name;
                            }
                        }
                        else
                        {
                            val="invalid";
                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return val;
        }


        public boolean emailLogIn() {
				boolean done = !Username.equals("") && !Password.equals("");
				System.out.println("Username: " + Username);
				System.out.println("Password: " + Password);
				try {
				    if (done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT Username, Password FROM Account WHERE Username ='"+Username+"' AND Password = '"+Password+"'"; //SQL query command
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        //done = done && !Rslt.next();
System.out.println("d1: " + done);
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
						 System.out.println("d2: " + done);
			    }
			    catch (java.lang.Exception e)
			    {         done = false;
						 System.out.println("Exception: " + e);
						 e.printStackTrace ();
						 System.out.println("d3: " + done);
			    }
			    return done;
			}


}