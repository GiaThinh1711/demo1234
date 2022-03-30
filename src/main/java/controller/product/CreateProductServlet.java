package controller.product;

import entity.Product;
import model.ProductModel;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String thumbnail = req.getParameter("thumbnail");
        String name = req.getParameter("name");
            Double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product(name,thumbnail,price);
        if(!product.isValid()) {
            req.setAttribute("errors",product.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            return;
        }
        ProductModel productModel = new ProductModel();
        productModel.save(product);
        resp.sendRedirect("/products/list");
    }
}
