package cn.hu.authdemo.server.dao;

import cn.hu.authdemo.server.request.BindUserAndRole;
import cn.hu.authdemo.server.request.UserAddRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRelationDao {
    void bindUserAndRole(BindUserAndRole request);

    int selectCountByUserAndRole(@Param("userAccount")String userAccount, @Param("roleCode")String roleCode, @Param("tenantId")long tenantId);
}
