package cn.hu.codetoname.controller;

import cn.hu.codetoname.ConvertExecuter;
import cn.hu.codetoname.dao.IGlobalDataDao;
import cn.hu.codetoname.po.DescInfo;
import cn.hu.codetoname.request.GlobalDataReqeset;
import cn.hu.codetoname.testmodel.Student;
import cn.hu.codetoname.testmodel.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private ConvertExecuter convertExecuter;

    @PostMapping("/getGlobalData")
    List<DescInfo> getGlobalData(@RequestBody GlobalDataReqeset reqeset){
        return globalDataDao.getDescInfo(reqeset.getGroupName(),
                reqeset.getAttrType(), reqeset.getAttrCode(), reqeset.getLanguage());
    }

    @GetMapping("/getStudent")
    Student getStudent(){
        Student student = new Student("", "MAN", new Teacher("", "JAVA"));
        convertExecuter.language("zh-cn").append(student).execute();
        return student;
    }
}
