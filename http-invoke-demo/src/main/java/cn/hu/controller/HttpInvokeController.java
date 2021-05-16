package cn.hu.controller;

import cn.hu.http.RestTemplateUse;
import cn.hu.model.PropertyInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/httpInvoke")
public class HttpInvokeController {

    /**
     * RestTemplate 使用get请求远端地址
     *
     * @return
     */
    @GetMapping("/getTest1")
    public List<PropertyInfo> test1(){
        RestTemplate restTemplate = RestTemplateUse.getRestTemplate();
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);
        ParameterizedTypeReference<List<PropertyInfo>> typeReference = new ParameterizedTypeReference<List<PropertyInfo>>() {};
        ResponseEntity<List<PropertyInfo>> exchange = restTemplate.exchange("http://localhost:8080/service/config/getProperties", method, requestEntity, typeReference, PropertyInfo.class);
        List<PropertyInfo> body = exchange.getBody();
        return body;
    }
}
