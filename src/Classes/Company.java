/*
 @author X00139670 Lukas Meiliunas
 */
package Classes;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "comId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "COMPANY")

@SuppressWarnings("SerializableClass")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comId_seq")
    @Column(name = "comId")
    private int companyID;
     @Column(name = "companyName")
    private String companyName;
     @Column(name = "location")
    private String location;
    
    
    
    @OneToMany(mappedBy="Company",cascade= CascadeType.ALL)
    private List<Employee> empList = new ArrayList<>();

    public Company() {
    }
    
    
    
    
    
    public Company( String companyName, String location) {
       
        this.companyName = companyName;
        this.location = location;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }
    
    
    
    
    
    
    public void remove() {
        ArrayList<Employee> temp = new ArrayList<>(empList);
        for (int i = 0; i < temp.size(); i++) {
            removeEmployee(temp.get(i));
        }
    }
    
    
    public void removeEmployee(Employee e) {
        empList.remove(e);
        e.getCompany().remove();
    }

    
    
    
    public void addEmployee(Employee e){
        empList.add(e);
        e.setCompany(this);
    }

    @Override
    public String toString() {
        return "--Company Information--" + "\n Company ID: " + companyID + "\n Company name: " + companyName + "\n Location: " + location ;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
