/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.product;

/**
 *
 * @author admin
 */
public class Product
{
        private int id;
        private String productName;
        private int userId;

        public Product()
        {
        }

        public Product(int id, String productName, int userId)
        {
                this.id = id;
                this.productName = productName;
                this.userId = userId;
        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public String getProductName()
        {
                return productName;
        }

        public void setProductName(String productName)
        {
                this.productName = productName;
        }

        public int getUserId()
        {
                return userId;
        }

        public void setUserId(int userId)
        {
                this.userId = userId;
        }
        
}
