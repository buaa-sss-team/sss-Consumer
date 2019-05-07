package com.yuyuyzl.SSS.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserServiceWeb extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        staticTest.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {


        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("执行结果："+staticTest.testService.login("hello","hello"));
        out.println("<br>");
        out.println("Session："+request.getSession().getId());
        out.println("Session Created in："+request.getSession().getCreationTime());
        out.println("Session Last Accessed："+request.getSession().getLastAccessedTime());
        out.println("</body>");
        out.println("</html>");
    }
}
