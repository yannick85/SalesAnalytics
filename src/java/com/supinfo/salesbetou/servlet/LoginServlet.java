/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.servlet;

import com.supinfo.salesbetou.entity.User;
import com.supinfo.salesbetou.service.UserDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yannick
 */
public class LoginServlet extends HttpServlet {
    
    @EJB
    private UserDao userDao;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if( (String) request.getParameter("user-name") != null && (String) request.getParameter("user-pass") != null){
                User user = userDao.userExist((String) request.getParameter("user-name"), (String) request.getParameter("user-pass"));
                if(user != null){
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect((request.getContextPath()+"/auth/"));
                }else{
                        //Wrong password/name
                        request.setAttribute("action", "wrong");
                        request.getRequestDispatcher("/WEB-INF/log.jsp").forward(request, response);
                }
        }else{
            request.getRequestDispatcher("/WEB-INF/log.jsp").forward(request, response);
        }
    }
}
