/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import fdu.student.godithi.*;

class MaintainPanel extends JPanel implements ActionListener
{
	private JTabbedPane tabbedPane1, tabbedPane2, tabbedPane3;
	private JTextField Prod_ID, Prod_Name, Prod_Qty, Prod_Cost, Prod_Desc;
	private JPanel tab1, tab2, tab3;
    public MaintainPanel()
    {
		tabbedPane1 = new JTabbedPane();
		//tabbedPane2 = new JTabbedPane();
		//tabbedPane3 = new JTabbedPane();

		Prod_ID = new JTextField(15);
		Prod_Name = new JTextField(15);
		Prod_Qty = new JTextField(15);
		Prod_Desc = new JTextField(15);

		JLabel ID = new JLabel("ID: ");
		JLabel Name = new JLabel("Name: ");
		JLabel Qty = new JLabel("Quantity: ");
		JLabel Desc = new JLabel("Description: ");

		JPanel IDPanel = new JPanel();
		JPanel NamePanel = new JPanel();
		JPanel QtyPanel = new JPanel();
		JPanel DescPanel = new JPanel();

		IDPanel.add(ID);
		IDPanel.add(Prod_ID);
		NamePanel.add(Name);
		NamePanel.add(Prod_Name);
		QtyPanel.add(Qty);
		QtyPanel.add(Prod_Qty);
		DescPanel.add(Desc);
		DescPanel.add(Prod_Desc);

		ImageIcon icon = new ImageIcon("java-swing-tutorial.JPG");
		tabbedPane1.add("Search Product", IDPanel);
		tab1 = createInnerPanel("Tab 1 Contains Tooltip and Icon");
		tabbedPane1.addTab("One", icon, tab1, "Tab 1");
		tabbedPane1.add("Search Product", NamePanel);
		tabbedPane1.add("Search Product", QtyPanel);
		tabbedPane1.add("Search Product", DescPanel);

		add(tabbedPane1);
		//add(tabbedPane2);
		//add(tabbedPane3);
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event

    }
}

public class MaintainProductBO extends JFrame
{
    private MaintainPanel MP_Panel;

    public MaintainProductBO()
    {
        setTitle("Product Maintanence");
        setSize(1000, 400);

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
         MP_Panel = new MaintainPanel();
         contentPane.add(MP_Panel);
         show();
    }

    public static void main(String [] args)
    { JFrame frame = new MaintainProductBO(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

