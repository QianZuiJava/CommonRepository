package cn.hu.codetoname.controller;

import cn.hu.codetoname.dao.IGlobalDataDao;
import cn.hu.codetoname.po.DescInfo;
import cn.hu.codetoname.request.GlobalDataReqeset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/globalDataService")
public class CodeToNameController {

    @Autowired
    private IGlobalDataDao globalDataDao;

    @PostMapping("/getGlobalData")
    List<DescInfo> getGlobalData(@RequestBody GlobalDataReqeset reqeset){
        return globalDataDao.getDescInfo(reqeset.getGroupName(),
                reqeset.getAttrType(), reqeset.getAttrCode(), reqeset.getLanguage());
    }
}
