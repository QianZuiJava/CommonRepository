package cn.hu;

import cn.hu.anonymousfield.IAnonymousFieldService;
import cn.hu.anonymousplan.AnonymousPlanManager;
import cn.hu.anonymousplan.IAnonymousPlan;
import cn.hu.model.AnonymousFieldInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AnonymousJsonSerializer extends JsonSerializer<String> {
    @Autowired
    private IAnonymousFieldService anonymousFieldService;

    @Autowired
    private AnonymousPlanManager anonymousPlanManager;

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String name = jsonGenerator.getOutputContext().getCurrentName();
        AnonymousFieldInfo anonymousFieldInfo = anonymousFieldService.getAnonymousFieldInfo(name);
        if (anonymousFieldInfo == null){
            jsonGenerator.writeString(s);
            return;
        }
        IAnonymousPlan anonymousPlan = anonymousPlanManager.getAnonymousPlan(anonymousFieldInfo.getAnonymousPlanCode());
        String result = anonymousPlan.anonymousField(s);
        jsonGenerator.writeString(result);
    }

    /**
     * 此方法必须重写，不然会报错找不到对应的handledType
     * @return
     */
    @Override
    public Class<String> handledType() {
        return String.class;
    }
}
