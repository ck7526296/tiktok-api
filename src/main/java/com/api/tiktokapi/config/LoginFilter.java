package com.api.tiktokapi.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info(request.getRequestURI());

        String id = (String) request.getSession().getAttribute("id");
//        if (!request.getRequestURI().endsWith("login") && id==null){
//            servletResponse.setContentType("text/javascript;charset=utf-8");
//            final PrintWriter writer = servletResponse.getWriter();
//            writer.print("{\n" +
//                    "\"code\": 0,\n" +
//                    "\"msg\": \"未登录\",\n" +
//                    "\"data\": [],\n" +
//                    "\"map\": {}\n" +
//                    "}");
//            return;
//        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
