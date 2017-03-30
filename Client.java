import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 7777);
            System.out.println("Connected to Server");
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hello There...");

            //
            // Read and display the response message sent by server application
            //
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

            ois.close();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}