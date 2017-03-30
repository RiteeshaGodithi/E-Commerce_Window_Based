
import fdu.student.godithi.EmailMessage;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import fdu.student.godithi.*;
import java.io.*;
import java.net.*;


public class ShowEmails extends JPanel implements ActionListener
{
       private final JTable table;
	          //private final JTextField field;
	          private final JButton button;
	          private final String name;

    public ShowEmails(String name)
      {
          this.name=name;
         //field = new JTextField(15);
         button = new JButton("Get Messages");
         table = new JTable();
         button.addActionListener(this);
   //      JPanel p1=new JPanel();
   //      p1.add(field);
         JPanel p2=new JPanel();
         p2.add(button);

         //Create the scroll pane and add it to the table.
         JScrollPane scrollPane = new JScrollPane(table);

         //Add the scroll pane to this window.
         JPanel p3=new JPanel();
         p3.add(scrollPane);
         JPanel p4=new JPanel();
         //p4.add(p1);
         p4.add(p2);
         p4.add(p3);
         add(p4);
      }




   public void actionPerformed(ActionEvent ae)
   {
       Object o=ae.getSource();
       DefaultTableModel dtm=new DefaultTableModel();
       if(o==button)
       {
           try{
           Socket s = new Socket("localhost", 7777);
           ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
           String val="inbox,"+name;
           oos.writeObject(val);
           oos.flush();

           dtm.addColumn("From");
           dtm.addColumn("Message");

           ObjectInputStream b = new ObjectInputStream(s.getInputStream());
           EmailMessage p = (EmailMessage) b.readObject();

           if(p!=null)
           {
               Vector v=new Vector();
               v.add(p.getFrom());
               v.add(p.getMessage());
               dtm.addRow(v);
           }
        }
        catch(Exception e){e.printStackTrace();}
        table.setModel(dtm);
        //table.setPreferredScrollableViewportSize(new Dimension(320, 160));
       }
   }
}
