
import fdu.student.godithi.PublicReviews;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Review extends JPanel implements ActionListener
{
       private final JLabel ID, Cust_ID, Review, Comments, Prod_ID;
       private final JTextField Id, CustID, Rev, Cmts, ProdID;
       private final JButton button;

   public Review()
   {
      setLayout(null);
      ID=new JLabel("Product ID");
      Cust_ID=new JLabel("Customer ID");
      Review=new JLabel("Review");
      Comments=new JLabel("Comments");
      Prod_ID=new JLabel("Product ID");

      Id= new JTextField(15);
      CustID= new JTextField(15);
      Rev= new JTextField(15);
      Cmts= new JTextField(15);
      ProdID= new JTextField(15);

      button = new JButton("Go");
      button.addActionListener(this);
      //JPanel p1=new JPanel();
      ID.setBounds(30, 20, 60, 30);
      Id.setBounds(90, 20, 60, 30);

      Cust_ID.setBounds(170, 20, 85, 30);
      CustID.setBounds(255, 20, 100, 30);

      Review.setBounds(375, 20, 130, 30);
      Rev.setBounds(510, 20, 130, 30);

      Comments.setBounds(30, 70, 60, 30);
      Cmts.setBounds(90, 70, 60, 30);

      Prod_ID.setBounds(170, 70, 85, 30);
      ProdID.setBounds(255, 70, 100, 30);

      button.setBounds(170, 220, 60, 30);

      add(Id);
      add(ID);
      add(Cust_ID);
      add(CustID);
      add(Review);
      add(Rev);
      add(Comments);
      add(Cmts);
      add(Prod_ID);
      add(ProdID);
      add(button);
       //JScrollPane jsp=new JScrollPane();
       //jsp.add(p1);
       //add(p1);
   }

   public void actionPerformed(ActionEvent ae)
   {
       Object o=ae.getSource();
       if(o==button)
       {
           String id=Id.getText();
           String cid=CustID.getText();
           String prev=Rev.getText();
           String pcmts=Cmts.getText();
           String pid=ProdID.getText();


           PublicReviews p=new PublicReviews(id, cid, prev, pcmts, pid);
           //int i=p.addProduct();
           if(p.addProduct())
           {
               JOptionPane.showMessageDialog(this, "Product Details Added Successfully");
           }
           else{
			   JOptionPane.showMessageDialog(this, "Insertion Failed!");
		   }
       }
   }
   /* public static void main(String [] args)
       { JFrame frame = new Insert(); //initialize a JFrame object
         frame.show(); //display the frame
    }*/
}