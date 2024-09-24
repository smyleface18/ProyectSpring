package com.project.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //
@PropertySource(value = "classpath:values.properties", encoding = "UTF-8") // configurar el archivo de properties
public class Config {

}
