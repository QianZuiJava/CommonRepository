package cn.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ConfigCenterClientApp {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(ConfigCenterClientApp.class, args);
    }
}
