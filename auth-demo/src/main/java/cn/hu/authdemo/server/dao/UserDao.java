package cn.hu.authdemo.server.dao;

import cn.hu.authdemo.server.model.UserInfo;
import cn.hu.authdemo.server.request.UserAddRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    void addUser(UserAddRequest request);

    UserInfo selectByAccountAndTenant(@Param("userAccount")String userAccount, @Param("tenantId")Long tenantId);
}
