package ch.fhnw.webfr.flashcard.filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// No entry necessary in web.xml if annotation is used:
// @WebFilter(urlPatterns={"/*"})
public class BasicFilter implements javax.servlet.Filter {
    private static final Logger logger = LogManager.getLogger("Request Logger");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        logger.info("Before request [uri=" + req.getRequestURI() + "]");
//        System.out.println("Before request [uri=" + req.getRequestURI() + "]");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
