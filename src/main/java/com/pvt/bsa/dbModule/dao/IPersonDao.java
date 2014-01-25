package com.pvt.bsa.dbModule.dao;

import com.pvt.bsa.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 21.01.14
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public interface IPersonDao {
    void addUser(User user);
    void deleteUser(User user);
    User getUser(int id);
    void updateUser(User user);
    public List<User> getAllUsers();

}
