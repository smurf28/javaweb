package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lhl28 on 2018/1/22.
 */
public class dowloadServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("nae","zhangsan");
        resp.getWriter().write("this is download doGet");
//        //要下载的文件类型(mime)
//
//
//        //文件名
//        String filename = req.getParameter("filename");
//        //获得文件绝对路径
//        String path = this.getServletContext().getRealPath("download/"+filename);
//        //获得文件的输入流
//        InputStream in = new FileInputStream(path);
//        //输出流 response
//        ServletOutputStream out = resp.getOutputStream();
//
//        int len = 0;
//        byte[] buffer = new byte[1024];
//        while((len=in.read(buffer))>0){
//            out.write(buffer,0,len);
//        }
//        in.close();
//        //out.close();
//        resp.getWriter().write("my name is doget");

    }
}
