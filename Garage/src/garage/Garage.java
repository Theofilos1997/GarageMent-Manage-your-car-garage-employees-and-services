/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Garage 
{
    static ArrayList<Vehicle>vehicles_for_sale= new ArrayList<>();
    static ArrayList<Customer>customers = new ArrayList<>();
    static ArrayList<Employee>employess = new ArrayList<>();
    static ArrayList<Vehicle>vehicles_for_repair = new ArrayList<>();
    static DB_Manager database  = new DB_Manager();
    
    public void connect() throws IOException, ClassNotFoundException
    {
        database.connect_to_DB();
    }
    
    public void updateDatabase() throws IOException, ClassNotFoundException
    {   
        database.queryHandler("DELETE FROM employee;");
        database.queryHandler("DELETE FROM vehicle;");
        database.queryHandler("DELETE FROM customer;");
        for(Employee e: employess)
        {         
            database.queryHandler("INSERT INTO employee(name,surname,email,phone,address,sector,username,password)" + "VALUES('"+e.getName()+"','"+e.getSurname()+"','"+e.getEmail()+"','"+e.getPhone()+"','"+e.getAddress()+"','"+e.getSector()+"','"+e.getUsername()+"','"+e.getPassword()+"');");
        }
        for(Customer c: customers)
        {         
            database.queryHandler("INSERT INTO customer(name,surname,email,phone,address)" + "VALUES('"+c.getName()+"','"+c.getSurname()+"','"+c.getEmail()+"','"+c.getPhone()+"','"+c.getAddress()+"');");
            for(Vehicle v: c.customer_vehicles)
            {
                database.queryHandler("INSERT INTO vehicle(brand,model,plate,`repair_description`,cost,`assembly_date`,`Customeremail`)" + "VALUES('"+v.getBrand()+"','"+v.getModel()+"','"+v.getPlate()+"','"+v.getRepair_description()+"','"+v.getAssembly_date()+"','"+v.getCost()+"','"+c.getEmail()+"');");
            }
        }
        for(Employee e: employess)
        {         
            database.queryHandler("INSERT INTO employee(name,surname,email,phone,address,sector,username,password)" + "VALUES('"+e.getName()+"','"+e.getSurname()+"','"+e.getEmail()+"','"+e.getPhone()+"','"+e.getAddress()+"','"+e.getSector()+"','"+e.getUsername()+"','"+e.getPassword()+"');");
        }
        for(Vehicle v: vehicles_for_sale)
        {
            database.queryHandler("INSERT INTO vehicle(brand,model,plate,`repair_description`,cost,`assembly_date`,`Customeremail`)" + "VALUES('"+v.getBrand()+"','"+v.getModel()+"','"+v.getPlate()+"','"+v.getRepair_description()+"','"+v.getAssembly_date()+"','"+v.getCost()+"','"+" "+"');");
        }    
    }
    
    public void initialize() throws IOException, ClassNotFoundException, SQLException
    {
        boolean check;
        List<String[]> customersdb=database.queryHandler("SELECT * FROM customer"); 
        for (String[] row : customersdb)
        {   
                String name=row[0];
                String surname=row[1];
                String email= row[2];
                String phone=row[3];
                String address=row[4];
                Customer c=new Customer(name,surname,email,Long.parseLong(phone),address);
                customers.add(c);
        }
       List<String[]> vehicles=database.queryHandler("SELECT * FROM vehicle"); 
        for (String[] row : vehicles)
        {
            check=false;
            String brand=row[0];
            String model=row[1];
            String plate= row[2];
            String repair_desc=row[3];
            String cost=row[4];
            String assem_date=row[5];
            Vehicle v =new Vehicle(brand,model,plate,repair_desc,Long.parseLong(cost),Integer.parseInt(assem_date));
            String cemail=row[6];
            for(Customer c: customers)
            {
                if(cemail.equals(c.getEmail()))
                {
                    c.addVehicle(v);
                    check=true;
                    break;
                }
            }
            if(!check)
            {
                vehicles_for_sale.add(v);
            }
        }
       List<String[]> employeesdb=database.queryHandler("SELECT * FROM employee"); 
        for (String[] row : employeesdb)
        {
            String name=row[0];
            String surname=row[1];
            String email= row[2];
            Long phone=Long.parseLong(row[3]);
            String address=row[4];
            int sector=Integer.parseInt(row[5]);
            String username=row[6];
            String password=row[7];
            if(sector==0)
            {
            Employee e=new Admin(name,surname,email,phone,address,sector,username,password);
            employess.add(e);
            }
            if(sector==1)
            {
            Employee e=new Secretary(name,surname,email,phone,address,sector,username,password);
            employess.add(e);
            }
            if(sector==2)
            {
            Employee e=new Technician(name,surname,email,phone,address,sector,username,password);
            employess.add(e);
            }
            if(sector==3)
            {
            Employee e=new Seller(name,surname,email,phone,address,sector,username,password);
            employess.add(e);
            } 
            
        }
       
    }
    
    public static void deleteVehicle(Vehicle v)
    {
        vehicles_for_sale.remove(v);
    }
    
    
    public static Customer createCustomer()
    {
        Customer c=new Customer();
        customers.add(c);
        return c;
    }
    
    public static Customer createCustomer1()
    {
        Customer c=new Customer(1);
        customers.add(c);
        return c;
    }
    
    public static Customer searchCustomer1(String email)
    {
        for(Customer c:customers)
        {
            if(c.getEmail().equals(email))
            {
                return c;
            }
                
        }
        return null;
    }
               
    
    public static Customer searchCustomer(String plate)
    {
        for(Customer c:customers)
        {
            for(Vehicle v: c.customer_vehicles)
            {
                if(v.getPlate().equals(plate))
                {
                    return c;
                }
            }
        }
        return null;
    }
        
   public static Vehicle searchVehicle(String plate)
   {
       for(Vehicle v: vehicles_for_sale)
            {
                if(v.getPlate().equals(plate))
                {
                    return v;
                }
            }
       return null;
   }
   
   
           
   public static Vehicle searchRepairvehicles(String plate)
   {
       for(Vehicle v: vehicles_for_repair)
            {
                if(v.getPlate().equals(plate))
                {
                    return v;
                }
            }
       return null;
   }
    
    
   public static void addVehicle_for_sale(Vehicle v)
   {
       vehicles_for_sale.add(v);
   }
   
    public static Vehicle searchCustomervehicle(Customer c,String plate)
   {
       for(Vehicle v: c.customer_vehicles)
            {
                if(v.getPlate().equals(plate))
                {
                    return v;
                }
            }
       return null;
   }
    
}
