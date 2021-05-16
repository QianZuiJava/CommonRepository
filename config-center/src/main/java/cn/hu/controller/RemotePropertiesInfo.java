package cn.hu.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "remote.test.config")
public class RemotePropertiesInfo {
    private String name;
    private String age;
    private String key1;
    private String key2;
}
