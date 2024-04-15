/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.ArrayList;
import java.util.Scanner;


public class Seller extends Employee
{
    // Δήλωση μεταβλητών - δεδομένα:
    private ArrayList <Sale> sales;
    
    // Default constructor:
    public Seller(String n,String s,String e,long p,String a,int sec,String u,String pass)
    {
        super(n,s,e,p,a,sec,u,pass);
    }
    
    public Seller()
    {
        super(3);
        this.sales =  new ArrayList <> ();
    }
    
    // Constructors with arguments:
    public Seller(ArrayList s)
    {
        super(3);
        //super.Employee(String u, String p);
        this.sales = s;
    }
        
    // Μέθοδος δημιουργίας νέας πώλησης:
    public void createSale()
    {
        Scanner input =  new Scanner(System.in);
        Sale s = new Sale();
        System.out.println("New sale:");
        
        // Επιλογή πελάτη:
        System.out.print("Enter the customer' s e-mail:  ");
        String current_mail = input.nextLine();
        //Αν πρόκειται για νέο πελάτη, τον δημιουργούμε:
        if(Garage.searchCustomer1(current_mail) == null)
        {
            Garage.createCustomer1();
        }
        Customer cust =  Garage.searchCustomer(current_mail);
        
        // Επιλογή οχήματος:
        System.out.print("Enter the plate of sold car: ");
        String current_plate = input.nextLine();
        Vehicle car =  Garage.searchVehicle(current_plate);
        
        // Πραγματοποίηση πώλησης:
        s.createSale(car, cust);
        sales.add(s);
    }
    
    // Μέθοδος εισαγωγής νέου αυτοκινήτου:
    public void insertCar()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert car:");
        
        //Εισαγωγή των στοιχείων του νέου αυτοκινήτου:
        System.out.print("Brand: ");
        String brand = input.nextLine();
        System.out.print("Model: ");
        String model = input.nextLine();
        System.out.print("Plate: ");
        String plate =  input.nextLine();
        System.out.print("Cost: ");
        float cost = input.nextFloat();
        System.out.print("Assembly date: ");
        int assembly_date = input.nextInt();
        
        // Δημιουργία νέου αντικειμένου αυτοκινήτου:
        Vehicle car = new Vehicle();
        car.setBrand(brand);
        car.setModel(model);
        car.setPlate(plate);
        car.setCost(cost);
        car.setAssembly_date(assembly_date);
        
        // Εισαγωγή του αυτοκινήτου στη λίστα με τα διαθέσιμα προς πώληση αυτοκίνητα:
        Garage.addVehicle_for_sale(car);
    }
    
    // Μέθοδος για την εμφάνιση των διαθέσιμων αυτοκινήτων:
    public void viewCarList()
    {
        for (Vehicle v:Garage.vehicles_for_sale)
        {
          System.out.println("Brand :" + v.getBrand() + "Model" + v.getModel());
        }
    }
}
