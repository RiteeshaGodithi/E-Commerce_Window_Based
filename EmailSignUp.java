/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import fdu.student.godithi.*;

class EmailSignUpPanel extends JPanel implements ActionListener
{
    private JButton RegisterButton;
    private JTextField UsernameField, FNameField, LNameField, IDField, MobileField, AddressField, EmailField;
    private JPasswordField PasswordField, PasswordField1;
    private String UName, PsWord, PsWord1, FName, LName, ID, Mobile, Email, Address, Status;
    private Account Acct;
    private Customer Cust;
    private Employee Emp;
    private EmailMessageControl SUC;
    private Message cbo;

    public EmailSignUpPanel()
    {
        RegisterButton = new JButton("Register"); //initializing two button references


        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        PasswordField1 = new JPasswordField(15);
        FNameField = new JTextField(15);
        LNameField = new JTextField(15);
        MobileField = new JTextField(15);
        //EmailField = new JTextField(15);
        AddressField = new JTextField(30);


        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel PasswordLabel = new JLabel("Password: ");
        JLabel PasswordLabel1 = new JLabel("Re-enter Password: ");
        JLabel FNameLabel = new JLabel("First Name: ");
        JLabel LNameLabel = new JLabel("Last Name: ");
        JLabel MobileLabel = new JLabel("Mobile: ");
        //JLabel EmailLabel = new JLabel("Email ID: ");
        JLabel AddressLabel = new JLabel("Address: ");


        JPanel UsernamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel PasswordPanel1 = new JPanel();
        JPanel FNamePanel = new JPanel();
        JPanel LNamePanel = new JPanel();
        JPanel MobilePanel = new JPanel();
        //JPanel EmailPanel = new JPanel();
        JPanel AddressPanel = new JPanel();


        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        PasswordPanel1.add(PasswordLabel1);
        PasswordPanel1.add(PasswordField1);
        FNamePanel.add(FNameLabel);
        FNamePanel.add(FNameField);
        LNamePanel.add(LNameLabel);
        LNamePanel.add(LNameField);
        MobilePanel.add(MobileLabel);
        MobilePanel.add(MobileField);
        //EmailPanel.add(EmailLabel);
        //EmailPanel.add(EmailField);
        AddressPanel.add(AddressLabel);
        AddressPanel.add(AddressField);


        add(UsernamePanel);
        add(PasswordPanel);
        add(PasswordPanel1);
        add(FNamePanel);
        add(LNamePanel);
        add(MobilePanel);
        //add(EmailPanel);
        add(AddressPanel);

        add(RegisterButton);  //add the two buttons on to this panel
        RegisterButton.addActionListener(this); //event listener registration
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Register")) { //determine which button is clicked

            UName = UsernameField.getText(); //take actions
            PsWord =PasswordField.getText();
            PsWord1 = PasswordField1.getText();
            FName = FNameField.getText();
            LName = LNameField.getText();
            Mobile = MobileField.getText();
            //Email = EmailField.getText();
            Address = AddressField.getText();
            Status = "AVAILABLE";
        //    System.out.println("ID:" +ID);

            			Acct = new Account(UName, PsWord, PsWord1, FName, "");
				//Cust = new Customer(UName, PsWord, PsWord1, FName, LName, Mobile, Address);
				if (Acct.signUp()){
				                //JOptionPane.showMessageDialog(null, "Account has been created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				                //SUC = new EmailMessageControl(); //take actions
				                cbo = new Message(UName);
				                cbo.show();
							}
				            else
                JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);





		}
    }
/*
    public String getUsername() {
		return UName;
	};

	public String getPassword() {
	    return PsWord;
	}

	public String getPassword1() {
	    return PsWord1;
	}*/
}

public class EmailSignUp extends JFrame
{
    private EmailSignUpPanel SU_Panel;

    public EmailSignUp()
    {
        setTitle("Sign Up");
        setSize(420, 400);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         Container contentPane = getContentPane(); //add a panel to a frame
         SU_Panel = new EmailSignUpPanel();
         contentPane.add(SU_Panel);
         show();
    }

    public static void main(String [] args)
    { JFrame frame = new EmailSignUp(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

