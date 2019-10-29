package net.restfulapi.springbootcrud.config;

import io.jsonwebtoken.*;
import net.restfulapi.springbootcrud.service.UserPrinciple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenUtil /*implements Serializable*/ {
/*

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${springboot.app.jwtSecret}")
    private String jwtSecret;
    @Value("${springboot.app.jwtExpiration}")
    private int jwtExpiration;


    public String generateJwtToken(Authentication authentication){

        //Service yang mau dipakai
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .claim("roles", userPrincipal.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return  true;
        }catch(SignatureException e){
            logger.error("Invalid JWT Signature -> Message : {}", e);
        }catch(MalformedJwtException e){
            logger.info("Invalid JWT Token -> Message : {}", e);
        }catch(ExpiredJwtException e){
            logger.info("Expired JWT Token -> Message : {}", e);
        }catch (UnsupportedJwtException e){
            logger.info("Unsupported JWT Token -> Message {}", e);
        }catch(IllegalArgumentException e){
            logger.error("JWT claims string is empty -> Message: {} ", e);
        }

        return false;
    }
*/

}
