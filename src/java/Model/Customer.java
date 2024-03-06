/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author tinyl
 */
public class Customer {
    private int CustomerID;
    private String FirstName, LastName, Email, Password, Address, Phone;
    private Date Registation;

    public Customer(int CustomerID, String FirstName, String LastName, String Email, String Password, String Address, String Phone, Date Registation) {
        this.CustomerID = CustomerID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.Phone = Phone;
        this.Registation = Registation;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Date getRegistation() {
        return Registation;
    }

    public void setRegistation(Date Registation) {
        this.Registation = Registation;
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerID=" + CustomerID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", Password=" + Password + ", Address=" + Address + ", Phone=" + Phone + ", Registation=" + Registation + '}';
    }
}
