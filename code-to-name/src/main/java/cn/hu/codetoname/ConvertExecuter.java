package cn.hu.codetoname;

import cn.hu.codetoname.model.ConvertContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertExecuter {
    private ConvertContext convertContext;

    private List<Object> targetList = new ArrayList<>();

    @Autowired
    private IConvertHandler convertHandler;

    /**
     * 给上线文赋值语种
     *
     * @param language 语种
     * @return ConvertExecuter 返回对象本身
     */
    public ConvertExecuter language(String language){
        this.convertContext = new ConvertContext(language);
        return this;
    }

    /**
     * 追加目标对象实例
     *
     * @param target 目标对象
     * @return ConvertExecuter 返回对象本身实例
     */
    public ConvertExecuter append(Object target){
        if (target instanceof List) {
            this.targetList.addAll((List)target);
        } else {
          this.targetList.add(target);
        }
        return this;
    }

    /**
     * 执行转换逻辑
     */
    public void execute(){
        // 1 收集标记属性到上下文
        convertHandler.collect(targetList, this.convertContext);
        // 2 给上下文中收集的ConvertInfo赋值
        convertHandler.assignment(this.convertContext);
        // 3 将属性回写到目标对象中
        convertHandler.writeBack(targetList, this.convertContext);
    }
}
