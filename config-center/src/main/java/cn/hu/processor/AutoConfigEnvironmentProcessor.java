package cn.hu.processor;

import cn.hu.configaware.IAutoConfigLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * 环境后置处理器
 * 主要用于获取自定义配置加载器，并获取配置进行组合，放入环境中
 */
public class AutoConfigEnvironmentProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 获取自动配置加载器
        List<IAutoConfigLoader> iAutoConfigLoaders = SpringFactoriesLoader.loadFactories(IAutoConfigLoader.class, null);
        // 组合配置资源：可以将我们的远端配置都放在一个组内，便于管理
        CompositePropertySource compositePropertySource = new CompositePropertySource("RemoteAutoConfig");
        for (IAutoConfigLoader autoConfigLoader : iAutoConfigLoaders){
            if (autoConfigLoader instanceof EnvironmentAware) {
                // 判断是否为Environment：将环境信息进行注册
                EnvironmentAware environmentAware = (EnvironmentAware) autoConfigLoader;
                environmentAware.setEnvironment(environment);
            }
            // 通过配置加载器，获取到远端配置信息
            PropertySource propertySource = autoConfigLoader.getPropertySource();
            // 远端信息组合
            compositePropertySource.addPropertySource(propertySource);
        }
        environment.getPropertySources().addAfter("systemEnvironment", compositePropertySource);
    }
}
