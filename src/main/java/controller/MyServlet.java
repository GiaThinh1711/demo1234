package controller;
import entity.Student;
import model.StudentModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String rollNumber = req.getParameter("rollNumber");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        Student student = new Student(id,rollNumber,email,name);
        StudentModel studentModel = new StudentModel();
        studentModel.save(student);
        resp.getWriter().println("Success");
    }
}
