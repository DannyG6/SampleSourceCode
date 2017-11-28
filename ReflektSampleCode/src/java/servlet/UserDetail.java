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
public class UserDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        User user = null;

        try {
            user = new UserDAO().getSingleData(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDetail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDetail.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.setAttribute("status", 0);
        req.setAttribute("userSingle", user);

        RequestDispatcher rd = null;
        rd = req.getRequestDispatcher("/UserView.jsp");
        rd.forward(req, resp);
    }

}
