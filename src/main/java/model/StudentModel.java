package model;

import entity.Student;
import util.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {

    public boolean save(Student student) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into student (id, rollNumber, email, name) values (1, 'A002', 'hung@gmail.com', 'Hung')";
            String sqlStatement =
                    String.format("insert into student (id, rollNumber, email, name) values (%d, '%s', '%s', '%s')",
                            student.getId(), student.getRollNumber(), student.getEmail(), student.getName());

            statement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> findAll() {
        List<Student> listStudent = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            String sqlSelect = "select * from student";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            while (rs.next()) {
                int id = rs.getInt("id");
                String rollNumber = rs.getString("rollNumber");
                String email = rs.getString("email");
                String name = rs.getString("name");
                Student student = new Student(id, rollNumber, email, name);
                listStudent.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudent;
    }
    public Student findById(int id) {
        Student obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from student where id = ?") ;
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String rollNumber = rs.getString("rollNumber");
                String email = rs.getString("email");
                obj = new Student(id, rollNumber, email, name);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return  obj;
    }
    public boolean delete(int id){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            Statement statement = connection.createStatement();
            String sqlStatement =
                    String.format("delete from student where id =%d", id);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
