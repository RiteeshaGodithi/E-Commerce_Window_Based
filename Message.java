import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MessagePanel extends JPanel
{
   String name;
   public MessagePanel(String n)
   {
      name=n;
      tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object

      tabPanel_1 = new Home(name);
      tabPanel_2 = new SentEmails(name);
      tabPanel_3 = new ShowEmails(name);
      //tabPanel_4 = new Logout();

      tabbedPane.addTab("Compose", tabPanel_1); //add GUI components to Tabbed Pane
      tabbedPane.setSelectedIndex(0);
      tabbedPane.addTab("Sent", tabPanel_2);
      tabbedPane.addTab("Inbox", tabPanel_3);
      //tabbedPane.addTab("Logout",tabPanel_4);
      //show();
      add(tabbedPane);
   }

   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2, tabPanel_3, tabPanel_4;
}

class Message extends JFrame
{
    String name;
   public Message(String n)
   {
      name=n;
      setTitle("Home");
      setSize(800, 600);

      //get screen size and set the location of the frame
      /*Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 4, screenHeight / 5);*/

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });

      JPanel tabbedPanel = new MessagePanel(name);
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(tabbedPanel);
      pack();
   }
}