package cn.hu.anonymousplan;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class AnonymousPlanManager {
    private static final ConcurrentMap<Integer, IAnonymousPlan> anonymousManager = new ConcurrentHashMap<>();

    AnonymousPlanManager(List<IAnonymousPlan> planList){
        for (IAnonymousPlan plan : planList){
            anonymousManager.put(plan.getAnonymousPlanCode().getAnonymousPlanCode(), plan);
        }
    }

    public IAnonymousPlan getAnonymousPlan(Integer planCode){
        return anonymousManager.get(planCode);
    }
}
