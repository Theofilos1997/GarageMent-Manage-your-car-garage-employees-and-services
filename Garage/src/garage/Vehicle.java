package garage;

import java.util.Scanner;

public class Vehicle {
    
    private String brand;
    private String model;
    private String plate;
    private String repair_description;
    private float cost;
    private int assembly_date;

    public Vehicle() 
    {
        System.out.println("Please give the brand,model,plate,repair description,cost and assembly date");
        Scanner input;
        input = new Scanner(System.in);
        brand=input.nextLine();
        input = new Scanner(System.in);     
        model=input.nextLine();
        input = new Scanner(System.in);
        plate=input.nextLine();
        input = new Scanner(System.in);
        repair_description=input.nextLine();
        input = new Scanner(System.in);
        cost=input.nextFloat();
        input = new Scanner(System.in);
        assembly_date=input.nextInt();
    }
        
     

    public Vehicle(String brand, String model, String plate, String repair_description, float cost, int assembly_date) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.repair_description = repair_description;
        this.cost = cost;
        this.assembly_date = assembly_date;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getAssembly_date() {
        return assembly_date;
    }

    public void setAssembly_date(int assembly_date) {
        this.assembly_date = assembly_date;
    }
    
}