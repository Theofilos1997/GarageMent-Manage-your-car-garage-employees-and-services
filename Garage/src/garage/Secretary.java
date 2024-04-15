package garage;

import static garage.Garage.searchCustomer;
import java.util.ArrayList;
import java.util.Scanner;


public class Secretary extends Employee 
{
    
    
    ArrayList<Appointment> Appointments=new ArrayList<>();
    CustomerUpdater updater=new CustomerUpdater();
    
    
    Scanner sc = new Scanner(System.in);
    
    /**
     * Constructor without parameters for Secretary,it is empty. 
     */
    public Secretary()
    {
        super(1);
        this.Appointments =  new ArrayList <> ();
    
    }
    
    /**
     * Constructor without parameters for Secretary,it adds appointments to the Appointment arraylist.
     * @param a 
     */
    public Secretary(Appointment a)
    {
        super(1);
        this.Appointments.add(a);
    }
    
    public Secretary(String n,String s,String e,long p,String a,int sec,String u,String pass)
    {
        super(n,s,e,p,a,sec,u,pass);
    }
    
    
    /**
     * Checks if the costumer exists,if he exists it proceeds to setAppointment.
     * If not,he creates a new costumer and calls the method again.
     * Repeats until the costumer is found basically.
     */ 
    public void createAppointment()
    {
        String plate=new String();
        System.out.println("Enter the plate of the vehicle");
        plate=sc.nextLine();
        if (Garage.searchCustomer(plate)==null)
        {
            Customer c= Garage.createCustomer();
            Appointment a = new Appointment(c);
            a.setAppointment(plate);
            Appointments.add(a);
        }
        else
        {
            Appointment a = new Appointment(Garage.searchCustomer(plate));
            a.setAppointment(plate);
            Appointments.add(a);
        }
        
    }
    
    public void updateCostumers()
    {
        for(String s : updater.getUpdates())
        {
            System.out.println(s);
        }
    }
    
}
