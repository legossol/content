package kr.legossol.contents.auth.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import kr.legossol.contents.auth.domain.Account;
import kr.legossol.contents.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private SecretKey key = Keys.hmacShaKeyFor("myservice-secretKey-members-auth".getBytes());
    private ObjectMapper obj = new ObjectMapper();

    public String creatJwt(Long userIdx) {
        Date now = Date.from(Instant.now());

//        return Jwts.builder()
//            .claim("userIdx", userIdx)
//            .issuedAt(now)
//            .expiration(Date.from(Instant.now().plus(Duration.ofDays(1L))))
//            .signWith(key)
//            .compact();
        return Jwts.builder()
                .claim("userInfo", Account.builder().id(1L).password("haesol").userId("ssol").build())
                .issuedAt(now)
                .expiration(Date.from(Instant.now().plus(Duration.ofDays(1L))))
                .signWith(key)
                .compact();
    }

    public Long verifyToken(String jwtToken) {

        Jws<Claims> claimsJws = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwtToken)
                ;
        Claims payload = claimsJws.getPayload();
        LinkedHashMap<String, Object> userInfoMap = (LinkedHashMap<String, Object>) payload.get(
                "userInfo");
        Account userInfo = new ObjectMapper().convertValue(userInfoMap, Account.class);
//        Account userInfo = payload.get("userInfo", Account.class);
//        log.info("verified userIdx: {}", userIdx);
        log.info("verified userIdx: {}", userInfo.getId());
        log.info("verified userAccountID: {}", userInfo.getUserId());
        return userInfo.getId();
    }
}
