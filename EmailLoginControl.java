/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import fdu.student.godithi.*;

public class EmailLoginControl
{
    private Account Acct;
    private Customer Cust;
    private EmailMessageControl SUC ;
    private EmailSignUp sb;

    public EmailLoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);


				if (Acct.emailLogIn()) {
		            //JOptionPane.showMessageDialog(null, "Login Successful.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		            SUC = new EmailMessageControl(UName); //take actions
		        }
		                else
		                {
		                  JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		                }
		    }
}