package cn.hu.codetoname.dao;

import cn.hu.codetoname.po.DescInfo;
import org.springframework.stereotype.Repository;

import javax.ws.rs.QueryParam;
import java.util.List;

@Repository
public interface IGlobalDataDao {
    List<DescInfo> getDescInfo(@QueryParam("groupName") String groupName,
                               @QueryParam("attrType")String attrType,
                               @QueryParam("attrCode")String attrCode,
                               @QueryParam("language")String language);
}
