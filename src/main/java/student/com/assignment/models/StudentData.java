package student.com.assignment.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String firstname;
    private String lastname;
    private int weight;
    private int height;
    private String haircolor;
    private float gpa;
    public StudentData() {
    }
    public StudentData(String firstname, String lastname, int weight, int height, String haircolor,
            float gpa) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.weight = weight;
        this.height = height;
        this.haircolor = haircolor;
        this.gpa = gpa;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getHaircolor() {
        return haircolor;
    }
    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    
}
