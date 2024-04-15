package garage;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Admin extends Employee
{
     public Admin(String n,String s,String e,long p,String a,int sec,String u,String pass)
    {
        super(n,s,e,p,a,sec,u,pass);
    }
    
    public Admin()
    {
       super(0);
    }
    
    public void createEmployee()
    {
        System.out.println("Please give 1 for secretary, 2 for technician and 3 for Seller");
        Scanner input=new Scanner(System.in);
        int choice = -1;
        try
        {
            choice=input.nextInt();
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Wrong choice");
            input.nextLine();
        }
        input=new Scanner(System.in);
        if(choice==1)
        {
             Secretary e=new Secretary();
             Garage.employess.add(e);
        }
        else if(choice==2)
        {
            Technician e=new Technician();
            Garage.employess.add(e);
        }
        else if(choice==3)
        {
            Seller s=new Seller();
            Garage.employess.add(s);
        }
        else
        {
            System.out.println("Wrong choice");
        }
    }
    
    
    
    public void modifyEmployee()
    {
        for(Employee e:Garage.employess)
        {
            System.out.println("Name is" + e.getName()+e.getSurname() + "Username is" + e.getUsername() + "Sector is " + e.getSector());
        }
        System.out.println("Please give the username of the employee you wish to modify");
        Scanner input=new Scanner(System.in);
        String choice=input.nextLine();
        System.out.println("Please give the new sector, username and password");
        input=new Scanner(System.in);
        int sec=input.nextInt();
        input=new Scanner(System.in);
        String uname=input.nextLine();
        input=new Scanner(System.in);
        String pass=input.nextLine();
        boolean modcheck=false;
        for(Employee e:Garage.employess) 
        {
            if(e.getUsername().equals(choice))
            {
                e.setSector(sec);
                e.setUsername(uname);
                e.setPassword(pass);
                modcheck=true;
                break;        
            }
        }
        if(modcheck==false)
        {
           System.out.println("You gave a wrong username");
        }
    }
    
    
    public void deleteEmployee()
    {
        for(Employee e:Garage.employess)
        {
            System.out.println("Name is" + e.getName()+e.getSurname() + "Username is" + e.getUsername() + "Sector is " + e.getSector());
        }
        System.out.println("Please give the username of the employee you wish to delete");
        Scanner input=new Scanner(System.in);
        String choice=input.nextLine();
        for(Employee e:Garage.employess) 
        {
            if(e.getUsername().equals(choice))
            {
                Garage.employess.remove(e);
                break;        
            }
        }
    }   
}