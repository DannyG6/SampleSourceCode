/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author DannyG
 */
public interface DAO<T> {
    public ArrayList<T> getAllData();
    public T getSingleData(int id);
    public boolean create(T model);
    public boolean update(T model);
    public boolean delete(int id);
}
