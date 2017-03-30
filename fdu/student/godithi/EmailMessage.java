package fdu.student.godithi;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmailMessage implements Serializable{
	private String From;
	private String To;
	private String Message;
	private String Subject;

        public EmailMessage(){}

        public EmailMessage(String from, String to, String sub, String message)
        {
            super();
            From=from;
            To=to;
            Subject=sub;
            Message=message;
        }

        public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
        public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
        public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}

     public String getSubject() {
	 		return Subject;
	 	}
	 	public void setSubject(String sub) {
	 		Subject = sub;
	}

        public ArrayList<EmailMessage> recieveMessage(String name) {
		DBConnection ToDB = new DBConnection();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs1 = null;
		String query = "SELECT * FROM Message where MessageTo=?";
		ArrayList<EmailMessage> retDetails = new ArrayList<EmailMessage>();
		try{
			con = ToDB.openConn();
			pst = con.prepareStatement(query);
                        //System.out.println("name "+name);
			pst.setString(1, name);
			rs1 = pst.executeQuery();
                        int i=0;
			while(rs1.next()){
                            i=1;

			}
                        if(i==0) //no data
                        {
                            //System.out.println("entered 0");
                            retDetails.add(null);
                        }
                        else if(i==1)
                        {
                            //System.out.println("enered 1");
                            ResultSet rs=pst.executeQuery();
                            while(rs.next())
                            {
                                //System.out.println("-"+rs.getString(1));
                                retDetails.add(new EmailMessage(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                            }
                        }
			ToDB.closeConn();
		}catch(SQLException e){
			e.printStackTrace();
		}
                //System.out.println("size "+retProduct.size());
		return retDetails;
	}

        public ArrayList<EmailMessage> sentMessage(String name) {
		DBConnection ToDB = new DBConnection();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs1 = null;
		String query = "SELECT * FROM Message where MessageFrom=?";
		ArrayList<EmailMessage> retDetails = new ArrayList<EmailMessage>();
		try{
			con = ToDB.openConn();
			pst = con.prepareStatement(query);
                        //System.out.println("name "+name);
			pst.setString(1, name);
			rs1 = pst.executeQuery();
                        int i=0;
			while(rs1.next()){
                            i=1;

			}
                        if(i==0) //no data
                        {
                            //System.out.println("entered 0");
                            retDetails.add(null);
                        }
                        else if(i==1)
                        {
                            //System.out.println("enered 1");
                            ResultSet rs=pst.executeQuery();
                            while(rs.next())
                            {
                                //System.out.println("-"+rs.getString(1));
                                retDetails.add(new EmailMessage(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                            }
                        }
			ToDB.closeConn();
		}catch(SQLException e){
			e.printStackTrace();
		}
                //System.out.println("size "+retProduct.size());
		return retDetails;
	}


}
