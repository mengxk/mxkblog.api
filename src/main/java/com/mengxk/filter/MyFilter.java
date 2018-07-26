package com.mengxk.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by mengxk on 2018/7/25.
 */
@Order(1)
@Component
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("request被处理之前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("request处理之后，response到达浏览器之前");
    }

    @Override
    public void destroy() {

    }
}
