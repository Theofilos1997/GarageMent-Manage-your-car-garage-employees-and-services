/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


public class Server
{

    public static void main(String[] args) throws IOException, SQLException 
    {
        Server s=new Server();
        s.func();
    }
    
    
    public void func() throws IOException, SQLException
    {
     ServerSocket listener = new ServerSocket(9090);
        System.out.println("Server Started and listening to the port 9090");
            while (true) 
            {
                Socket socket = listener.accept();
                ServerThread st=new ServerThread(socket);
                st.start();
            }   
    }
    
    
}
