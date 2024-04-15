/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;
import java.util.Scanner;

public class Sale
{
    // Δήλωση μεταβλητών - δεδομένα:
    private Vehicle car_to_buy;
    private Customer buyer;
    
    // Default constructor:
    public Sale()
    {
        car_to_buy = new Vehicle();
        buyer = new Customer();
    }
    
    // Constructors with arguments:
    public Sale(Vehicle v, Customer c)
    {
        car_to_buy = v;   
        buyer = c;
    }
    
    // Μέθοδος δημιουργίας πώλησης (προσθέτει το όχημα στα οχήματα του αγοραστή και το διαγράφει από τα διαθέσιμα οχήματα):
    public void createSale(Vehicle car, Customer cust) // Θέλει 2 ορίσματα!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    {
        this.car_to_buy = car;
        this.buyer = cust;
        buyer.addVehicle(car_to_buy);
        Garage.deleteVehicle(car);
        System.out.println("Sale comleted successfully!");
    }
}
