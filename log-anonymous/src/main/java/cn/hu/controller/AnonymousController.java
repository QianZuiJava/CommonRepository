package cn.hu.controller;

import cn.hu.LogAnonymousUtil;
import cn.hu.testmodel.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anonymous")
public class AnonymousController {
    @Autowired
    private LogAnonymousUtil logAnonymousUtil;

    @PostMapping("/anonymousPerson")
    public String anonymousPerson(@RequestBody Person person){
        return logAnonymousUtil.anonymous(person);
    }
}
