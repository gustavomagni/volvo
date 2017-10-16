package com.meta.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.meta")
/**
 * Classe responsavel pelo Scan de configuracao do projeto.
 * 
 * @author Gustavo Magni
 * @since 16/10/2017
 */
public class Config {

}
