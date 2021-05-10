package cn.hu;

import cn.hu.anonymousplan.AnonymousUserName;
import cn.hu.anonymousplan.AnonymousUserPasswordPlan;
import cn.hu.anonymousplan.IAnonymousPlan;
import cn.hu.enums.AnonymousPlanCode;
import cn.hu.model.AnonymousFieldInfo;
import cn.hu.testmodel.Person;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 匿名化策略demo
 * 通过该类思考实现逻辑
 * 1 匿名化属性可配置：需要通过数据库等配置 匿名属性和对应的匿名方案编码
 * 2 匿名方案抽象管理：方案管理器
 */
public class AnonymousDemo {
    public static void main(String[] args) throws JsonProcessingException {
        Person person1 = new Person("张", "123456");
        Person person2 = new Person("张三", "123456");
        Person person3 = new Person("张三丰", "123456");
        anonymous(person1);
        anonymous(person2);
        anonymous(person3);

    }

    public static void anonymous(Object target) throws JsonProcessingException {
        String string = objectMapper().writeValueAsString(target);
        System.out.println(string);
    }


    public static ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(new JsonSerializer<String>() {
            @Override
            public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                // 获取当前属性名称
                String fieldName = jsonGenerator.getOutputContext().getCurrentName();
                // 通过属性名称获取到对应的匿名信息（从数据库等配置源）
                Map<String, AnonymousFieldInfo> anonymousManagerMap = getAnonymousManagerMap();
                AnonymousFieldInfo anonymousFieldInfo = anonymousManagerMap.get(fieldName);
                // 从信息中获取到匿名方案编码
                Integer anonymousPlanCode = anonymousFieldInfo.getAnonymousPlanCode();
                // 通过编码获取到对应的方案
                Map<Integer, IAnonymousPlan> anonymousPlanMap = getAnonymousPlanMap();
                IAnonymousPlan iAnonymousPlan = anonymousPlanMap.get(anonymousPlanCode);
                if (iAnonymousPlan == null) {
                    jsonGenerator.writeString(s);
                    return;
                }
                String result = iAnonymousPlan.anonymousField(s);
                jsonGenerator.writeString(result);
            }

            // 这个不能遗漏，否则会报错
            @Override
            public Class<String> handledType() {
                return String.class;
            }
        });
        objectMapper.registerModule(module);
        return objectMapper;
    }

    public static Map<String, AnonymousFieldInfo> getAnonymousManagerMap(){
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

    public static Map<Integer, IAnonymousPlan> getAnonymousPlanMap(){
        Map<Integer, IAnonymousPlan> map = new HashMap<>();
        map.put(AnonymousPlanCode.ANONYMOUS_USER_NAME.getAnonymousPlanCode(), new AnonymousUserName());
        map.put(AnonymousPlanCode.ANONYMOUS_USER_PASSWORD.getAnonymousPlanCode(), new AnonymousUserPasswordPlan());
        return map;
    }
}
