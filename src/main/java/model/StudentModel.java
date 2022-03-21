package model;

import entity.Student;
import util.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {

    public boolean save(Student student) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connetion = connectionHelper.getConnection();
            Statement statement = connetion.createStatement();
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

        }
        return listStudent;
    }

    public static void main(String[] args) {
        String sql = String.format("insert into student (id, rollNumber, email, name) values (%d, '%s', '%s', '%s')", 1, "A003", "Hung", "hung");

        System.out.println(sql);
    }
}
