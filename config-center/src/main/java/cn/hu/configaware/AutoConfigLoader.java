package cn.hu.configaware;

import cn.hu.model.RemotePropertyInfo;
import cn.hu.util.HttpUtil;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Properties;

/**
 * 自动配置加载器
 */
public class AutoConfigLoader implements IAutoConfigLoader, EnvironmentAware {

    /**
     * 当前环境信息，主要用于判断是否执行当前的加载操作的信息获取
     */
    private Environment environment;

    @Override
    public PropertySource getPropertySource() {
        return new PropertiesPropertySource("remoteConfig", this.loadRemoteProperties());
    }

    /**
     * 从远端数据源获取配置的方法
     * 不同的配置器可以自己去实现
     *
     * @return Properties 远端配置
     */
    private Properties loadRemoteProperties() {
        Properties properties = new Properties();
        // 本地测试配置信息
        properties.put("remote.test.config.name", "张三");
        properties.put("remote.test.config.age", "12");
        // 从远端服务器获取配置信息
        List<RemotePropertyInfo> remoteConfigs = getRemoteConfig("http://localhost:8080/service/config/getProperties");
        for (RemotePropertyInfo remotePropertyInfo : remoteConfigs) {
            properties.put(remotePropertyInfo.getKey(), remotePropertyInfo.getValue());
        }
        return properties;
    }

    public static List<RemotePropertyInfo> getRemoteConfig(String url){
        HttpMethod httpMethod = HttpMethod.valueOf("GET");
        RestTemplate restTemplate = HttpUtil.getRestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity requestEntity = new HttpEntity(null, httpHeaders);
        ParameterizedTypeReference<List<RemotePropertyInfo>> typeReference = new ParameterizedTypeReference<List<RemotePropertyInfo>>() {};
        ResponseEntity<List<RemotePropertyInfo>> responseEntity = restTemplate.exchange(url, httpMethod, requestEntity, typeReference, RemotePropertyInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 设置当前环境信息，在需要时可以使用
     *
     * @param environment 当前环境信息
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
