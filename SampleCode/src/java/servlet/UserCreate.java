/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.RoleDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Role;
import model.User;

/**
 *
 * @author DannyG
 */
public class UserCreate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0;
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int role_id = Integer.parseInt(req.getParameter("role_id"));

        User model = new User(id, name, email, null, role_id);

        try {
            UserDAO userDAO = new UserDAO();
            userDAO.create(model);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserCreate.class.getName()).log(Level.SEVERE, null, ex);
        }

        resp.sendRedirect("/SampleCode/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Role> role = null;
        try {
            role = new RoleDAO().getAllData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserCreate.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.setAttribute("roleList", role);

        RequestDispatcher rd = null;
        rd = req.getRequestDispatcher("/UserCreate.jsp");
        rd.forward(req, resp);
    }

}
