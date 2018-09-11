/*
 @author X00139670 Lukas Meiliunas
 */

package JPAservice;

import Classes.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class JPA {

    EntityManagerFactory emf;
    EntityManager em;

    public JPA() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    /* Add employee. */
    public void addEmployee(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    /* View all current employees. */
    public void viewEmployees() {
        em.getTransaction().begin();
        TypedQuery<Employee> q = em.createQuery("select e from Employee e", Employee.class);
        List<Employee> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No employees found");
        } else {
            System.out.println("Employee List");
            results.forEach((e) -> {
                System.out.println(e);
            });
        }
        em.getTransaction().commit();
    }

    /* Add car to company. */
    public void addCar(Car c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    /* View all cars in database v/ query      */
    public void viewCars() {
        em.getTransaction().begin();
        TypedQuery<Car> q = em.createQuery("select c from Car c", Car.class);
        List<Car> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No Cars are available for sale.");
        } else {
            System.out.println("Cars Currently on Sale: ");
            results.forEach((c) -> {
                System.out.println(c);
            });
        }
        em.getTransaction().commit();
    }

    /* Add Customer to database */
    public void addCustomer(Customer cus) {
        em.getTransaction().begin();
        em.persist(cus);
        em.getTransaction().commit();
    }

    /* View customers in database v/ query.      */
    public void viewCustomer() {
        em.getTransaction().begin();
        TypedQuery<Customer> q = em.createQuery("select cus from Customer cus", Customer.class);
        List<Customer> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No Customer available in the database.");
        } else {
            System.out.println("Current Customers: ");
            results.forEach((cus) -> {
                System.out.println(cus);
            });
        }
        em.getTransaction().commit();
    }

    /* Assign certain cars to customers. */
    public void assignCar(int custId, int cId) {
        em.getTransaction().begin();
        Car c = em.find(Car.class, cId);
        Customer cust = em.find(Customer.class, custId);
        c.addCustomer(cust);
        em.getTransaction().commit();
    }

    /* Unassign cars from customers */
    public void removeCarCustomer(int cid, int custid) {
        em.getTransaction().begin();
        Customer cust = em.find(Customer.class, custid);
        Car c = em.find(Car.class, cid);
        c.removeCustomer(cust);
        em.getTransaction().commit();
    }
 
   
    
    /* Change price of cars      */

    public void changeCarPrice(int cId, double price) {
        em.getTransaction().begin();
        Car c = em.find(Car.class, cId);
        c.setPrice(price);
        em.getTransaction().commit();
    }
    
    
     public void removeCustomerCar(int custId, int cId) {
        em.getTransaction().begin();
        Customer c = em.find(Customer.class, custId);
        Car s = em.find(Car.class, cId);
        c.removeCar(s);
        em.getTransaction().commit();
    }
    
    

    /* Remove an employee from the company */
    public void removeEmpCompany(int eId, int compId) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, eId);
        Company c = em.find(Company.class, compId);
        c.removeEmployee(e);
        em.getTransaction().commit();
    }

    /* Add employee to company  */
    public void addEmployeeCompany(int eId, int compId) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, eId);
        Company c = em.find(Company.class, compId);
        c.addEmployee(e);
        em.getTransaction().commit();
    }

    /* Remove customer from database     */
    public void removeCustomer(int cid) {
        em.getTransaction().begin();
        Customer c = em.find(Customer.class, cid);
        List<Car> results = c.getCarList();
        List<Car> temp = new ArrayList<>(results);
        for (int i = 0; i < temp.size(); i++) {
            Car car = temp.get(i);
            c.removeCar(car);
        }

        em.remove(c);
        em.getTransaction().commit();
    }

    /* View Customers and the cars they are assigned to.      */
    public void viewCustomerCar(int cid) {
        em.getTransaction().begin();
        Car c = em.find(Car.class, cid);
        List<Customer> res = c.getCustList();
        if (res.isEmpty()) {
            System.out.println("No Customer found for this registration number: "
                    + c.getRegNum());
        } else {
            System.out.println("Customer with the following cars: "
                    + c.getRegNum());
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
        em.getTransaction().commit();
    }
    /* View details of the company.      */
    public void viewCompany() {
        em.getTransaction().begin();
        TypedQuery<Company> c = em.createQuery("select c from Company c", Company.class);
        List<Company> results = c.getResultList();

        System.out.println("Employee List");
        results.forEach((f) -> {
            System.out.println(f);
        });

        em.getTransaction().commit();
    }

}
