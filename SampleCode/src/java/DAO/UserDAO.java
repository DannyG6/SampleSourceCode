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
import model.User;
import util.DBConnection;

/**
 *
 * @author DannyG
 */
public class UserDAO implements DAO<User> {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public UserDAO() throws ClassNotFoundException, SQLException {
        connection = DBConnection.createConnection();
    }

    @Override
    public ArrayList<User> getAllData() {
        ArrayList<User> data = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `user`";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Role role = new RoleDAO().getSingleData(resultSet.getInt("role_id"));
                User model = new User(id, name, email, role);
                data.add(model);
            }
        } catch (Exception e) {

        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
                connection.close();
            } catch (Exception ex) {
            }
        }
        return data;
    }

    @Override
    public User getSingleData(int id) {
        try {
            String sql = "SELECT * FROM `user` where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                Role role = new RoleDAO().getSingleData(resultSet.getInt("role_id"));
                User user = new User(id, name, email, role);
                return user;
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
    public boolean create(User model) {
        try {
            String sql = "INSERT INTO `user` (`id`, `name`, `email`, `role_id`) VALUES (NULL, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getEmail());
            preparedStatement.setInt(3, model.getChoosenRole());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {

        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex) {
            }
        }
        return false;
    }

    @Override
    public boolean update(User model) {
        try {
            String sql = "UPDATE `user` SET `name` = ? , `email` = ?,`role_id` = ? WHERE `user`.`id` = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getEmail());
            preparedStatement.setInt(3, model.getChoosenRole());
            preparedStatement.setInt(4, model.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {

        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex) {
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM `user` WHERE `user`.`id` = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {

        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex) {
            }
        }
        return false;
    }

}
