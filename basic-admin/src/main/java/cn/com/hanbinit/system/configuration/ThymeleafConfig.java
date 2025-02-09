package cn.com.hanbinit.system.configuration;

import cn.dev33.satoken.thymeleaf.dialect.SaTokenDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Thymeleaf 配置
 *
 * @author han_bin@outlook.com
 * @since 2025/2/9 21:45
 */
@Configuration
public class ThymeleafConfig {
    @Bean
    public SaTokenDialect saTokenDialect() {
        return new SaTokenDialect();
    }
}
