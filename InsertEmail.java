
import fdu.student.godithi.Email;
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


public class InsertEmail extends JPanel implements ActionListener
{
       private final JLabel Msg_To, Msg_From, Subject, Body;
       private final JTextField MsgTo, MsgFrom, subject, body;
       private final JButton send;

   public InsertEmail()
   {
      //setLayout(null);
      Msg_To=new JLabel("To");
      Msg_From=new JLabel("From");
      Subject=new JLabel("Subject");
      Body=new JLabel("Message");

      MsgTo= new JTextField(15);
      MsgFrom= new JTextField(15);
      subject= new JTextField(15);
      body= new JTextField(15);

      JPanel MsgToPanel = new JPanel();
      JPanel MsgFromPanel = new JPanel();
      JPanel SubjectPanel = new JPanel();
      JPanel BodyPanel = new JPanel();

      MsgToPanel.add(Msg_To);
      MsgToPanel.add(MsgTo);
      MsgFromPanel.add(Msg_From);
      MsgFromPanel.add(MsgFrom);
      SubjectPanel.add(Subject);
      SubjectPanel.add(subject);
      BodyPanel.add(Body);
      BodyPanel.add(body);

      add(MsgToPanel);
      add(MsgFromPanel);
      add(SubjectPanel);
      add(BodyPanel);

      send = new JButton("Send");
      send.addActionListener(this);

   }

   public void actionPerformed(ActionEvent ae)
   {
       Object o=ae.getSource();
       if(o==send)
       {
           String msgTo=MsgTo.getText();
           String msgFrom=MsgFrom.getText();
           String sub=subject.getText();
           String msg=body.getText();

           Email m=new Email(msgTo, msgFrom, sub, msg);
           //int i=p.addProduct();
           if(m.addEmail())
           {
               JOptionPane.showMessageDialog(this, "Your Message has been sent");
           }
           else{
			   JOptionPane.showMessageDialog(this, "Message not sent");
		   }
       }
   }
   /* public static void main(String [] args)
       { JFrame frame = new Insert(); //initialize a JFrame object
         frame.show(); //display the frame
    }*/
}