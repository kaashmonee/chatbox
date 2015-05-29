/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.HashSet;

/**
 * They want the Download
 * @author SKAAASHMONEY_WestSIEde
 */
public class ChatBoxGUI extends javax.swing.JFrame {
private JFrame getIP;
private JButton IPok;
private JFrame thisFrame;
private String IPAddress;
private JTextField ipField;
private JFrame isServer;
private JButton yes, no;
private boolean isAserver;
private BufferedReader in;
private PrintWriter out;
private Socket clientSocket;
private Socket serverSocket;
//private String ipAddress;

    /**
     * Creates new form ChatBoxClient
     */
    private Server server;
    public ChatBoxGUI() throws IOException {
        super("Chat Box");
        initComponents();
       addListeners();
      thisFrame=this;
     
       //server= new Server();
      //mor eedit and what not
      //yeeeee
      //what hte hell i changed things
    }
    
    public void addListeners() {
        //adds listeners
        
         connectButton.addActionListener(new AllListener());
        sendButton.addActionListener(new AllListener());
    }
    public void run() {
        isServer();
       
    }
    //WINDOW THAT ASKS THE USER FOR THE IP ADDRESS OF THE PERSON TRYING TO CONNECT TO A SERVER
    private void IPAddr() {
        getIP= new JFrame("IP Address");
        
        JPanel p= new JPanel();
        p.add(new JLabel("What is the server IP? "));
        ipField= new JTextField();
        IPok= new JButton("Enter");
        ipField.setColumns(15);
        p.add(ipField);
        p.add(IPok);
        
        getIP.add(p);
        IPok.addActionListener(new AllListener());
        getIP.pack();
        thisFrame.setVisible(false);
        getIP.setVisible(true);
        isServer.setVisible(false);
    }
    //CHECKS TO SEE IF THE GUI CONNECTED IS THE ONE RUNNING THE SERVER OR NOT
    private void isServer() {
        isServer= new JFrame ("Are you server");
        JPanel p= new JPanel();
        p.add(new JLabel("Are you the server?"));
        yes= new JButton("Yes");
        no= new JButton("No");
        p.add(yes);
        p.add(no);
        yes.addActionListener(new AllListener());
        no.addActionListener(new AllListener());
        isServer.add(p);
        isServer.pack();
        isServer.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageField = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        whoOnlineLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        whoOnlineField = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        sentMessageArea = new javax.swing.JTextArea();
        sentMessageArea.setCaretPosition(sentMessageArea.getDocument().getLength());
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connectButton.setText("Connect!");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        messageField.setColumns(20);
        messageField.setRows(5);
        jScrollPane1.setViewportView(messageField);

        sendButton.setText("Send");

        whoOnlineLabel.setText("Who's Online");

        nameLabel.setText("Name:");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        whoOnlineField.setEditable(false);
        whoOnlineField.setColumns(20);
        whoOnlineField.setRows(5);
        jScrollPane2.setViewportView(whoOnlineField);

        sentMessageArea.setEditable(false);
        sentMessageArea.setColumns(20);
        sentMessageArea.setRows(5);
        jScrollPane3.setViewportView(sentMessageArea);

        jMenu1.setText("File");

        jMenuItem1.setText("Close");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(whoOnlineLabel)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectButton)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(whoOnlineLabel)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        thisFrame.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea messageField;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea sentMessageArea;
    private javax.swing.JTextArea whoOnlineField;
    private javax.swing.JLabel whoOnlineLabel;
    // End of variables declaration//GEN-END:variables

    private class AllListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            //connects the user to the server 
            if (e.getSource().equals(connectButton)) {
                // whoOnlineField.insert(nameField.getText()+"\n",0);
                 
                 out.println("NAME"+nameField.getText());
                 connectButton=null;
                 nameField.setEditable(false);
                 new InMessages().start();
                 //new WhoOnlineThread().start();
                 //Button b= new Button();
                 //connectButton.disable();
                 
            }
            //sends the messages to everyone connected. basically sends the message to the server and
            //server will send the message to all the people connected
            if (e.getSource().equals(sendButton)) {
                //sentMessageArea.append("\n\n\n"+nameField.getText()+": "+messageField.getText());
                
                out.println("MESSAGE"+messageField.getText());
                
                messageField.setText("");
                
                
            }
            //THIS CREATES A CLIENT AND SINCE THE PORT NUMBER IS THE SAME, CAN NOW LOG ONTO THE SERVER
            if (e.getSource().equals(IPok)) {
                IPAddress=ipField.getText().trim();
                getIP.setVisible(false);
                thisFrame.setVisible(true);
                if (isAserver) {
                    try {//creates a server and connects to that server
                 new Server(IPAddress).start();
                //creates a new socket
                serverSocket =new Socket(InetAddress.getByName(IPAddress),Server.port);
                in =new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                out= new PrintWriter(serverSocket.getOutputStream(),true);
                
                }
                catch(Exception exc) {
                    System.out.print(exc);
                }
                }
                else {
                    try {
                InetAddress i= InetAddress.getByName(IPAddress);
                clientSocket = new Socket (i,Server.port);
                in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out=new PrintWriter(clientSocket.getOutputStream(),true);
                
                }
                catch (Exception exception) {
                    System.out.print(exception);
                }
                }
                /*try {
                InetAddress i= InetAddress.getByName(IPAddress);
                clientSocket = new Socket (i,45981);
                }
                catch (Exception exception) {
                    System.out.print(exception);
                }
                */
            }
            //THE SERVER IS CREATED WHEN THE USER PRESSES YES
            if (e.getSource().equals(yes)) {
                isServer.setVisible(false);
                IPAddr();
                thisFrame.setVisible(false);
                /*
                JFrame yourIP= new JFrame("Your IP");
                JPanel p= new JPanel();
                try {
                p.add(new JLabel("Your IP is "+InetAddress.getLocalHost()));
                }
                catch (Exception ex) {
                    p.add(new JLabel(""+ex));
                }
                yourIP.add(p);
                yourIP.setVisible(true);
                yourIP.pack();
                */
                
                //thisFrame.setVisible(true);
                isAserver=true;
                
                
            }
            if (e.getSource().equals(no)) {//doesn't create the server but connects to it
                IPAddr();
                
                isAserver=false;
            }
            
            
            
            
           
        }
    
    }
   /* private class GetMessagesThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    
                }
            }
        }
    }
    */
    
    //sits there and gets stuff from the server then puts it in the sent message area of the GUI
 private class InMessages extends Thread {
     @Override
     public void run () {
         try {
         while (true) {
            
             String s= in.readLine();
             if (s.startsWith("MESSAGE")) {
             sentMessageArea.append("\n\n\n"+s.substring(7));
             }
             if (s.startsWith("ONLINE")) {
                 whoOnlineField.append("\n"+s.substring(6));
             }
         }
         }
         catch (Exception e) {
             System.out.println(e);
         }
     }
 }
 //sits there and waits for the server to send the name message


    
}
