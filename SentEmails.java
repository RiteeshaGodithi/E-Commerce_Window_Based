
import fdu.student.godithi.EmailMessage;

import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SentEmails extends JPanel implements ActionListener
{
       private final JTable table;
       //private final JTextField field;
       private final JButton button;
       private final String name;

   public SentEmails(String name)
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
           String val="sent,"+name;
           oos.writeObject(val);
           oos.flush();

           dtm.addColumn("To");
           dtm.addColumn("Message");

           ObjectInputStream b = new ObjectInputStream(s.getInputStream());
           EmailMessage p = (EmailMessage) b.readObject();

           if(p!=null)
           {
               Vector v=new Vector();
               v.add(p.getTo());
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
