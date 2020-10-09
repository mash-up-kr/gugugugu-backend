package mashup.gugugugu.user.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import mashup.gugugugu.user.dto.SignInRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.Key;

@Slf4j
@Service
public class JwtService {
    private String secretKey;

    @Value("${jwt.secret-key}")
    public void setSecretKey(String secretKey){
        this.secretKey = secretKey;
    }

    public String create(SignInRequestDto requestBody){
        Key key = Keys.hmacShaKeyFor(generateKey());

        String jws = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject("user")
                .claim("tokenId", requestBody.getTokenId())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return jws;
    }

    private byte[] generateKey(){
        byte key[] = null;
        try{
            key = secretKey.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.debug("Fail to generate key: {}", e);
        }
        return key;
    }

    public boolean isUsable(String jws){
        log.info("jws: {}", jws);
        getJwsClaims(jws);
        return true;
    }

    public Jws<Claims> getJwsClaims(String jws){
        Jws<Claims> claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(generateKey())
                    .parseClaimsJws(jws);
        }catch (Exception e){
            throw e;
        }
        return claims;
    }

    public String getValue(String key){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String jws = request.getHeader("Authorization");
        Jws<Claims> jwsClaims = getJwsClaims(jws);

        return jwsClaims.getBody().get(key).toString();
    }

    public String getTokenId() {
        return getValue("tokenId");
    }

}
