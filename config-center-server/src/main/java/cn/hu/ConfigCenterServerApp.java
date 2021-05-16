package cn.hu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("cn.hu")
public class ConfigCenterServerApp {
    public static void main( String[] args ){
        SpringApplication.run(ConfigCenterServerApp.class, args);
        System.out.println( "Hello World!" );
    }
}
