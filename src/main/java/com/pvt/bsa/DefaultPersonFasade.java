package com.pvt.bsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 20.01.14
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
public class DefaultPersonFasade implements PersonFacade {
    private static DefaultPersonFasade ourInstance = new DefaultPersonFasade();
    private List<User> userList ;
    public static DefaultPersonFasade getInstance() {
        return ourInstance;
    }

    private DefaultPersonFasade() {
         userList=new ArrayList<User>();
        userList.add(new User(10,"user1"));
        userList.add(new User(20,"user2"));
    }
    @Override
    public void addUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
        userList.add(user);
    }

    @Override
    public List<User> getUsers() {
        return userList;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
