package cn.hu.authdemo.server.service;

import cn.hu.authdemo.common.exception.BusinessException;
import cn.hu.authdemo.common.util.Assert;
import cn.hu.authdemo.server.dao.RoleDao;
import cn.hu.authdemo.server.dao.UserDao;
import cn.hu.authdemo.server.dao.UserRoleRelationDao;
import cn.hu.authdemo.server.model.UserInfo;
import cn.hu.authdemo.server.model.UserRole;
import cn.hu.authdemo.server.request.BindUserAndRole;
import cn.hu.authdemo.server.request.UserAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleRelationDao userRoleRelationDao;

    public void addUser(UserAddRequest request) {
        UserInfo userInfo = userDao.selectByAccountAndTenant(request.getUserAccount(), request.getTenantId());
        Assert.isFalse(null == userInfo, BusinessException.userExists());
        userDao.addUser(request);
    }

    public void bindUserAndRole(BindUserAndRole request){
        // 校验角色是否存在
        UserRole userRole = roleDao.selectByRoleCode(request.getRoleCode(), request.getTenantId());
        Assert.isTrue(null == userRole, BusinessException.roleNotExists());
        // 校验用户是否存在
        UserInfo userInfo = userDao.selectByAccountAndTenant(request.getUserAccount(), request.getTenantId());
        Assert.isTrue(null == userInfo, BusinessException.userNotExists());
        // 校验管理关系是否存在
        int count = userRoleRelationDao.selectCountByUserAndRole(request.getUserAccount(), request.getRoleCode(), request.getTenantId());
        Assert.isTrue(count > 0, BusinessException.userAndRoleBinded());
        userRoleRelationDao.bindUserAndRole(request);
    }
}
