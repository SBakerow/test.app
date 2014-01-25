package com.pvt.bsa;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 20.01.14
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public interface PersonFacade {
    void addUser(User user);
    List<User> getUsers();
}
