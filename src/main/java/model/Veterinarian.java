package model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "veterinarian")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idVeterinarian;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "speciality")
    private String speciality;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "veterinarian")
    private List<Consult> consults;


    public Veterinarian() {
    }

    public Veterinarian(String firstName, String lastName, String address, String speciality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = speciality;
    }

    public Long getIdVeterinarian() {
        return idVeterinarian;
    }

    public void setIdVeterinarian(Long idVeterinarian) {
        this.idVeterinarian = idVeterinarian;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "idVeterinarian=" + idVeterinarian +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", speciality='" + speciality + '\''  +
                '}';
    }
}