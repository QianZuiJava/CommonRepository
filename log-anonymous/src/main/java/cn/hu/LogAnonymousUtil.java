package cn.hu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogAnonymousUtil {

    private ObjectMapper objectMapper;

    private AnonymousJsonSerializer jsonSerializer;

    LogAnonymousUtil(AnonymousJsonSerializer jsonSerializer){
        this.objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(jsonSerializer);
        objectMapper.registerModule(module);
    }

    public String anonymous(Object target){
        try {
            return this.objectMapper.writeValueAsString(target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
