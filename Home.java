
import fdu.student.godithi.DBConnection;
import fdu.student.godithi.Product;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Home extends JPanel implements ActionListener
{
       private final JLabel from,to,message,subject;
       private final JTextField tto,tfrom,tmessage,tsubject;
       private final JButton button;
       private final String name;
       private final JComboBox poid;
       private Connection con;
       private Statement st;

   public Home(String n)
   {
      name=n;
      setLayout(null);
      //prid=new JLabel("Search");
      from=new JLabel("From");
      to=new JLabel("To");
      subject=new JLabel("Subject");
      message=new JLabel("Message");
      tto= new JTextField(15);
      tfrom= new JTextField(15);
      tmessage= new JTextField(15);
      tsubject= new JTextField(15);
      button = new JButton("Send");
      poid=new JComboBox();
      //get= new JButton("Get");
      button.addActionListener(this);
      //get.addActionListener(this);

      //JPanel p1=new JPanel();
      to.setBounds(30, 60, 60, 30);
      tto.setBounds(90, 60, 60, 30);

      from.setBounds(30, 110, 60, 30);
      tfrom.setBounds(90, 110, 60, 30);

      subject.setBounds(30, 170, 60, 30);
      tsubject.setBounds(90, 170, 150, 40);

      message.setBounds(30, 220, 60, 30);
    tmessage.setBounds(90, 220, 60, 30);

      button.setBounds(170, 260, 90, 30);

      tfrom.setText(name);
      tfrom.setEditable(false);
       try {
           DBConnection db=new DBConnection();
           con=db.openConn();
           st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from account where EMP_ID='swing'");
           while(rs.next())
           {
               poid.addItem(rs.getString(3));
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
      add(to);
      add(tto);
      add(from);
      add(tfrom);
      add(subject);
      add(tsubject);
      add(message);
      add(tmessage);
//      add(prev);
//      add(tprev);
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
           String to=tto.getText();
           String from=tfrom.getText();
           String sub = tsubject.getText();
           String message=tmessage.getText();
           try {
               int i=st.executeUpdate("insert into message values('"+to+"','"+from+"','"+sub+"','"+message+"')");
               if(i>0)
               {
                   JOptionPane.showMessageDialog(this, "Message Sent Successfully");
               }
               con.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }
}