/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author DannyG
 */
public class UserView extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> user = null;
        try {
            user = new UserDAO().getAllData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("userList", user);
        RequestDispatcher rd = null;
        rd = req.getRequestDispatcher("/UserView.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> user = null;

        try {
            user = new UserDAO().getAllData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.setAttribute("userList", user);
        req.setAttribute("status", 1);

        RequestDispatcher rd = null;
        rd = req.getRequestDispatcher("/UserView.jsp");
        rd.forward(req, resp);
    }
}
