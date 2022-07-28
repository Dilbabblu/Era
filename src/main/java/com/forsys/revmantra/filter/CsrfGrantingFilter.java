package com.forsys.revmantra.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.security.RmanPrincipal;
import com.forsys.revmantra.utils.RevmantraUtils;

public class CsrfGrantingFilter implements Filter {
	  
	  private static final String CSRF_TOKEN_HEADER = "X-CSRF-TOKEN";
	  private static final String COOKIE_CSRF_TOKEN = "CSRF-TOKEN";
	  private static final RequestMatcher requireCsrfProtectionMatcher = new DefaultRequiresCsrfMatcher();
	  private static final AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandlerImpl();
	  
	  @Override
	  public void init(FilterConfig filterConfig) throws ServletException {}

	  @Override
	  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	      throws IOException, ServletException {
		  HttpServletRequest request= (HttpServletRequest)servletRequest;
		 if(!request.getRequestURI().contains("/api/sfqi")) {
			 
			String sessionid = ((HttpServletRequest)servletRequest).getSession().getId();  
		    CsrfToken csrf = (CsrfToken) servletRequest.getAttribute(CsrfToken.class.getName());
		    String token = csrf.getToken();
		    
		   HttpServletResponse response = (HttpServletResponse) servletResponse;
		    response.setHeader(HttpHeaders.SET_COOKIE, "JSESSIONID=" + sessionid + "; Path=/; HttpOnly; Secure; SameSite=Strict; lang=en-US; Domain=" + getDomain());
		    Cookie[] availableCookies = request.getCookies();
		    String csrfCookieValue = null;
	    	if (availableCookies != null) {
	        	for (Cookie cookie : availableCookies) {
	                if (cookie.getName().equals(COOKIE_CSRF_TOKEN)) {
	                    csrfCookieValue = cookie.getValue();
	                }
	            }
	        }
	    	
		    if (token != null && (csrfCookieValue == null || !token.equals(csrfCookieValue)) && isAuthenticating(servletRequest)) { 
		    	Cookie cookie = new Cookie(COOKIE_CSRF_TOKEN, token);
		    	cookie.setPath("/");
		    	cookie.setSecure(true);
		    	HttpService.addCookie(response, cookie, "Strict");
		    }
		    
		    if (requireCsrfProtectionMatcher.matches(request) && !request.getRequestURI().contains("/api/sfqi")) {
		    	final String csrfTokenValue = request.getHeader(CSRF_TOKEN_HEADER);
		    	final Cookie[] cookies = request.getCookies();
		    	String csrfCookieValue2 = null;
		    	if (cookies != null) {
	            	for (Cookie cookie : cookies) {
	            		if (cookie.getName().equals(COOKIE_CSRF_TOKEN)) {
	                        csrfCookieValue2 = cookie.getValue();
	                    }
	                }
	            }
		    	if ((csrfTokenValue == null || !csrfTokenValue.equals(csrfCookieValue2)) && !request.getRequestURI().contains("/api/sfqi")) {
		    		accessDeniedHandler.handle(request, response, new AccessDeniedException(
	                        "Missing or non-matching CSRF-token"));
	                return;
	            } 
		    }
		}
	    filterChain.doFilter(servletRequest, servletResponse);
	  }

	  private boolean isAuthenticating(ServletRequest servletRequest) {
			if (SecurityContextHolder.getContext() != null
					&& SecurityContextHolder.getContext().getAuthentication() != null) {

				Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
				RmanUsers rmanUser = null;
				if (userDetails instanceof WebAuthenticationDetails) {

					Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

					if (principal instanceof RmanPrincipal) {

						rmanUser = ((RmanPrincipal) principal).getUser();

					}
				} else if (userDetails instanceof RmanUsers) {

					rmanUser = (RmanUsers) userDetails;
				}
				
				if(rmanUser !=null) {
					
					return true;
				}
				
		}  
			return false;
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


	  @Override
	  public void destroy() {}
	  
	  public static final class DefaultRequiresCsrfMatcher implements RequestMatcher {
	        private final Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	        @Override
	        public boolean matches(HttpServletRequest request) {
	            return !allowedMethods.matcher(request.getMethod()).matches();
	        }
	    }
}