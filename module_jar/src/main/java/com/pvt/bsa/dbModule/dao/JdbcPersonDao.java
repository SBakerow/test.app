package com.pvt.bsa.dbModule.dao;

import com.pvt.bsa.User;
import com.pvt.bsa.dbModule.utils.MyDbDataSource;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 21.01.14
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 */
public class JdbcPersonDao implements IPersonDao {
    //private String sqlQuery="";
    private MyDbDataSource dataSource ;
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    public JdbcPersonDao(MyDbDataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void addUser(User user) {
        String sqlQuery="";
        try {

            connection= dataSource.getDs().getConnection() ;


           // sqlQuery = "INSERT INTO users(name,age) VALUES ('"+user.getName()+"'"+","+String.valueOf(user.getAge())+");";
            sqlQuery = "INSERT INTO users(name,age) VALUES (?,?)";
            System.out.println("\n"+sqlQuery+"\n");
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
        }finally {
            try {
                if(preparedStatement !=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteUser(User user) {

        String sqlQuery="";
        try {

            connection= dataSource.getDs().getConnection() ;


            // sqlQuery = "INSERT INTO users(name,age) VALUES ('"+user.getName()+"'"+","+String.valueOf(user.getAge())+");";
            sqlQuery = "DELETE FROM users WHERE name =? AND age =?;";
            System.out.println("\n"+sqlQuery+"\n");
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
        }finally {
            try {
                if(preparedStatement !=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
        }
    }

    public void deleteUser(Integer id) {

        String sqlQuery="";
        try {

            connection= dataSource.getDs().getConnection() ;


            // sqlQuery = "INSERT INTO users(name,age) VALUES ('"+user.getName()+"'"+","+String.valueOf(user.getAge())+");";
            sqlQuery = "DELETE FROM users WHERE idusers =?;";
            System.out.println("\n"+sqlQuery+"\n");
            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
        }finally {
            try {
                if(preparedStatement !=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
        }
    }

    @Override
    public User getUser(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
        String sqlQuery="";
        try {

            connection= dataSource.getDs().getConnection() ;


            // sqlQuery = "INSERT INTO users(name,age) VALUES ('"+user.getName()+"'"+","+String.valueOf(user.getAge())+");";
            sqlQuery = "UPDATE users SET name = ? , age =? WHERE idusers =?;";
            System.out.println("\n"+sqlQuery+"\n");
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3,user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
        }finally {
            try {
                if(preparedStatement !=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List <User>users = new ArrayList<User>();
        String sqlQuery="";
        try {

            connection= dataSource.getDs().getConnection() ;
            statement = connection.createStatement();

            // sqlQuery = "INSERT INTO users(name,age) VALUES ('"+user.getName()+"'"+","+String.valueOf(user.getAge())+");";
            sqlQuery = "SELECT name, age, idusers FROM users";
            System.out.println("\n"+sqlQuery+"\n");
           ResultSet rs = statement.executeQuery(sqlQuery);

           while(rs.next()){

              users.add(new User(rs.getInt("age"),rs.getString("name"),rs.getInt("idusers")));
               System.out.println("\n"+rs.getString("name")+"\n");
           }
           rs.close();

        } catch (SQLException e) {

            e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
        }finally {
            try {
                if(statement !=null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch preparedStatement use File | Settings | File Templates.
            }
            return users;
        }
    }
}
