package cn.hu.authdemo.server.controller;

import cn.hu.authdemo.common.annotation.AuthPoint;
import cn.hu.authdemo.common.annotation.AuthResource;

@AuthResource(code = "AuthController", desc = "权限控制器")
public class AuthController {

    @AuthPoint(code = "test", desc = "测试方法")
    public String test(){
        return "SUCCESS";
    }
}
