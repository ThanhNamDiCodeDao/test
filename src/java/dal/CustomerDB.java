/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author tinyl
 */
public class CustomerDB extends DBContext{
    public List<Customer> getAll(){
        List<Customer> listCustomer = new ArrayList<>();
        String sql = "Select * from Customers";
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
             while(rs.next()){
                listCustomer.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCustomer;
    }
    
    public Customer getCustomer(String email, String password){
        List<Customer> listCustomer = getAll();
        for(Customer customer : listCustomer){
            if(email.equals(customer.getEmail())){
                if(password.equals(customer.getPassword())){
                    return customer;
                }
                else break;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        CustomerDB c = new CustomerDB();
        List<Customer> l = c.getAll();
        for(Customer o : l){
            System.out.println(o.toString());
        }
    }
}
