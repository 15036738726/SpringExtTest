package com.example.demo.spi.PropertySourceLoader;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class User {
    @Value("${test.username}")
    private String username;
}
