package cn.hu.anonymousplan;

import cn.hu.enums.AnonymousPlanCode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class AnonymousUserPasswordPlan implements IAnonymousPlan {
    @Override
    public String anonymousField(String target) {
        if (StringUtils.isEmpty(target)) return "";
        String[] chars = target.split("");
        StringBuilder stringBuilder =  new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(IAnonymousPlan.ANONYMOUS_SYMBOL);
        }
        return stringBuilder.toString();
    }

    @Override
    public AnonymousPlanCode getAnonymousPlanCode() {
        return AnonymousPlanCode.ANONYMOUS_USER_PASSWORD;
    }
}
