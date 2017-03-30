/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
//import fdu.student.godithi.Email;

public class EmailMessageControl
{
    private Message SU_BO;
    private String name;

    public EmailMessageControl(String n) {
		name = n;
		SU_BO = new Message(name);
		SU_BO.show();
	}
}