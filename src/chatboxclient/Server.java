/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author skaashy7
 */
//IP ADDRESS OF SCHOOL 184.61.38.240
//final static String serge="pondering"+null;
//THE PORT NUMBER IS 45981
public class Server extends Thread { 
    //initializing instance variables
    public final static int port =45981;
    private ServerSocket s;
    private HashSet <PrintWriter> writers;
    private HashSet <String> nameList;
    //constructor
    public Server(String IP) throws IOException {
        InetAddress ipAddr=InetAddress.getByName(IP);
        s= new ServerSocket(port, 0,ipAddr);
    }
    //run method for the server
    public void runServer() {
         try {
        while (true) {
           Socket socket = s.accept();
           writers.add(new PrintWriter(socket.getOutputStream()));
            new HandlerThread(socket).start();
        }
        }
        catch (Exception e) {
            return;
        }
    
    }
    private class HandlerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;
    //private HashSet nameList;
    //private HashSet printWriters;
  
    
    public HandlerThread(Socket s) {
        socket =s;
        nameList= new HashSet<String>();
    }
    public void run() {
        try {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out= new PrintWriter (socket.getOutputStream(), true);
        while (true) {
            String message=in.readLine();
            if (message.startsWith("NAME")) {
                name=message.substring(4);
                nameList.add(name);
            }
            if (message.startsWith("MESSAGE")) {
                for (PrintWriter writer : writers) {
                    writer.println(name+": "+message.substring(7));
                }
            }
            
            
            
        }
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public PrintWriter getOut() {
        return out;
    }
        
}

    
}
