package cn.hu.controller;

import cn.hu.dao.IConfigServiceDao;
import cn.hu.model.RemotePropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private IConfigServiceDao configServiceDao;

    /**
     * 获取所有配置信息
     * 扩展：可以根据区域、环境、部署单元、版本等信息进行扩展
     *
     * @return List<RemotePropertyInfo> 配置信息列表
     */
    @GetMapping("/getProperties")
    List<RemotePropertyInfo> getProperties(){
        List<RemotePropertyInfo> configs = configServiceDao.getConfigs();
        return configs;
    }
}
