package cn.hu.authdemo.server.dao;

import cn.hu.authdemo.server.model.UserRole;
import cn.hu.authdemo.server.request.RoleAddRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    void addRole(RoleAddRequest request);

    UserRole selectByRoleCode(@Param("roleCode") String roleCode, @Param("tenantId")long tenantId);
}
