/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.Scanner;


public class Person
{
    private String name,surname,email,address;
    private long phone;
    
    public Person()
    {        
        System.out.println("Please give the name, surname, email, phone and address");
        Scanner input;
        input = new Scanner(System.in);
        name=input.nextLine();
        input = new Scanner(System.in);
        surname=input.nextLine();;
        input = new Scanner(System.in);
        email=input.nextLine();;
        input = new Scanner(System.in);
        phone=input.nextLong();;
        input = new Scanner(System.in);
        address=input.nextLine();;
    }
    
    public Person(String n,String s,String e,long p,String a)
    {
        name=n;
        surname=s;
        email=e;
        phone=p;
        address=a;
    }
    
    public String getName()
    {
        return name;
    }
    
     public String getSurname()
    {
        return surname;
    }
     
     public String getEmail()
    {
        return email;
    }
      public long getPhone()
    {
        return phone;
    }
       public String getAddress()
    {
        return address;
    }
       
       public void setName(String n)
    {
        name=n;
    }
    
     public void setSurname(String s)
    {
        surname=s;
    }
     
     public void setEmail(String e)
    {
        email=e;
    }
      public void setPhone(int p)
    {
        phone=p;
    }
       public void getAddress(String a)
    {
        address=a;
    }
}
