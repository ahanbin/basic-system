package cn.com.hanbinit.system.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录实体
 *
 * @author han_bin@outlook.com
 * @since 2025/2/10 01:09
 */
@Setter
@Getter
public class LoginVO {
    private String username;
    private String password;
}
