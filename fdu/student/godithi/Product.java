/******************************************************************************
*	Program Author: Riteesha Godithi for CSCI 6810 Java and the Internet	  *
*	Date: September, 2016													  *
*******************************************************************************/

package fdu.student.godithi;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;

public class Product
{

	private String ID, Name, Quantity, Price, Descp;



	public Product(String id, String Nme, String Qty, String Prc, String Desc) {
		super();
		ID = id;
		Name = Nme;
		Quantity = Qty;
		Price = Prc;
		Descp = Desc;

	}

	public Product() {

	}


		public ArrayList<Product> searchByName(String name) {
			System.out.println("qqqq" +name);
			DBConnection ToDB = new DBConnection();
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs1 = null;
			String query = "SELECT * FROM Product WHERE Name like '%"+name+"%'";
			System.out.println("query" +query);
			ArrayList<Product> retProduct = new ArrayList<Product>();
			try{
				con = ToDB.openConn();
				pst = con.prepareStatement(query);
	                        System.out.println("name "+name);
				//pst.setString(1, name);
				rs1 = pst.executeQuery();
	                        int i=0;
				while(rs1.next()){
	                            i=1;
					//retProduct.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8), rs.getLong(9), rs.getString(10)));
				}
	                        if(i==0) //no data
	                        {
	                            System.out.println("entered 0");
	                            retProduct.add(null);
	                        }
	                        else if(i==1)
	                        {
	                            System.out.println("enered 1");
	                            ResultSet rs=pst.executeQuery();
	                            while(rs.next())
	                            {
	                                //System.out.println("-"+rs.getString(1));
	                                retProduct.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
	                            }
	                        }
				ToDB.closeConn();
			}catch(SQLException e){
				e.printStackTrace();
			}
	                //System.out.println("size "+retProduct.size());
			return retProduct;
		}

		public ArrayList<Product> esearchByName(String name) {
				DBConnection ToDB = new DBConnection();
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs1 = null;
				String query = "SELECT * FROM Product WHERE Prod_ID = ?";
				System.out.println("QUERY" +query);
				ArrayList<Product> retProduct = new ArrayList<Product>();
				try{
					con = ToDB.openConn();
					pst = con.prepareStatement(query);
		                        //System.out.println("name "+name);
					pst.setString(1, name);
					rs1 = pst.executeQuery();
		                        int i=0;
					while(rs1.next()){
		                            i=1;
						//retProduct.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8), rs.getLong(9), rs.getString(10)));
					}
		                        if(i==0) //no data
		                        {
		                            //System.out.println("entered 0");
		                            retProduct.add(null);
		                        }
		                        else if(i==1)
		                        {
		                            //System.out.println("enered 1");
		                            ResultSet rs=pst.executeQuery();
		                            while(rs.next())
		                            {
		                                //System.out.println("-"+rs.getString(1));
		                                retProduct.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		                            }
		                        }
					ToDB.closeConn();
				}catch(SQLException e){
					e.printStackTrace();
				}
		                //System.out.println("size "+retProduct.size());
				return retProduct;
		}



public boolean searchProduct(String Name) {
		boolean done = !Name.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Name, Quantity, Price, Descp FROM Product WHERE Name ='"+Name+"'"; //SQL query command
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


    public boolean addProduct() {
		System.out.println("q "+ID);
				System.out.println("q "+Name);
				System.out.println("q "+Quantity);
				System.out.println("q "+Price);
		System.out.println("q "+Descp);
		boolean done = !ID.equals("") && !Name.equals("") && !Quantity.equals("") && !Price.equals("") && !Descp.equals("");
		System.out.println("done1" +done);
		try {
		    if (done) {
				System.out.println("done" +done);
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Name, Quantity, Price, Descp FROM Product WHERE Prod_ID ='"+ID+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Product(Prod_ID, Name, Quantity, Price, Descp) VALUES ('"+ID+ "','"+Name+"','"+Quantity+"','"+Price+"','"+Descp+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
				    System.out.println("Query" +SQL_Command);
				    JOptionPane.showMessageDialog(null, "Product Inserted", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
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

    public boolean deleteProduct() {
		boolean done = !ID.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "UPDATE Product SET Quantity = 'OUT_OF_STOCK' WHERE Prod_ID = '"+ID+"'"; //Save the username, password and Name
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
		        String SQL_Command = "UPDATE Product SET Name = '"+Name+"', Quantity = '"+Quantity+"', Price = '"+Price+"', Descp = '"+Descp+"' WHERE Prod_ID = '"+ID+"'"; //Save the username, password and Name
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

		public String getProductID() {
			return ID;
		}
		public void setProductID(String productID) {
			ID = productID;
		}
		public String getProductName() {
			return Name;
		}
		public void setProductName(String productName) {
			Name = productName;
		}
		public String getProductDescription() {
			return Descp;
		}
		public void setProductDescription(String productDescription) {
			Descp = productDescription;
		}
		public String getProductQuantity() {
			return Quantity;
		}
		public void setProductQuantity(String productQuantity) {
			Quantity = productQuantity;
		}
		public String getProductPrice() {
			return Price;
		}
		public void setProductPrice(String productPrice) {
			Price = productPrice;
		}

}