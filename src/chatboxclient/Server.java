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
    private ArrayList <PrintWriter> writers;
    private ArrayList <String> nameList;
    //constructor
    public Server(String IP) throws IOException {
        writers= new ArrayList<PrintWriter>();
        nameList= new ArrayList<String>();
          InetAddress ipAddr=InetAddress.getByName(IP);
        s= new ServerSocket(port, 0,ipAddr);
    }
    //run method for the server
    @Override
    public void run() {
         try {
        while (true) {
           Socket socket = s.accept();
           writers.add(new PrintWriter(socket.getOutputStream(),true));
            new HandlerThread(socket).start();
        }
        }
        catch (Exception e) {
            System.out.print(e);
        }
    
    }
    private class HandlerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;
    private boolean nameListChanged=true;
    //private HashSet nameList;
    //private HashSet printWriters;
  
    
    public HandlerThread(Socket s) {
        socket =s;
        //nameList= new HashSet<String>();
    }
    @Override
    public void run() {
        try {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out= new PrintWriter (socket.getOutputStream(), true);
        while (true) {
            String message=in.readLine();
            if (message.startsWith("NAME")) {
                name=message.substring(4);
                nameList.add(name);
                //updating who's online list
                 for (PrintWriter writer : writers) {
                    writer.println("ONLINE"+nameList.get(nameList.size()-1));
                    
                    
                    
                }
                 ArrayList<String> temp=nameList;
                    temp.remove(name);
                    for (String tempS : temp) {
                        out.println("ONLINE"+tempS);
                    }
                
            }
            if (message.startsWith("MESSAGE")) {
                for (PrintWriter writer : writers) {
                    writer.println("MESSAGE"+name+": "+message.substring(7));
                    writer.flush();
                }
            }
            
            
            
        }
        }
        catch (Exception e) {
            System.out.print(e+"server exception");
            
        }
    }
    
    public PrintWriter getOut() {
        return out;
    }
        
}

    
}
