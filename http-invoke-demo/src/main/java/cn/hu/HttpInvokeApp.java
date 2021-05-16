package cn.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class HttpInvokeApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(HttpInvokeApp.class, args);
        System.out.println( "Hello World!" );
    }
}
