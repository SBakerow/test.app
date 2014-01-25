package com.pvt.bsa.dbModule;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 21.01.14
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */
public class MyDbDataSource {
    private static volatile MyDbDataSource instance;
    private DataSource ds = null;

    public static MyDbDataSource getInstance() {
        MyDbDataSource localInstance = instance;
        if (localInstance == null) {
            synchronized (MyDbDataSource.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new MyDbDataSource();
                }
            }
        }
        return localInstance;
    }

    public MyDbDataSource() {

     try  {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
