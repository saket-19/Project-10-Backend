package com.rays.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.UserDTO;
import com.rays.service.JWTUserDetailsService;

/**
 * JWT authentication filter that executes once per request.
 * Extracts JWT token from Authorization header, validates it,
 * and sets Spring Security authentication context.
 *
 * @author Saket
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	/**
	 * Utility class for JWT operations (generate, validate, extract claims).
	 */
	@Autowired
	private JWTUtil jwtUtil;

	/**
	 * Service used to load user details from database.
	 */
	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;

	/**
	 * Filters each incoming HTTP request to validate JWT token
	 * and set authentication in Spring Security context.
	 *
	 * @param request HTTP request
	 * @param response HTTP response
	 * @param filterChain filter chain
	 * @throws ServletException if servlet processing fails
	 * @throws IOException if I/O error occurs
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		System.out.println("JWT Token ======>>>>> " + authorizationHeader);

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			System.out.println("JWT Token ======>>>>> iiiiinnnnnn");

			String jwtToken = authorizationHeader.substring(7);

			try {

				String loginId = jwtUtil.extractLoginId(jwtToken);

				if (!jwtUtil.validateToken(jwtToken, loginId)) {
					throw new Exception("Invalid JWT token");
				}

				if (loginId != null
						&& SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails =
							jwtUserDetailsService.loadUserByUsername(loginId);

					UsernamePasswordAuthenticationToken authenticationToken =
							new UsernamePasswordAuthenticationToken(
									userDetails,
									null,
									userDetails.getAuthorities());

					authenticationToken.setDetails(
							new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext()
							.setAuthentication(authenticationToken);
				}

				UserDTO dto = new UserDTO();
				dto.setLoginId(loginId);

				System.out.println("request filter: " + dto.getLoginId());

				UserContext context = new UserContext(dto);

				// ThreadLocal me set
				UserContextHolder.setContext(context);

			} catch (Exception e) {

				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Token is invalid... plz login again..!!");
				return;
			}
		}

		filterChain.doFilter(request, response);
	}
}