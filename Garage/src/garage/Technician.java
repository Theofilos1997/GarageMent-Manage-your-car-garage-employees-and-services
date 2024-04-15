/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.ArrayList;
import java.util.Scanner;


public class Technician extends Employee
{
    private ArrayList <Service> Services = new ArrayList<>();
      
      
     public Technician(String n,String s,String e,long p,String a,int sec,String u,String pass)
    {
        super(n,s,e,p,a,sec,u,pass);
    }
    
    public Technician()
    {
        super(2);
        this.Services =  new ArrayList <> ();
    }
    
    // Constructors with arguments:
    public Technician(ArrayList s)
    {
        super(2);
        //super.Employee(String u, String p);
        this.Services = s;
    }
    //kas Services apothikeuei antikeimena tupou Service.
  
    
    
    //H sunastisi CreateService dimiourgei ena neo service apo ton texniko.
    public void CreateService() 
    {
        Scanner input =  new Scanner(System.in);
        Service se = new Service();
        
        System.out.println("-----------Service-----------");
        
        //Zitame apo ton xristi to autokinito pou prokeite na episkeuasoume
        System.out.println();
        System.out.print("Please enter the plate of the car: ");
        String plate = input.nextLine();
        
        //Elegxoume an to autokinito pou edwse o xristis vrisketai stin lista me ta autokinita pou prepei na episkeuastoun tis klasis Main
        if(Garage.searchRepairvehicles(plate) == null)
        {
            System.out.println( "Car not found!");
        }
        else
        {
            Vehicle car =  Garage.searchRepairvehicles(plate);
            System.out.println();
            //Kaloume tin sunartisi ulopoihsis setService tis klasis Service
            se.setService(car);
            Services.add(se);
        }  
    }
}
