
import fdu.student.godithi.Product;
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


public class Insert extends JPanel implements ActionListener
{
       private final JLabel Prod_ID, Prod_Name, Prod_Qty, Prod_Price, Prod_Desc;
       private final JTextField ProdID, ProdName, ProdQty, ProdPrice, ProdDesc;
       private final JButton button;

   public Insert()
   {
      setLayout(null);
      Prod_ID=new JLabel("Product ID");
      Prod_Name=new JLabel("Product Name");
      Prod_Qty=new JLabel("Product Quantity");
      Prod_Price=new JLabel("Product Cost");
      Prod_Desc=new JLabel("Description");

      ProdID= new JTextField(15);
      ProdName= new JTextField(15);
      ProdQty= new JTextField(15);
      ProdPrice= new JTextField(15);
      ProdDesc= new JTextField(15);

      button = new JButton("Add");
      button.addActionListener(this);
      //JPanel p1=new JPanel();
      Prod_ID.setBounds(30, 20, 60, 30);
      ProdID.setBounds(90, 20, 60, 30);

      Prod_Name.setBounds(170, 20, 85, 30);
      ProdName.setBounds(255, 20, 100, 30);

      Prod_Qty.setBounds(375, 20, 130, 30);
      ProdQty.setBounds(510, 20, 130, 30);

      Prod_Price.setBounds(30, 70, 60, 30);
      ProdPrice.setBounds(90, 70, 60, 30);

      Prod_Desc.setBounds(170, 70, 85, 30);
      ProdDesc.setBounds(255, 70, 100, 30);

      button.setBounds(170, 220, 60, 30);

      add(Prod_ID);
      add(ProdID);
      add(Prod_Name);
      add(ProdName);
      add(Prod_Qty);
      add(ProdQty);
      add(Prod_Price);
      add(ProdPrice);
      add(Prod_Desc);
      add(ProdDesc);
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
           String pid=ProdID.getText();
           String pname=ProdName.getText();
           String pqty=ProdQty.getText();
           String pcost=ProdPrice.getText();
           String pdesc=ProdDesc.getText();
           System.out.println("Values1 "+pid);
           System.out.println("Values2 "+pname);
           System.out.println("Values1 "+pqty);
           System.out.println("Values1 "+pcost);
           System.out.println("Values1 "+pdesc);

           Product p=new Product(pid, pname, pqty, pcost, pdesc);
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