/*
 @author X00139670 Lukas Meiliunas
 */
package Classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "eId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "Emp")

@SuppressWarnings("SerializableClass")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eId_seq")
    @Column(name = "eID")
    private int empId;
    @Column(name = "fName")
    private String fName;
    @Column(name = "lName")
    private String lName;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Calendar startDate;
    
    
    @ManyToOne()
    @JoinColumn(name="comId")
    private Company company;

    public Employee() {
    }

    public Employee( String fName, String lName, Calendar startDate) {
        
        this.fName = fName;
        this.lName = lName;
        this.startDate = startDate;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
         String d = String.format("%1$s %2$tB %2$td, %2$tY",
                " Start date: ", startDate);
        
        
        return "Employee Information: "+ "\n Employee Id: " + empId + "\n First Name: " + fName + "\n Surname: " + lName+ "\n" +d;
    }
    
    public void removeEmployee(Company s) {
       company.remove();
        s.getEmpList().remove(this);
    }
    
    
    
    
    
    
}
