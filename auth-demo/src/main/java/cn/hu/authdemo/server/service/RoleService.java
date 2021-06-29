package cn.hu.authdemo.server.service;

import cn.hu.authdemo.server.dao.RoleDao;
import cn.hu.authdemo.server.request.RoleAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public void addRole(RoleAddRequest request){
        roleDao.addRole(request);
    }
}
