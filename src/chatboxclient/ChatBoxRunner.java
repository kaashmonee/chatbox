/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.io.IOException;

/**
 *
 * @author skandakaashyap
 */
public class ChatBoxRunner {
    public static void main(String [] args) throws IOException {
       ChatBoxGUI c= new ChatBoxGUI();
       c.run();
    }
}
