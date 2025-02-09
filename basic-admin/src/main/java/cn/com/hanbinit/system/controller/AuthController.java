package cn.com.hanbinit.system.controller;

import cn.com.hanbinit.system.entity.User;
import cn.com.hanbinit.system.service.AuthService;
import cn.com.hanbinit.system.service.UserService;
import cn.com.hanbinit.system.vo.LoginVO;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 认证相关跳转
 *
 * @author han_bin@outlook.com
 * @since 2025/2/9 21:52
 */
@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/login"})
    public String showLoginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginVO loginVO, RedirectAttributes redirectAttributes) {
        User user = userService.findUserByUsername(loginVO.getUsername());
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "用户不存在");
        }
        // 验证用户逻辑
        if (loginVO.getPassword().equals(user.getPassword())) {
            StpUtil.login(10001);
            return "redirect:/index"; // 登录成功后重定向到首页
        } else {
            redirectAttributes.addFlashAttribute("error", "用户名或密码错误");
            return "redirect:/login"; // 登录失败返回登录页面
        }
    }

    @GetMapping("/index")
    public String showIndexPage(){
        return "index";
    }
}
