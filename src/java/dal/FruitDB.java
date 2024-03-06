/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Fruit;
import java.lang.System.Logger;
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

public class FruitDB extends DBContext{
    public List<Fruit> getAll(){
        List<Fruit> listFruit = new ArrayList<>();
        String sql = "Select productID, productName, description, price from Products";
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
             while(rs.next()){
                listFruit.add(new Fruit(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listFruit;
    }
    
        public int newFruit(Fruit s){
        int id=-1;
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("Insert into Fruit(ProductID, ProductName, Description, Category, Price, StockQuantity, ProductImage, UnitOfMeasurement) output inserted.id values(?,?,?)");
            stmt.setString(1, s.getProductName());
            stmt.setString(2, s.getProductName());
          
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
            connection.close();
        } catch (Exception ex) {
             java.util.logging.Logger.getLogger(FruitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
        
    public Fruit getFruit(int id){
        Fruit s=null;
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("Select productName, description, price  from Products where productID=?");
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                String name=rs.getString(1);
                String description=rs.getString(2);
                double price = rs.getDouble(3);
                s=new Fruit(id,name,description,price);
            }
            connection.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FruitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public Fruit update(Fruit s){
            PreparedStatement stmt;
            try{
                stmt =connection.prepareStatement("Update Products set productName=?, description=?,price=? where productID =?");
                stmt.setString(1, s.getProductName());
                stmt.setString(2, s.getDescription());
            
            int rc=stmt.executeUpdate();
            connection.close();
            return s;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FruitDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
    
    public int delete(int id){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("Delete Products where productID =?");
            stmt.setInt(1, id);
            int rc=stmt.executeUpdate();
            connection.close();
            return rc;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FruitDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return 0;
    }
    
    public static void main(String[] args) {
        FruitDB f = new FruitDB();
        List<Fruit> lf = f.getAll();
        for(Fruit o : lf){
            System.out.println(o.toString());
        }
    }
}
