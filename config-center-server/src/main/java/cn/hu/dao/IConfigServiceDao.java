package cn.hu.dao;

import cn.hu.model.RemotePropertyInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConfigServiceDao {
    List<RemotePropertyInfo> getConfigs();
}
