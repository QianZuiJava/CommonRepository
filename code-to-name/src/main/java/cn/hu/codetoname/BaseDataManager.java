package cn.hu.codetoname;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class BaseDataManager {
    private ConcurrentMap<String, String> baseDataMap = new ConcurrentHashMap<>();

    public void putIncrementData(String cacheKey, String value){
        this.baseDataMap.put(cacheKey, value);
    }

    public String getIncrementData(String cacheKey){
        return this.baseDataMap.get(cacheKey);
    }
}
