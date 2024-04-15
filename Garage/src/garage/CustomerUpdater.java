package garage;

import java.util.ArrayList;


public class CustomerUpdater {
    public static ArrayList<String> updates=new ArrayList<>();
    
    /**
    * The constructor without parameters for CustomerUpdater.
    * Prints the update for a costumer.
    */
    public CustomerUpdater()
    {
        
    }
    
    /**
     * The constructor with parameters for CustomerUpdater.
     * Adds an update for a costumer.
     * @param s 
     */
    public CustomerUpdater(String s)
    {
        updates.add(s);
    }
    
    public ArrayList<String> getUpdates()
    {
        return updates;
    }
        
}
