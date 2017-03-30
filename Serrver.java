import fdu.student.godithi.EmailMessage;
import java.io.*;
import java.net.*;
import java.util.*;

public class Serrver {
    private ServerSocket server;
    private int port = 7777;

    public Serrver() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Serrver s = new Serrver();
        s.handleConnection();
    }

    public void handleConnection() {
        System.out.println("Waiting for client message...");

        while (true) {
            try {
                Socket socket = server.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String vals = (String)ois.readObject();
            //System.out.println("value is "+vals);
            String vv[]=vals.split(",");
            String name=vv[1];
            String activity=vv[0];

            if(activity.equals("inbox")){
            EmailMessage msg=new EmailMessage();
            ArrayList<EmailMessage> message=msg.recieveMessage(name);
            EmailMessage p=message.get(0);
            //System.out.println("Message from client: " + message);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(p);
            oos.close();
            }
            else if(activity.equals("sent")){
            EmailMessage msg=new EmailMessage();
            ArrayList<EmailMessage> message=msg.sentMessage(name);
            EmailMessage p=message.get(0);
            //System.out.println("Message from client: " + message);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(p);
            oos.close();
             }
            ois.close();
            //oos.close();
            socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}