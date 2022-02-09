package com.example.springrestcrmapp.config;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@EnableTransactionManagement
public class DemoAppConfig implements WebMvcConfigurer {
}
