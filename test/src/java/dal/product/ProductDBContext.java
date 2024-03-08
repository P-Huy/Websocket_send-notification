/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.product;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.product.Product;

/**
 *
 * @author admin
 */
public class ProductDBContext extends DBContext<Product>
{

        @Override
        public ArrayList getList(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        @Override
        public Product get(String field, String value)
        {
                String sql = "Select * from product\n";
                if (!field.equals(""))
                {
                        sql += "where " + field + " = " + value;
                } // SQL Injection
                PreparedStatement statement = null;
                try
                {
                        statement = connection.prepareStatement(sql);

                        ResultSet result = statement.executeQuery();
                        while (result.next())
                        {
                                Product product = new Product();
                                product.setId(result.getInt("id"));
                                product.setProductName(result.getString("productName"));
                                product.setUserId(result.getInt("userId"));

                                return product;
                        }
                } catch (SQLException er)
                {
                        er.printStackTrace();
                }
                return null;
        }

        @Override
        public Product insert(Product model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void update(Product model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void delete(int id)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
}
