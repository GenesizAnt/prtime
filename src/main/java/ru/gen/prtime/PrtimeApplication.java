package ru.gen.prtime;

import org.modelmapper.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        ModelMapper modelmapper = new ModelMapper();
        Provider<LocalDate> localDateProvider = new AbstractProvider<>() {
            @Override
            public LocalDate get() {
                return LocalDate.now();
            }
        };
        Converter<String, LocalDate> toStringDate = new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(source, format);
            }
        };
        Provider<LocalTime> localTimeProvider = new AbstractProvider<>() {
            @Override
            public LocalTime get() {
                return LocalTime.now();
            }
        };
        Converter<String, LocalTime> toStringTime = new AbstractConverter<>() {
            @Override
            protected LocalTime convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
                return LocalTime.parse(source, format);
            }
        };
        modelmapper.createTypeMap(String.class, LocalDate.class);
        modelmapper.createTypeMap(String.class, LocalTime.class);
        modelmapper.addConverter(toStringDate);
        modelmapper.addConverter(toStringTime);
        modelmapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);
        modelmapper.getTypeMap(String.class, LocalTime.class).setProvider(localTimeProvider);
        return modelmapper;
    }
}
