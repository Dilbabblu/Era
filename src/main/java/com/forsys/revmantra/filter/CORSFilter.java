package com.forsys.revmantra.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.RevmantraUtils;

@Component
@Order(1)
public class CORSFilter implements Filter
{
	private static final Logger logger = LogManager.getLogger(CORSFilter.class);
	
	private String serverHost;
	
	public CORSFilter(){
		try {
			serverHost = RevmantraUtils.getProperty("server.host");
			logger.info("Server Host : {}", serverHost);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        String requestHost = ((HttpServletRequest) req).getHeader("host");
        response.setHeader("X-Forwarded-Host", getDomain());
		if (requestHost != null && !requestHost.equals(getDomain())) {
          response.setStatus(403);
          return;
		}
		if (((HttpServletRequest)req).getRequestURI().contains("/api/")) {
		      	response.setHeader(CONSTANTS.ACCESS_CONTROL_ALLOW_METHODS, "POST, PUT, GET, DELETE");
		      	response.setHeader(CONSTANTS.ALLOW, "POST, PUT, GET, DELETE");
		} else if (((HttpServletRequest)req).getRequestURI().contains("/upload/")) {
		      	response.setHeader(CONSTANTS.ACCESS_CONTROL_ALLOW_METHODS, "POST");
		      	response.setHeader(CONSTANTS.ALLOW, "POST");
		 } else {
		      	response.setHeader(CONSTANTS.ACCESS_CONTROL_ALLOW_METHODS, "GET");
		      	response.setHeader(CONSTANTS.ALLOW, "GET");
		 
		 }
		      
		  response.setHeader("Permissions-Policy","web-share 'none'; document-domain 'self'");//Feature-Policy
		  response.setHeader("Content-Security-Policy","default-src 'self' https:; script-src 'self' https: 'unsafe-inline' 'unsafe-eval'; style-src 'self' https: 'unsafe-inline'; img-src 'self';font-src 'self' https://fonts.gstatic.com; child-src 'none';frame-ancestors 'none', form-action 'self' https://*.okta.com");
	      response.setHeader("Access-Control-Max-Age", "3600");
	      response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	      response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate"); 
	      response.setHeader("Pragma", "no-cache");
//	      response.setHeader(HttpHeaders.SET_COOKIE, "JSESSIONID=" + sessionid + "; HttpOnly; Secure; SameSite=Strict; lang=en-US; Domain=" + getDomain() ); 
	      chain.doFilter(req, res);

    }
	
	@Override
    public void init(FilterConfig filterConfig) {
    	logger.info("Initialized the filter");
    }

	@Override
    public void destroy() {
    	logger.info("on the destroy the filter");
    }
    
    private String getDomain() throws IOException {
		
		String domain = RevmantraUtils.getProperty("server.host");
		String port = RevmantraUtils.getProperty("server.port");
		
		domain = domain.substring(0, domain.length());
        if (domain.contains("https")) {
        	domain = domain.replace("https://", "").concat(port.equalsIgnoreCase("443") ? "" : port);
        } else if (domain.contains("http")) {
        	domain = domain.replace("http://", "").concat(port.equalsIgnoreCase("443") ? "" : port);
        }
        return domain;
	}
	

}
