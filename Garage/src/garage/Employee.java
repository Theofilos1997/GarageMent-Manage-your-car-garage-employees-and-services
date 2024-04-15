/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.Scanner;

public abstract class Employee extends Person
{
    private int sector;
    private String username;
    private String password;
    
    
    public Employee(int sec)
    {
        super();
        System.out.println("Please give username and password");
        Scanner input;
        //input = new Scanner(System.in);
        //sector=input.nextInt();
        sector = sec;
        input = new Scanner(System.in);     
        username=input.nextLine();
        input = new Scanner(System.in);
        password=input.nextLine();
    }
    
    public Employee (String n,String s,String e,long p,String a,int sec,String u,String pass)
    {
        super(n,s,e,p,a);
        sector=sec;
        username=u;
        password=pass;
    }
    
    
    public String getPassword()
    {
        return password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public int getSector()
    {
        return sector;
    }
    
    public void setPassword(String p)
    {
        password=p;
    }
    
    public void setUsername(String u)
    {
        username=u;
    }
    
    public void setSector(int s)
    {
        sector=s;
    }
    
    public static Employee login(String uname,String pass)
    {
        for(Employee e:Garage.employess)
        {
            if(e.username.equals(uname) && e.password.endsWith(pass))
            {
                return e;
            }
                
        }
        return null;
    }
            
    
    
}
