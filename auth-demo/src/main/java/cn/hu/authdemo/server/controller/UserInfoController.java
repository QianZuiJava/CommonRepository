package cn.hu.authdemo.server.controller;

import cn.hu.authdemo.common.model.BaseResult;
import cn.hu.authdemo.server.request.BindUserAndRole;
import cn.hu.authdemo.server.request.UserAddRequest;
import cn.hu.authdemo.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserInfoController {
    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public BaseResult addUser(@RequestBody UserAddRequest request){
        userService.addUser(request);
        return BaseResult.ok();
    }

    @PostMapping("bindUserAndRole")
    public BaseResult bindUserAndRole(@RequestBody BindUserAndRole request){
        userService.bindUserAndRole(request);
        return BaseResult.ok();
    }
}
