package controller.student;

import entity.Student;
import model.StudentModel;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudent extends HttpServlet {
    private StudentModel student = new StudentModel();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student obj = student.findById(id);
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            student.delete(id);
            resp.sendRedirect("/students/list.jsp");
        }
    }
}
