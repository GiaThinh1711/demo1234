package controller;

import entity.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentModel studentModel = new StudentModel();
        List<Student> listStudent = studentModel.findAll();
        req.setAttribute("listStudent", listStudent);
        req.getRequestDispatcher("/admin/students/list.jsp").forward(req, resp);
    }
}
