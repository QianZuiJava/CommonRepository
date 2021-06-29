package cn.hu.authdemo.server.dao;

import cn.hu.authdemo.server.request.RoleAddRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    void addRole(RoleAddRequest request);
}
