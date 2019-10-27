package cn.hd.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee implements Serializable {
    private static final long serialVersionUID = -908L;

    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
    private int salaryLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public int getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(int salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

}
