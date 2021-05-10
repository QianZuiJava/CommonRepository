package cn.hu.anonymousplan;

import cn.hu.enums.AnonymousPlanCode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class AnonymousUserName implements IAnonymousPlan {
    @Override
    public String anonymousField(String target) {
        if (StringUtils.isEmpty(target)) return "";
        String[] chars = target.split("");
        // 如果长度为1
        if (chars.length == 1){
            return IAnonymousPlan.ANONYMOUS_SYMBOL;
        }
        // 如果长度为2
        if (chars.length ==  2){
            return chars[0] + IAnonymousPlan.ANONYMOUS_SYMBOL;
        }
        // 其他
        StringBuilder stringBuilder =  new StringBuilder(chars[0]);
        for (int i = 1; i < chars.length - 1; i++) {
            stringBuilder.append(IAnonymousPlan.ANONYMOUS_SYMBOL);
        }
        stringBuilder.append(chars[chars.length - 1]);
        return stringBuilder.toString();
    }

    @Override
    public AnonymousPlanCode getAnonymousPlanCode() {
        return AnonymousPlanCode.ANONYMOUS_USER_NAME;
    }
}
