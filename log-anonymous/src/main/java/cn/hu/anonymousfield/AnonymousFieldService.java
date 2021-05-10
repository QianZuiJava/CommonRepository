package cn.hu.anonymousfield;

import cn.hu.model.AnonymousFieldInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AnonymousFieldService implements IAnonymousFieldService {
    private Map<String, AnonymousFieldInfo> map;

    AnonymousFieldService(){
        this.map = initAnonymousFieldInfo();
    }

    /**
     * 获取匿名属性和对应信息
     *  可以从数据等远端获取
     *
     * @return
     */
    public Map<String, AnonymousFieldInfo> initAnonymousFieldInfo() {
        Map<String, AnonymousFieldInfo> map = new HashMap<>();
        AnonymousFieldInfo anonymousField1 = new AnonymousFieldInfo();
        anonymousField1.setAnonymousField("userName");
        anonymousField1.setAnonymousPlanCode(1);
        anonymousField1.setGroupName("test");
        AnonymousFieldInfo anonymousField2 = new AnonymousFieldInfo();
        anonymousField2.setAnonymousField("userPassword");
        anonymousField2.setAnonymousPlanCode(2);
        anonymousField2.setGroupName("test");
        map.put("userName", anonymousField1);
        map.put("userPassword", anonymousField2);
        return map;
    }

    @Override
    public AnonymousFieldInfo getAnonymousFieldInfo(String name){
        return map.get(name);
    }
}
