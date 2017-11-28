/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Role;
import util.DBConnection;

/**
 *
 * @author DannyG
 */
public class RoleDAO implements DAO<Role> {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public RoleDAO() throws ClassNotFoundException, SQLException {
        connection = DBConnection.createConnection();
    }

    @Override
    public ArrayList<Role> getAllData() {
        ArrayList<Role> data = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `role`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Role model = new Role(id, name);
                data.add(model);
            }
        } catch (Exception e) {

        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex) {
            }
        }
        return data;
    }

    @Override
    public Role getSingleData(int id) {
        try {
            String sql = "SELECT * FROM `role` where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Role role = new Role(id, name);
                return role;
            }
        } catch (Exception e) {

        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex) {
            }
        }
        return null;
    }

    @Override
    public boolean create(Role model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Role model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
