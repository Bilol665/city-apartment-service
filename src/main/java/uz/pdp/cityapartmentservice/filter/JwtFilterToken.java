package uz.pdp.cityapartmentservice.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.cityapartmentservice.domain.entity.token.JwtTokenEntity;
import uz.pdp.cityapartmentservice.exceptions.NotAcceptable;
import uz.pdp.cityapartmentservice.repository.token.JwtTokenRepository;
import uz.pdp.cityapartmentservice.service.user.AuthenticationService;
import uz.pdp.cityapartmentservice.service.user.JwtService;

import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
public class JwtFilterToken extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private JwtTokenRepository jwtTokenRepository;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String token = request.getHeader("authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
            return;
        }

        token = token.substring(7);
        Jws<Claims> claimsJws = jwtService.extractToken(token);
        Date expiration = claimsJws.getBody().getExpiration();
        if(new Date().after(expiration)) throw new NotAcceptable("Expired Access token!");
        authenticationService.Authenticate(claimsJws.getBody(),request);
        jwtTokenRepository.save(JwtTokenEntity.builder().token(token).username(claimsJws.getBody().getSubject()).build());

        filterChain.doFilter(request,response);
    }
}
