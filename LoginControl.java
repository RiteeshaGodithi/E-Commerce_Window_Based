/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import fdu.student.godithi.*;

public class LoginControl
{
    private Account Acct;
    private Customer Cust;
    private Prod_Emp_Reln pemp;
    private SignUpBO sb;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String result = Acct.LogIn();
		                System.out.println("value is "+result);
		                if(result.contains(",")){
		                String[] s=result.split(",");
				/*if (result.equals("invalid")) {
		            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		        } */    if(s[0].equals("customer")){
					 CustomerControl custControl = new CustomerControl(s[0]);
				}else if(s[0].equals("employee")){
					 EmployeeControl empControl =new EmployeeControl();
				}
		                }
		                else
		                {
		                  JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		                }
		    }
}