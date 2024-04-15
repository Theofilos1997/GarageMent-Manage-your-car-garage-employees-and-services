/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Service
{
    public Vehicle Vehicle_for_service;
    private int ServiceCost;
    private String Servicedesc;
    SimpleDateFormat nextservice = new SimpleDateFormat("MM-dd-yyyy");
    
    public Service()
    {
        this.Vehicle_for_service = new Vehicle();
        this.ServiceCost = 0;
        this.Servicedesc = "";
    }
    
    public Service(Vehicle v, int Serv_cost, String Serv_decs)
    {
        this.Vehicle_for_service = v;
        this.ServiceCost = Serv_cost;
        this.Servicedesc = Serv_decs;
    }
    
    public void setServiceCost(int Serv_cost)
    {
        this.ServiceCost = Serv_cost;
    }
    
    public int getServiceCost()
    {
        return this.ServiceCost;
    }
    
    public void setServicedesc(String Serv_decs)
    {
        this.Servicedesc = Serv_decs;
    }
    
    public String getServicedesc()
    {
        return this.Servicedesc;
    }
    
    //Dimiourgia neou Service
    public void setService(Vehicle car)
    {
        Scanner sc = new Scanner(System.in);        
        this.Vehicle_for_service = car; 
        System.out.println("The repair that must be done is:" + Vehicle_for_service.getRepair_description());
        //Eisagogi stoixeiwn gia to service
        System.out.print("Service cost:");
        this.ServiceCost = sc.nextInt();
        System.out.println();
        
        System.out.print("Service description:");
        this.Servicedesc = sc.nextLine();
        System.out.println();
                
        System.out.print("Enter the date of next service: ");
        String nextserv = sc.nextLine();

        //Elegxoume an o xristis edwse tin imerominia se swsti morfi(Month - Day - Year)
        try 
        {
            Date date = nextservice.parse(nextserv); 
            nextservice = new SimpleDateFormat("EEE, d MMM yyyy");
           
        } 
        catch (ParseException e) 
        { 
            System.out.println("Error!");
        }
        Vehicle_for_service.setRepair_description("");
        for(Vehicle v:Garage.vehicles_for_repair)
        {
            if(v.equals(Vehicle_for_service))
            {
               Garage.vehicles_for_repair.remove(v);
               break;
            }
        }
        insertintoUpdate();
    }
    
    public void insertintoUpdate()
    {
        String update = "Customer name: " + Garage.searchCustomer(Vehicle_for_service.getPlate()).getName() + "Customer phone: "+ Garage.searchCustomer(Vehicle_for_service.getPlate()).getPhone() +  "Vehicle:" + Vehicle_for_service.getBrand() + "Cost:" + ServiceCost + "Repair" + Servicedesc;
        CustomerUpdater.updates.add(update);
    }
}