package cn.hu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remoteConfig")
public class RemoteConfigController {

    @Autowired
    private RemotePropertiesInfo propertiesInfo;

    @GetMapping("/test")
    public String getRemoteConfig(){
        return propertiesInfo.getName() + " : " + propertiesInfo.getAge() + " : "
                + propertiesInfo.getKey1() + " : " + propertiesInfo.getKey2();
    }
}
