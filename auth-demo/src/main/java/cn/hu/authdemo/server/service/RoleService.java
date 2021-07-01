package cn.hu.authdemo.server.service;

import cn.hu.authdemo.common.exception.BusinessException;
import cn.hu.authdemo.common.util.Assert;
import cn.hu.authdemo.server.dao.RoleDao;
import cn.hu.authdemo.server.model.UserRole;
import cn.hu.authdemo.server.request.RoleAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public void addRole(RoleAddRequest request){
        UserRole userRole = roleDao.selectByRoleCode(request.getRoleCode(), request.getTenantId());
        Assert.isFalse(null == userRole, BusinessException.userRoleExist());
        roleDao.addRole(request);
    }
}
