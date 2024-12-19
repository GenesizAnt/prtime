package ru.gen.prtime;

import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import lombok.Value;
import org.modelmapper.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gen.prtime.config.TokenCookieAuthenticationConfigurer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class PrtimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrtimeApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public TokenCookieJweStringSerializer tokenCookieJweStringSerializer(
//            @Value("${jwt.cookie-token-key}") String cookieTokenKey
//    ) throws Exception {
//        return new TokenCookieJweStringSerializer(new DirectEncrypter(
//                OctetSequenceKey.parse(cookieTokenKey)
//        ));
//    }
//
//    @Bean
//    public TokenCookieAuthenticationConfigurer tokenCookieAuthenticationConfigurer(
//            @Value("${jwt.cookie-token-key}") String cookieTokenKey,
//            JdbcTemplate jdbcTemplate
//    ) throws Exception {
//        return new TokenCookieAuthenticationConfigurer()
//                .tokenCookieStringDeserializer(new TokenCookieJweStringDeserializer(
//                        new DirectDecrypter(
//                                OctetSequenceKey.parse(cookieTokenKey)
//                        )
//                ))
//                .jdbcTemplate(jdbcTemplate);
//    }
}
