package service;

import java.io.Serializable;

public class Person implements Serializable {
    private static Person INSTANCE = new Person();
    private String name;
    private String gender;
    private String address;
    private String telephone;
    private String email;

    public Person(String name, String gender, String address, String telephone, String email) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Person getInstance() {
        return INSTANCE;
    }

    private Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
