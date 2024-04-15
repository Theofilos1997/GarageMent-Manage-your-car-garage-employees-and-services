/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class main {
    
     public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException 
    {
        Garage garage=new Garage();
        garage.connect();
        garage.initialize();
        printMenu();
        garage.updateDatabase();
    }
     
    public static int printMenu()
    {
        System.out.println("Please give your username");
        String username,password;
        Scanner input=new Scanner(System.in);
        username=input.nextLine();
        System.out.println("Please give your password");
        password=input.nextLine();
        if(Employee.login(username, password) != null)
        {
            for(;;)
            {
                Employee temp=Employee.login(username, password);
                switch(temp.getSector())
                {
                    // 0: Administrator
                    case 0:
                    {
                        Admin tempadm=(Admin)temp;
                        System.out.println("Give 1 to create Employee, 2 to modify Employee, 3 to delete Employee, 0 to exit");
                        int choice;
                        try
                        {
                            choice=input.nextInt();
                        }
                        catch(InputMismatchException ex)
                        {
                            System.out.println("Wrong choice");
                            input.nextLine();
                            break;
                        }
                        if(choice != 0 && choice != 1 && choice != 2 && choice != 3)
                        {
                            System.out.println("Wrong choice");
                        }
                        switch(choice)
                        {
                            case 0:
                            {
                                return 0;
                            }
                            case 1:
                            {
                                tempadm.createEmployee();
                                break;
                            }
                            case 2:
                            {
                                tempadm.modifyEmployee();
                                break;
                            }
                            case 3:
                            {
                                tempadm.deleteEmployee();
                                break;
                            }
                        }
                        break;
                    }
                    // 1: Secretary
                    case 1:
                    {
                        Secretary tempsec=(Secretary)temp;
                        System.out.println("Give 1 to Create Appointment, 2 to update Customers, 0 to exit");
                        int choice;
                        try
                        {
                            choice=input.nextInt();
                        }
                        catch(InputMismatchException ex)
                        {
                            System.out.println("Wrong choice");
                            input.nextLine();
                            break;
                        }
                        if(choice != 0 && choice != 1 && choice !=2)
                        {
                            System.out.println("Wrong choice");
                        }
                        switch(choice)
                        {
                            case 0:
                            {
                                return 0;
                            }
                            case 1:
                            {
                                tempsec.createAppointment();
                                break;
                            }
                            case 2:
                            {
                                tempsec.updateCostumers();
                                break;
                            }
                        }
                        break;
                    }
                    // 2: Technician
                    case 2:
                    {
                        Technician temptech=(Technician)temp;
                        temptech.CreateService();
                        break;
                    }
                    // 3: Seller
                    case 3:
                    {
                        Seller tempsel=(Seller)temp;
                        System.out.println("Give 1 to Create Sale, 2 to view available cars for sale, 3 to insert new car, 0 to exit");
                        int choice;
                        try
                        {
                            choice=input.nextInt();
                        }
                        catch(InputMismatchException ex)
                        {
                            System.out.println("Wrong choice");
                            input.nextLine();
                            break;
                        }
                        if(choice != 0 && choice != 1 && choice != 2 && choice != 3)
                        {
                            System.out.println("Wrong choice");
                        }
                        switch(choice)
                        {
                            case 0:
                            {
                                return 0;
                            }
                            case 1:
                            {
                                tempsel.createSale();
                                break;
                            }
                            case 2:
                            {
                                tempsel.viewCarList();
                                break;
                            }
                            case 3:
                            {
                                tempsel.insertCar();
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        else
        {
            System.out.println("Wrong username or password");
        }
     return 0;  
    }
}