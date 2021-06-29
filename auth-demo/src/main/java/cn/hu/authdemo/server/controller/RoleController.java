package cn.hu.authdemo.server.controller;

import cn.hu.authdemo.common.model.BaseResult;
import cn.hu.authdemo.server.request.RoleAddRequest;
import cn.hu.authdemo.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("addRole")
    public BaseResult addRole(@RequestBody RoleAddRequest request){
        roleService.addRole(request);
        return BaseResult.ok();
    }
}
