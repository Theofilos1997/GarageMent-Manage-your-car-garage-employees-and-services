/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ServerThread extends Thread
{
    Socket s=null;

    public ServerThread(Socket s)
    {
        this.s=s;
    }
    
    @Override
    public void run()
    {
        try 
        {
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            ObjectOutputStream outputStream;
            outputStream = new ObjectOutputStream(s.getOutputStream());
            String query = br.readLine();
            System.out.println("Query recived from client is "+ query);
            try
            {
                outputStream.writeObject(queryHandler(query));
            }
            catch(SQLException ex)
            {  
                ex.printStackTrace(); 
            }
        } 
        catch(IOException e)
        {
            System.out.println("Client disconected");
        }
    }

    public List<String[]> queryHandler(String query) throws SQLException
    {
        ResultSet rset = null;
        List<String[]> result = new ArrayList<>();
        if(query.startsWith("SELECT"))
        {
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage", "root", "");
                Statement stmt = conn.createStatement();
                rset = stmt.executeQuery(query);
                ResultSetMetaData rsmd = rset.getMetaData(); 
                int columnCount = rsmd.getColumnCount();

                while(rset.next())
                {
                    String[] row = new String[columnCount];
                    for( int i = 0; i < columnCount; i++ )
                    {
                        row[i]=rset.getString(i+1);
                    }
                    result.add(row);
                }
            }
            catch(SQLException ex)
            {  
               ex.printStackTrace(); 
            }
            for (String[] row : result)
            {   
                 for (String s : row)
                    System.out.println(s);
            }
            return result;
        }
        
        else
        {
            try
            {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage", "root", "");
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();       
            }
            catch(SQLException ex)
            {  
                ex.printStackTrace(); 
            }
            return null;
        }
    }
        
}
    


