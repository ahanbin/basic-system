package cn.com.hanbinit.system.configuration;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * sa-token 配置
 *
 * @author han_bin@outlook.com
 * @since 2025/2/9 21:50
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {

    private String[] excludePaths = new String[]{
            "/login",
            "/static/**",
            "/favicon.ico"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handler -> {
            SaRouter.match("/**")
                    .notMatch(excludePaths)
                    .check(r -> StpUtil.checkLogin());
        })).addPathPatterns("/**");
    }
}
