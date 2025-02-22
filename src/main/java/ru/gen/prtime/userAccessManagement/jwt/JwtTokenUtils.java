package ru.gen.prtime.userAccessManagement.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.lifetime}")
    private Duration jwtLifetime;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        List<String> rolesList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()); //список ролей которые есть у юзера
        claims.put("roles", rolesList);
//        claims.put("email", user.getEmail()); //использовать User и достать все данные
        Date issuedDate = new Date(); //время начала жизни токена
        Date expiredDate = new Date(issuedDate.getTime() + jwtLifetime.toMillis()); //время конца жизни токена
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        Key key = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(issuedDate)
                .expiration(expiredDate)
                .signWith(key)
                .compact();
    }

    public String getUsername(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public List<String> getRoles(String token) {
        Claims claims = getAllClaimsFromToken(token);
        List<?> roles = claims.get("roles", List.class); // Получаем список как List<?>
        // Проверяем, что все элементы списка являются строками
        if (roles != null) {
            return roles.stream()
                    .filter(obj -> obj instanceof String) // Фильтруем только строки
                    .map(obj -> (String) obj) // Приводим к String
                    .collect(Collectors.toList()); // Собираем в List<String>
        } else {
            return List.of(); // Возвращаем пустой список, если roles == null
        }
    }

    private Claims getAllClaimsFromToken(String token) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        // 3. Парсим токен и проверяем подпись
        return Jwts.parser()
                .verifyWith(key) // Используем Key для проверки подписи
                .build()
                .parseSignedClaims(token) // Парсим токен
                .getPayload(); // Получаем Claims
    }
}
