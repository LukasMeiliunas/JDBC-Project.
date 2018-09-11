package Test;

import JPAservice.JPA;
import Classes.*;

import java.util.Calendar;
import java.util.Scanner;

public class Test {

    static JPA jpa = new JPA();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("");
            System.out.println("Please press 1 to view all employees.");
            System.out.println("Please press 2 to view all current Customers.");
            System.out.println("Please press 3 to view all cars in stock.");
            System.out.println("Please press 4 to view Company details.");
            System.out.println("Please press 5 to add a new Vehicle to our stock.");
            System.out.println("Please press 6 to add a new  employee");
            System.out.println("Please press 7 to add a new Customer");
            System.out.println("Please press 8 to change the price of one of our current cars.");
            System.out.println("Please press 9 to remove an employee from our company.");
            System.out.println("Please press 10 to assign a customer to a car.");
            System.out.println("Please press 11 to view which cars are assigned to customers.");
            System.out.println("Please press 14 to unassign a customer from a car.");
            System.out.println("Press 12 to quit");

            int choice = in.nextInt();
          in.nextLine();

            switch (choice) {

                case 1:
                    jpa.viewEmployees();
                    break;

                case 2:
                    jpa.viewCustomer();
                    break;
                case 3:
                    jpa.viewCars();
                    break;
                case 4:
                    jpa.viewCompany();
                    break;

                case 5:
                    System.out.println("Please Enter the REG of the new car ");
                    String regNum = in.nextLine();
                    System.out.println("Please enter enginge size ex: 1.2");
                    double engineSize = in.nextDouble();
                    System.out.println("Please Enter the year  of the car");
                    int year = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the month of the car: ");
                    int month = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the day of the car: ");
                    int day = in.nextInt();
                    in.nextLine();

                    Calendar yearOfManufacture = Calendar.getInstance();
                    yearOfManufacture.set(year, month, day);
                    System.out.println("Please enter the price of the car you wish to add: ");
                    double price = in.nextDouble();
                    in.nextLine();
                    System.out.println("Please enter color:");
                    String color = in.nextLine();

                    Car c = new Car(regNum, engineSize, yearOfManufacture, price, color);

                    jpa.addCar(c);

                    break;

                case 6:
                    System.out.println("Please enter the first name of the employee you wish to add: ");
                    String fName = in.nextLine();
                    System.out.println("Please enter the last name of the employee you wish to add: ");
                    String lName = in.nextLine();
                    System.out.println("Please enter the start year of the employee: ");
                    int year1 = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the start month of the employee: ");
                    int month1 = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the start day of the employee: ");
                    int day1 = in.nextInt();
                    
                    Calendar startDate = Calendar.getInstance();
                    startDate.set(year1, month1, day1);
                    Employee e = new Employee(fName, lName, startDate);
                    jpa.addEmployee(e);

                    break;
                case 7:
                    System.out.println("Please enter the first name of the Customer : ");
                    String fName1 = in.nextLine();
                    System.out.println("Please enter the last name of the Customer: ");
                    String lName1 = in.nextLine();
                    System.out.println("Please enter the year of birth : ");
                    int year2 = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the month: ");
                    int month2 = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the day : ");
                    int day2 = in.nextInt();
                    in.nextLine();
                    Calendar dob = Calendar.getInstance();
                    dob.set(year2, month2, day2);
                    Customer g = new Customer(fName1, lName1, dob);
                    jpa.addCustomer(g);
                    break;
                case 8:
                    System.out.println("please enter the id of the car which price you would like to chage: ");
                    int cId = in.nextInt();
                    in.nextLine();
                    System.out.println("please enter the new price: ");
                    double Vprice = in.nextDouble();
                    jpa.changeCarPrice(cId, Vprice);
                    break;

                case 9:
                    System.out.println("Please enter 1 as this is the id of our company.");
                    int compId = in.nextInt();
                    System.out.println("Please enter the id of the employee you wish to remove from the company: ");
                    int eId = in.nextInt();
                    jpa.removeEmpCompany(eId, compId);
                    break;
                case 10:
                    System.out.println("Please enter the Customer id in order to assign a car: ");
                     int custID = in.nextInt();
                    System.out.println("Please enter the id of the car you wish to assign a customer to: " );
                    int cId1 = in.nextInt();
                    jpa.assignCar(custID, cId1);
                    break;
                    
                 case 14:
                     System.out.println("Please enter the car id :");
                     int l = in.nextInt();
                     System.out.println("Please enter the customer id :");
                     int l1 = in.nextInt();
                     
                     jpa.removeCustomerCar(l,l1);
                    
                    break;

                
                case 11:
                    System.out.println("Please enter the id of the car to see which customer is assigned to it.");
                    int ssid = in.nextInt();
                    in.nextLine();
                    jpa.viewCustomerCar(ssid);
                    break;
                
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }

        }
    }
}

