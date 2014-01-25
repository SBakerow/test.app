package com.pvt.bsa.dbModule.service;

import com.pvt.bsa.User;
import com.pvt.bsa.dbModule.dao.JdbcPersonDao;
import com.pvt.bsa.dbModule.utils.MyDbDataSource;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 23.01.14
 * Time: 0:04
 * To change this template use File | Settings | File Templates.
 */
public class Service {

    public void addUser(User user)
    {   JdbcPersonDao jdbcPersonDao= new JdbcPersonDao(MyDbDataSource.getInstance());
        jdbcPersonDao.addUser(user);
    }

    public List<User> getAllUsers(){
        JdbcPersonDao jdbcPersonDao= new JdbcPersonDao(MyDbDataSource.getInstance());
      return   jdbcPersonDao.getAllUsers();
    }

    public void deleteUser(User user){

        JdbcPersonDao jdbcPersonDao= new JdbcPersonDao(MyDbDataSource.getInstance());
        jdbcPersonDao.deleteUser(user);

    }
    public void deleteUser(Integer id){

        JdbcPersonDao jdbcPersonDao= new JdbcPersonDao(MyDbDataSource.getInstance());
        jdbcPersonDao.deleteUser(id);

    }

    public void updateUser(User user){
        JdbcPersonDao jdbcPersonDao= new JdbcPersonDao(MyDbDataSource.getInstance());
        jdbcPersonDao.updateUser(user);

    }
}
