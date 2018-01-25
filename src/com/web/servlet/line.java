package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lhl28 on 2018/1/23.
 */
public class line extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.getWriter().write("sadfghn");
            resp.addHeader("name","si");
        resp.setStatus(302);
        resp.setHeader("Location","/javaweb/testServlet");
        //¶¨Ê±Ë¢ÐÂ
        resp.setHeader("refresh","5;url");

    }
}
