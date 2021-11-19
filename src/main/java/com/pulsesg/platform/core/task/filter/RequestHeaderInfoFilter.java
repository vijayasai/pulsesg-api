package com.pulsesg.platform.core.task.filter;

import com.pulsesg.platform.core.task.util.LogUtil;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestHeaderInfoFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        try {
            String http_method = ((HttpServletRequest) request).getMethod();
            String authorization = ((HttpServletRequest) request).getHeader("Authorizantion");
            String userId = ((HttpServletRequest) request).getHeader("UserId");
            String jsessionId = null;
            LogUtil.clearContext();

        } catch (Exception e) {

        }
    }
}
