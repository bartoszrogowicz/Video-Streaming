package pl.polsl.rtc.security;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import pl.polsl.rtc.security.SecurityConstatns;
import javax.annotation.PostConstruct;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

    private long tokenInMilis;

    private String secretKey;// = SecurityConstants.SECRET_KEY;

    @PostConstruct
    public void init() {
        secretKey = SecurityConstatns.SECRET_KEY;
    }

    public String generateToken(Authentication authentication) {

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long nowMilis = System.currentTimeMillis();

        Date expirationMilis = new Date(nowMilis + SecurityConstatns.TIME_TOKEN_NO_REMEBER);


        return  Jwts.builder().
                setSubject(authentication.getName())
                .claim(SecurityConstatns.AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS512, this.secretKey)
                .setExpiration(expirationMilis)
                .compact();
    }

    public Authentication parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(SecurityConstatns.AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
//
//        GrantedAuthority grantedAuth = new SimpleGrantedAuthority("ROLE_ADMIN");
//        List<GrantedAuthority> list = Arrays.asList(grantedAuth);

        User principal = new User(claims.getSubject(), "", authorities);


        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {

        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT token invalid or handler are invalid.");
            log.trace("JWT token invalid or handler are invalid trace: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
        }
        return false;
    }

}
