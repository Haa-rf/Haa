package fun.haarf.haa.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: gourf
 * @Date: 2023-07-13  16:26
 * @Description: 忽略认证相关配置
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "auth.ignore")
public class IgnoreUrlsConfig {
    private List<String> urls;
}
