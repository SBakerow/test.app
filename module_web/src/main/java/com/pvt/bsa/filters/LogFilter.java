package com.pvt.bsa.filters;

import org.apache.log4j.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 25.01.14
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public class LogFilter implements Filter {
  //Logger logger = Logger.getLogger(getClass());
  //  private static final Logger log = LogManager.getLogger(Calculate.class.getName());
    Logger logger2 = LogManager.getLogger(getClass().getName());
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String ipAddress  = ((HttpServletRequest) req).getHeader("X-FORWARDED-FOR");
        if(ipAddress == null)
        {
           ipAddress = req.getRemoteAddr();
            //System.out.println("ipAddress= "+ ipAddress);
            logger2.log(Level.toLevel("DEBUG"),"ipAddress== " + ipAddress );
           // logger.log(Level.toLevel("ERROR"),"ipAddress== " + ipAddress );
        }
       // System.out.println("request URL= " + ((HttpServletRequest) req).getRequestURL());
      //  logger.log(Level.toLevel("ERROR"),"request URL= " + ((HttpServletRequest) req).getRequestURL() );
        //logger.error("request URL= " + ((HttpServletRequest) req).getRequestURL());
        logger2.debug("request URL= " + ((HttpServletRequest) req).getRequestURL());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
