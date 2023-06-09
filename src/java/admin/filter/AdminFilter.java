/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package admin.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author hathithao
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/*"})
public class AdminFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public AdminFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//        if (session.getAttribute("accountS") == null) {
//            req.getRequestDispatcher("login.jsp").forward(request, response);
//        } else {
//            chain.doFilter(request, response);
//        }
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        HttpSession session = req.getSession();
//        Account user = (Account) session.getAttribute("accountS");
//        if (user == null) {
//            res.sendRedirect("login.jsp");
//            return;
//        }
//        if (user.getUsername().trim().equals("nhathuy")) {
//            chain.doFilter(request, response);
//        } else {
//            res.sendRedirect("login.jsp");
//        }
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if(session.getAttribute("accountS") == null){
            res.sendRedirect("LoginServlet");
        }
        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
