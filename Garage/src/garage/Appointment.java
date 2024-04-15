package garage;

import static garage.Garage.searchCustomervehicle;
import java.util.Scanner;


class Appointment 
{
    
    Scanner keyboard = new Scanner(System.in);
    private Customer Appointment_Customer=new Customer();
    
    public Appointment()
    {
        
    }
    
    public Appointment(Customer c)
    {
        Appointment_Customer=c;
    }
    
    public void setAppointment(String plate)
    {
        
        Vehicle v=new Vehicle();        
        System.out.println("Creating and appointment for "+Appointment_Customer.getName()+""+Appointment_Customer.getSurname()+".");
        v=searchCustomervehicle(Appointment_Customer,plate);
        System.out.println("Enter the description for the repair:");
        String description=keyboard.nextLine();
        v.setRepair_description(description);
        insertintoRepairvehicles(v);
    }
    
    public void insertintoRepairvehicles(Vehicle v)
    {
        Garage.vehicles_for_repair.add(v);
    }
}
