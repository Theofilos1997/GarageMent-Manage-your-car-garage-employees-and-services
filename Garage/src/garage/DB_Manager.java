/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DB_Manager
{
    Socket s;
    
    public void connect_to_DB() throws IOException, ClassNotFoundException
    {
        s = new Socket("localhost", 9090);
    }   
    
   public List<String[]> queryHandler(String query) throws IOException, ClassNotFoundException
    {
        connect_to_DB();
        DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
        ObjectInputStream inStream=null;
        inStream= new ObjectInputStream(s.getInputStream());
        outToServer.writeBytes(query + '\n');
        List<String[]> result=(List<String[]>) inStream.readObject();
        return result; 
    }
}
