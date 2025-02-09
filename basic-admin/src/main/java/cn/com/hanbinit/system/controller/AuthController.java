package cn.com.hanbinit.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ＃[[$ END $]]＃
 *
 * @author han_bin@outlook.com
 * @since 2025/2/9 21:52
 */
@RestController
public class AuthController {
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        // 验证用户逻辑
        if ("admin".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }
}
