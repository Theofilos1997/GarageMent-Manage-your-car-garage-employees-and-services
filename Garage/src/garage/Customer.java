/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.ArrayList;


public class Customer extends Person 
{
    ArrayList<Vehicle>customer_vehicles = new ArrayList<>();
    
    public Customer()
    {
        super();
        Vehicle temp=new Vehicle();
        customer_vehicles.add(temp);
    }
    
        public Customer(int c)
    {
        super();

    }
    
    public Customer(String n,String s,String e,long p,String a)
    {
                super(n,s,e,p,a);
    }    
        
    public Customer(String n,String s,String e,int p,String a,String brand, String model, String plate, String repair_description, float cost, int assembly_date)
    {
                super(n,s,e,p,a);
                Vehicle temp=new Vehicle(brand,model,plate,repair_description,cost,assembly_date);
                customer_vehicles.add(temp);
    }
    
    public void addVehicle(String brand, String model, String plate, String repair_description, float cost, int assembly_date)
    {
        Vehicle temp=new Vehicle(brand,model,plate,repair_description,cost,assembly_date);
        customer_vehicles.add(temp);
    }
    
    public void addVehicle(Vehicle v)
    {
        customer_vehicles.add(v);
    }
    
    
}
