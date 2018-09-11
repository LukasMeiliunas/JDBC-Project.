/*
 @author X00139670 Lukas Meiliunas
 */
package Classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "custId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "Customer")

@SuppressWarnings("SerializableClass")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custId_seq")
    @Column(name = "custID")
    private int custID;
    @Column(name = "fName")
    private String fNAme;
    @Column(name = "lName")
    private String lName;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Calendar dob;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CarCustomer",
            joinColumns = @JoinColumn(name = "custId"),
            inverseJoinColumns = @JoinColumn(name = "cId"))
    private List<Car> carList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String fNAme, String lName, Calendar dob) {

        this.fNAme = fNAme;
        this.lName = lName;
        this.dob = dob;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getfNAme() {
        return fNAme;
    }

    public void setfNAme(String fNAme) {
        this.fNAme = fNAme;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    
    public void removeCar(Car c){
        carList.remove(c);
        c.getCustList().remove(this);
    }

    @Override
    public String toString() {
        
         String g = String.format("%1$s %2$tB %2$td, %2$tY",
                " Date of Birth: ", dob);
        
        
        
        return "Customer Information: "+ "\n Customer Id: " + custID + "\n First Name: " + fNAme + "\n Surname: " + lName+ "\n "+g;
    }

    

    
    
}
