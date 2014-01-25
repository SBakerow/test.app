package com.pvt.bsa.servlets;

import com.pvt.bsa.DefaultPersonFasade;
import com.pvt.bsa.User;
import com.pvt.bsa.dbModule.service.Service;


import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 20.01.14
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 */
public class UsersServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Service service= new Service();
        Enumeration<String>names= request.getParameterNames();

        Object del[]= request.getParameterValues("delete");
        Object upd[]= request.getParameterValues("update");
        Object addName[]= request.getParameterValues("name");
        Object addAge[]= request.getParameterValues("age");
        if(del!=null){

            String[] ids=request.getParameterValues("checkbox");
            for(String id:ids ){
              service.deleteUser(Integer.valueOf(id));

            }

        }
       // String action = request.getParameter("action");
        if(addName!=null&& addAge!=null ){

            String name=request.getParameter("name");

            Integer age =Integer.valueOf(request.getParameter("age"));
            service.addUser(new User(age,name));
        }

        if(upd!=null ){

            String name=request.getParameter("nameUpd");

            Integer age =Integer.valueOf(request.getParameter("ageUpd"));
            String[] ids=request.getParameterValues("checkbox");
            for(String id:ids ){
                service.updateUser(new User(age,name,Integer.valueOf(id)));

            }

        }

       // DefaultPersonFasade.getInstance().addUser(new User(age,name));



      //  service.getAllUsers();
        //service.deleteUser(new User(age,name));
        request.setAttribute("users",service.getAllUsers());
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Service service= new Service();
        request.setAttribute("users",service.getAllUsers());

     /*   HttpSession session = request.getSession(true);

        session.setAttribute("users",  DefaultPersonFasade.getInstance().getUsers());  */
        request.getRequestDispatcher("/list.jsp").forward(request, response);
      //response.sendRedirect("list.jsp"); ;
    }
}
