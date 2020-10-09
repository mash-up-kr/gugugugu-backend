package mashup.gugugugu.user.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import mashup.gugugugu.user.dto.SignInRequestDto;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.*;

public class JwtServiceTest {
    private JwtService jwtService;

    private String jws;

    @BeforeEach
    public void init() {
        jwtService = new JwtService();
        jwtService.setSecretKey("GuguguguguSecretKeyGuguguguguguhahahaha");

        SignInRequestDto requestBody = new SignInRequestDto("abcd1234", "gugu@gmail.com");
        jws = jwtService.create(requestBody);
    }

    @Test
    public void test_createAndGet() {
        Jws<Claims> jwsClaims = jwtService.getJwsClaims(jws);

        assertEquals("abcd1234", jwsClaims.getBody().get("tokenId"));
    }

    @Test
    public void test_isUsable() {
        assertTrue(jwtService.isUsable(jws));
    }

}
