package cn.hu.codetoname;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.hu.codetoname")
public class CodeToNameApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeToNameApplication.class, args);
    }
}
