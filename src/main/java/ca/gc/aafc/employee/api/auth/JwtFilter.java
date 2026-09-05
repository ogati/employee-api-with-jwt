package ca.gc.aafc.employee.api.auth;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ca.gc.aafc.employee.api.user.CustomUserDetailsService;
import io.jsonwebtoken.JwtException;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;
    
    public JwtFilter(JwtService jwtService, CustomUserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
    	// Avoid 403 on /favicon.ico and errors in console
    	String uri = request.getRequestURI();
    	if (uri.startsWith("/favicon.ico") || uri.startsWith("/.well-known")) return;
    	
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        String token = header.substring(7);
        if (token.isBlank()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT");
            return;
        }
        
        try {
            String username = jwtService.extractUsername(token);
	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	            
	            if (jwtService.isTokenValid(token, userDetails)) {
	                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
	                		userDetails, null, userDetails.getAuthorities());
	                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(auth);
	            }
	        }
        } catch (JwtException e) {
            SecurityContextHolder.clearContext();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT");
            return;
        }
        
        filterChain.doFilter(request, response);
    }
}
