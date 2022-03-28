package model;

import entity.Product;
import util.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    public boolean save(Product obj) {
        try {
            Connection connetion = ConnectionHelper.getConnection();
            PreparedStatement prepareStatement = connetion.prepareStatement("insert into product (name, thumbnail, price) values (?, ?, ?)");
            prepareStatement.setString(1,obj.getName());
            prepareStatement.setString(2,obj.getThumbnail());
            prepareStatement.setDouble(3,obj.getPrice());
            prepareStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> findAll() {
        List<Product> listObj = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            String sqlSelect = "select * from product";
            PreparedStatement prepareStatement = connection.prepareStatement(sqlSelect);
            ResultSet rs = prepareStatement.executeQuery(sqlSelect);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int status = rs.getInt("status");
                Product obj = new Product(id, name, thumbnail, price, status);
                listObj.add(obj);
            }
        } catch (Exception e) {

        }
        return listObj;
    }
    public Product findById(int id) {
        Product obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from product where id = ?") ;
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int status = rs.getInt("status");
                obj = new Product(id, name, thumbnail, price, status);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return  obj;
    }
    public boolean update(int id, Product updateProduct) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connetion = connectionHelper.getConnection();
            Statement statement = connetion.createStatement();
            String sqlStatement =
                    String.format("update product set name = '%s', thumbnail = '%s', price = %f , status = %d where id =%d",
                            updateProduct.getName(), updateProduct.getThumbnail(), updateProduct.getStatus(), id);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connetion = connectionHelper.getConnection();
            Statement statement = connetion.createStatement();
            String sqlStatement =
                    String.format("delete from product where id =%d", id);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
