package cn.com.hanbinit.system.service;

import cn.com.hanbinit.system.entity.User;
import cn.com.hanbinit.system.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 * @author han_bin@outlook.com
 * @since 2025/2/10 01:12
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
