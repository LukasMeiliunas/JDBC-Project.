/*
 @author X00139670 Lukas Meiliunas
 */
package Classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "cId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "Car")

@SuppressWarnings("SerializableClass")

public class Car {
    
    /* Declare Variablaes*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cId_seq")
    @Column(name = "cID")
    private int carID;
    @Column(name = "regNum")
    private String regNum;
    @Column(name = "engSize")
    private double engineSize;

    @Column(name = "yom")
    @Temporal(TemporalType.DATE)
    private Calendar yearOfManufacture;
    @Column(name = "price")
    private double price;
    @Column(name = "color")
    private String color;

    @ManyToMany(mappedBy = "carList", cascade = CascadeType.PERSIST)
    private List<Customer> custList = new ArrayList<>();

    public Car() {
    }

    /* Constructor */
    public Car(String regNum, double engineSize, Calendar yearOfManufacture, double price, String color) {

        this.regNum = regNum;
        this.engineSize = engineSize;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.color = color;
    }

    /* Getter and Setters */
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public Calendar getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Calendar yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Customer> getCustList() {
        return custList;
    }

    public void setCustList(List<Customer> custList) {
        this.custList = custList;
    }

    public void addCustomer(Customer c) {
        custList.add(c);
        c.getCarList().add(this);
    }

    public void removeCustomer(Customer c) {
        custList.remove(c);
        c.getCarList().remove(this);
    }

    
    public void remove() {
        ArrayList<Customer> temp = new ArrayList<>(custList);
        for (int i = 0; i < temp.size(); i++) {
            removeCustomer(temp.get(i));
        }
    }

    /* toString method to format output */
    
    @Override
    public String toString() {
        String g = String.format("%1$s %2$tB %2$td, %2$tY",
                " Date of Manufacture: ", yearOfManufacture);
        
    
        return "\n Car Id:" + carID + "\nRegistration Number: " + regNum + "\n Engine Size: " + engineSize + "\n Current price in Euro: " + price + "\n Color: " + color +"\n "+g;
    }
    
    
    
}
