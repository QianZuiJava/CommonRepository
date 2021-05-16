package cn.hu.configaware;

import org.springframework.core.env.PropertySource;

/**
 * 自动配置加载器接口
 * 从远端获取配置的服务通过实现该接口，被处理器自动加载
 */
public interface IAutoConfigLoader {
    /**
     * 获取配置资源
     *
     * @return PropertySource 配置资源
     */
    PropertySource getPropertySource();
}
