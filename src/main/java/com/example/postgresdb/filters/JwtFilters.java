package com.example.postgresdb.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import java.security.InvalidParameterException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilters  extends OncePerRequestFilter {


  @Autowired
  JwtInfo jwtInfo;

  /**
   * Same contract as for {@code doFilter}, but guaranteed to be just invoked once per request within a single request thread. See
   * {@link #shouldNotFilterAsyncDispatch()} for details.
   * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
   * default ServletRequest and ServletResponse ones.
   * Bearer <jwt>
   * @param request
   * @param response
   * @param filterChain
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String headers = request.getHeader("Authorization");
try{
  if(headers == null || (headers!=null && !headers.startsWith("Bearer"))){
    throw new InvalidParameterException("Invalid User!");
  }
  String jwt = headers.replace("Bearer ", "");
  final DecodedJWT decodedJWT = JWT.decode(jwt);
  jwtInfo.setUser(decodedJWT.getClaim("user").asString());
  jwtInfo.setName(decodedJWT.getClaim("name").asString());
}catch (Exception e){

}
    System.out.print("====="+jwtInfo);
    filterChain.doFilter(request,response);
  }

}
